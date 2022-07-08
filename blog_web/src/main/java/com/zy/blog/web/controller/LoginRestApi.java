package com.zy.blog.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.blog.commons.feign.PictureFeignClient;
import com.zy.blog.entity.SystemConfig;
import com.zy.blog.entity.User;
import com.zy.blog.service.netutils.RabbitMqUtil;
import com.zy.blog.service.netutils.WebUtil;
import com.zy.blog.service.service.SystemConfigService;
import com.zy.blog.service.service.UserService;
import com.zy.blog.service.service.WebConfigService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.*;
import com.zy.blog.utils.constant.*;
import com.zy.blog.utils.enums.EOpenStatus;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.*;
import com.zy.blog.view.UserView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户登录RestApi，系统自带的登录注册功能
 * 第三方登录请移步AuthRestApi
 *
 * @author 小章鱼
 * @date 2021年5月6日17:50:23
 */
@RestController
@RefreshScope
@RequestMapping("/login")
@Api(value = "登录管理相关接口", tags = {"登录管理相关接口"})
@Slf4j
public class LoginRestApi {

    @Autowired
    private RabbitMqUtil rabbitMqUtil;
    @Autowired
    private WebConfigService webConfigService;
    @Resource
    private PictureFeignClient pictureFeignClient;
    @Autowired
    private WebUtil webUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SystemConfigService systemConfigService;
    /*@Value(value = "${BLOG.USER_TOKEN_SURVIVAL_TIME}")*/
    private Long userTokenSurvivalTime=new Long(72000);

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/login")
    public String login(@Validated({GetOne.class}) @RequestBody UserView userVO, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        Boolean isOpenLoginType = webConfigService.isOpenLoginType(RedisConf.PASSWORD);
        if (!isOpenLoginType) {
            return ResultUtil.result(SysConf.ERROR, "后台未开启该登录方式!");
        }
        String userName = userVO.getUserName();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(wrapper -> wrapper.eq(SQLConf.USER_NAME, userName).or().eq(SQLConf.EMAIL, userName));
        queryWrapper.last(SysConf.LIMIT_ONE);
        User user = userService.getOne(queryWrapper);
        if (user == null || EStatus.DISABLED == user.getStatus()) {
            return ResultUtil.result(SysConf.ERROR, "用户不存在");
        }
        if (EStatus.FREEZE == user.getStatus()) {
            return ResultUtil.result(SysConf.ERROR, "用户账号未激活");
        }
        if (StringUtils.isNotEmpty(user.getPassWord()) && user.getPassWord().equals(MD5Utils.string2MD5(userVO.getPassWord()))) {
            // 更新登录信息
            HttpServletRequest request = RequestHolder.getRequest();
            String ip = IpUtils.getIpAddr(request);
            Map<String, String> userMap = IpUtils.getOsAndBrowserInfo(request);
            user.setBrowser(userMap.get(SysConf.BROWSER));
            user.setOs(userMap.get(SysConf.OS));
            user.setLastLoginIp(ip);
            user.setLastLoginTime(new Date());
            // 登录成功后，次数+1
            Integer count = user.getLoginCount() + 1;
            user.setLoginCount(count);
            user.updateById();
            // 获取用户头像
            if (!StringUtils.isEmpty(user.getAvatar())) {
                String avatarResult = pictureFeignClient.getPicture(user.getAvatar(), ",");
                List<String> picList = webUtil.getPicture(avatarResult);
                if (picList != null && picList.size() > 0) {
                    user.setPhotoUrl(webUtil.getPicture(avatarResult).get(0));
                }
            }
            // 生成token
            String token = StringUtils.getUUID();
            // 过滤密码
            user.setPassWord("");
            //将从数据库查询的数据缓存到redis中
            redisUtil.setEx(RedisConf.USER_TOKEN + Constants.SYMBOL_COLON + token, JsonUtils.objectToJson(user), userTokenSurvivalTime, TimeUnit.HOURS);
            log.info("登录成功，返回token: ", token);
            return ResultUtil.result(SysConf.SUCCESS, token);
        } else {
            return ResultUtil.result(SysConf.ERROR, "账号或密码错误");
        }
    }

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping("/register")
    public String register(@Validated({Insert.class}) @RequestBody UserView userVO, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        // 判断是否开启登录方式
        Boolean isOpenLoginType = webConfigService.isOpenLoginType(RedisConf.PASSWORD);
        if (!isOpenLoginType) {
            return ResultUtil.result(SysConf.ERROR, "后台未开启注册功能!");
        }
        if (userVO.getUserName().length() < Constants.NUM_FIVE || userVO.getUserName().length() >= Constants.NUM_TWENTY || userVO.getPassWord().length() < Constants.NUM_FIVE || userVO.getPassWord().length() >= Constants.NUM_TWENTY) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        }
        HttpServletRequest request = RequestHolder.getRequest();
        String ip = IpUtils.getIpAddr(request);
        Map<String, String> map = IpUtils.getOsAndBrowserInfo(request);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(wrapper -> wrapper.eq(SQLConf.USER_NAME, userVO.getUserName()).or().eq(SQLConf.EMAIL, userVO.getEmail()));
        queryWrapper.eq(SysConf.STATUS, EStatus.ENABLE);
        queryWrapper.last(SysConf.LIMIT_ONE);
        User user = userService.getOne(queryWrapper);
        if (user != null) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.USER_OR_EMAIL_EXIST);
        }
        user = new User();
        user.setUserName(userVO.getUserName());
        user.setNickName(userVO.getNickName());
        user.setPassWord(MD5Utils.string2MD5(userVO.getPassWord()));
        user.setEmail(userVO.getEmail());
        // 设置账号来源，蘑菇博客
        user.setSource(com.zy.blog.web.global.SysConf.MOGU);
        user.setLastLoginIp(ip);
        user.setBrowser(map.get(SysConf.BROWSER));
        user.setOs(map.get(SysConf.OS));

        // 判断是否开启用户邮件激活状态
        SystemConfig systemConfig = systemConfigService.getConfig();
        String openEmailActivate = systemConfig.getOpenEmailActivate();
        String resultMessage = "注册成功";
        if (EOpenStatus.OPEN.equals(openEmailActivate)) {
            user.setStatus(EStatus.FREEZE);
        } else {
            // 未开启注册用户邮件激活，直接设置成激活状态
            user.setStatus(EStatus.ENABLE);
        }
        user.insert();

        // 判断是否需要发送邮件通知
        if (EOpenStatus.OPEN.equals(openEmailActivate)) {
            // 生成随机激活的token
            String token = StringUtils.getUUID();
            // 过滤密码
            user.setPassWord("");
            //将从数据库查询的数据缓存到redis中，用于用户邮箱激活，1小时后过期
            redisUtil.setEx(RedisConf.ACTIVATE_USER + RedisConf.SEGMENTATION + token, JsonUtils.objectToJson(user), 1, TimeUnit.HOURS);
            // 发送邮件，进行账号激活
            rabbitMqUtil.sendActivateEmail(user, token);
            resultMessage = "注册成功，请登录邮箱进行账号激活";
        }
        return ResultUtil.result(SysConf.SUCCESS, resultMessage);
    }

    @ApiOperation(value = "激活用户账号", notes = "激活用户账号")
    @GetMapping("/activeUser/{token}")
    public String bindUserEmail(@PathVariable("token") String token) {
        // 从redis中获取用户信息
        String userInfo = redisUtil.get(RedisConf.ACTIVATE_USER + RedisConf.SEGMENTATION + token);
        if (StringUtils.isEmpty(userInfo)) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.INVALID_TOKEN);
        }
        User user = JsonUtils.jsonToPojo(userInfo, User.class);
        if (EStatus.FREEZE != user.getStatus()) {
            return ResultUtil.result(SysConf.ERROR, "用户账号已经被激活");
        }
        user.setStatus(EStatus.ENABLE);
        user.updateById();

        // 更新成功后，需要把该用户名下其它未激活的用户删除【删除】
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.USER_NAME, user.getUserName());
        queryWrapper.ne(SQLConf.UID, user.getUid());
        queryWrapper.ne(SQLConf.STATUS, EStatus.ENABLE);
        List<User> userList = userService.list(queryWrapper);
        if (userList.size() > 0) {
            List<String> uidList = new ArrayList<>();
            userList.forEach(item -> {
                uidList.add(item.getUid());
            });
            // 移除所有未激活的用户【该用户名下的】
            userService.removeByIds(uidList);
        }

        return ResultUtil.result(SysConf.SUCCESS, MessageConf.OPERATION_SUCCESS);
    }

    @ApiOperation(value = "退出登录", notes = "退出登录", response = String.class)
    @PostMapping(value = "/logout")
    public String logout(@ApiParam(name = "token", value = "token令牌", required = false) @RequestParam(name = "token", required = false) String token) {
        if (StringUtils.isEmpty(token)) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.OPERATION_FAIL);
        }
        redisUtil.set(RedisConf.USER_TOKEN + Constants.SYMBOL_COLON + token, "");
        return ResultUtil.result(SysConf.SUCCESS, "退出成功");
    }

}
