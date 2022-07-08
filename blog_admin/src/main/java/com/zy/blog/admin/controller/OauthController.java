package com.zy.blog.admin.controller;

import com.zy.blog.commons.feign.OauthFeignService;
import com.zy.blog.commons.feign.PictureFeignClient;
import com.zy.blog.securityconfig.SecurityUser;
import com.zy.blog.service.netutils.WebUtil;
import com.zy.blog.utils.ResultUtil1;
import com.zy.blog.utils.constant.AuthConstants;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.util.RedisUtil;
import com.zy.blog.utils.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员 RestApi
 *
 *  @author 小章鱼
 * @date 2021年02月2日
 */

@RestController
@RequestMapping("/admin")
@Slf4j
public class OauthController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private OauthFeignService oauthFeignService;

    @Autowired
    private PictureFeignClient pictureFeignClient;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private WebUtil webUtil;
    @PostMapping("/login")
    public Object login(@RequestParam( value = "username")String username, @RequestParam("password")String password){
        String uname=username;
        String pword=password;
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("username", uname);
        multiValueMap.add("password", pword);
        multiValueMap.add("grant_type", "password");
        multiValueMap.add("client_id", "c1");
        multiValueMap.add("client_secret", "secret");
        Object tokenInfo =oauthFeignService.oauthToken(multiValueMap);
        if(tokenInfo instanceof LinkedHashMap){
            ResultUtil1.result("success","成功",tokenInfo);
        }else{
//            JSONObject jsonObject = JSONObject.parseObject(tokenInfo.toString());
            return tokenInfo;
        }


        return ResultUtil1.result("success","成功",tokenInfo);
    }
    @PostMapping("/getInfo")
    public Object getInfo(@RequestParam( value = "token")String token){
        log.info("获取用户信息");
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String,Object> map = new HashMap<String,Object>();
        if (securityUser !=null){
            map.put("name",securityUser.getUsername());
            map.put("roles",securityUser.getAuthorities());
            String pictureList = this.pictureFeignClient.getPicture(securityUser.getAvatar(), SysConf.FILE_SEGMENTATION);
            List<String> list = webUtil.getPicture(pictureList);
            if(list.size()>0){
                map.put("avatar",list.get(0));
            }else{
                map.put("avatar","https://avatars.githubusercontent.com/u/62090222?v=4");
            }
        }
        log.info("获取用户信息："+map.toString());
        return ResultUtil1.result("success","成功",map);
    }

    @PostMapping(value = "/logout")
    public String logout() {
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(securityUser!=null){
            String jti =securityUser.getJti();
            redisUtil.sAdd(AuthConstants.Token_black_prefix+ jti,"");
        }
        SecurityContextHolder.clearContext();
        return ResultUtil.resultWithDataAndMessage(SysConf.SUCCESS, MessageConf.OPERATION_SUCCESS,MessageConf.OPERATION_SUCCESS);
    }


}
