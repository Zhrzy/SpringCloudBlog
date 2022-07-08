package com.zy.blog.service.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.commons.feign.PictureFeignClient;
import com.zy.blog.entity.Admin;
import com.zy.blog.entity.AdminRole;
import com.zy.blog.entity.Role;
import com.zy.blog.entity.Storage;
import com.zy.blog.service.mapper.AdminMapper;
import com.zy.blog.service.mapper.MenuMapper;
import com.zy.blog.service.netutils.WebUtil;
import com.zy.blog.service.service.AdminRoleService;
import com.zy.blog.service.service.AdminService;
import com.zy.blog.service.service.RoleService;
import com.zy.blog.service.service.SysParamsService;
import com.zy.blog.utils.ResultUtil1;
import com.zy.blog.utils.StringUtils;
import com.zy.blog.utils.constant.*;
import com.zy.blog.utils.exception.type.QueryException;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.RedisUtil;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.AdminView;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AdminServiceImpl extends ServiceImplBase<AdminMapper,Admin> implements AdminService {


    @Resource
    private AdminMapper adminMapper;
    @Autowired
    RedisUtil redisUtil;
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private AdminService adminService;
    @Autowired
    private PictureFeignClient pictureFeignClient;
    @Autowired
    private WebUtil webUtil;
    @Autowired
    SysParamsService sysParamsService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AdminRoleService adminRoleService;

    @Override
    public Admin login(String username, String password) {

        System.out.println(username+"--"+password+"===");
        return adminMapper.login(username,password);
    }

    /*获取列表*/
    @Override
    public String getList(AdminView AdminView) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        String pictureResult = null;
        if (StringUtils.isNotEmpty(AdminView.getKeyword())) {
            queryWrapper.like(SQLConf.USER_NAME, AdminView.getKeyword()).or().like(SQLConf.NICK_NAME, AdminView.getKeyword().trim());
        }
        Page<Admin> page = new Page<>();
        page.setCurrent(AdminView.getCurrentPage());
        page.setSize(AdminView.getPageSize());
        // 去除密码
        queryWrapper.select(Admin.class, i -> !i.getProperty().equals(SQLConf.PASS_WORD));
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        IPage<Admin> pageList = adminService.page(page, queryWrapper);
        List<Admin> list = pageList.getRecords();

        final StringBuffer fileUids = new StringBuffer();
        List<String> adminUidList = new ArrayList<>();
        list.forEach(item -> {
            if (StringUtils.isNotEmpty(item.getAvatar())) {
                fileUids.append(item.getAvatar() + SysConf.FILE_SEGMENTATION);
            }
            adminUidList.add(item.getUid());
        });

        Map<String, String> pictureMap = new HashMap<>(Constants.NUM_TEN);
        if (!org.springframework.util.StringUtils.isEmpty(fileUids)) {
            pictureResult = this.pictureFeignClient.getPicture(fileUids.toString(), SysConf.FILE_SEGMENTATION);
        }
        List<Map<String, Object>> picList = webUtil.getPictureMap(pictureResult);
        picList.forEach(item -> {
            pictureMap.put(item.get(SQLConf.UID).toString(), item.get(SQLConf.URL).toString());
        });

        // 获取用户的网盘存储空间
        Map<String, Storage> storageMap = new HashMap<>();
        if (adminUidList.size()>0){
            String storageListJson = pictureFeignClient.getStorageByAdminUid(adminUidList);
            List<Storage> storageList = webUtil.getList(storageListJson, Storage.class);
            storageList.forEach(item -> {
                storageMap.put(item.getAdminUid(), item);
            });
        }


        for (Admin item : list) {
            Role role = roleService.getById(item.getRoleUid());
            item.setRole(role);

            //获取图片
            if (StringUtils.isNotEmpty(item.getAvatar())) {
                List<String> pictureUidsTemp = StringUtils.changeStringToString(item.getAvatar(), SysConf.FILE_SEGMENTATION);
                List<String> pictureListTemp = new ArrayList<>();
                pictureUidsTemp.forEach(picture -> {
                    if (pictureMap.get(picture) != null && pictureMap.get(picture) != "") {
                        pictureListTemp.add(pictureMap.get(picture));
                    }
                });
                item.setPhotoList(pictureListTemp);
            }

            // 设置已用容量大小和最大容量
            Storage storage = storageMap.get(item.getUid());
            if(storage != null) {
                item.setStorageSize(storage.getStorageSize());
                item.setMaxStorageSize(storage.getMaxStorageSize());
            } else {
                // 如果没有，默认为0
                item.setStorageSize(0L);
                item.setMaxStorageSize(0L);
            }
        }
        return ResultUtil1.successWithData(pageList);

    }

    @Override
    public Admin getAdminByUid(String uid) {
        return null;
    }

    @Override
    public String getOnlineAdminList(AdminView AdminView) {
        return null;
    }

    @Override
    public Admin getAdminByUser(String userName) {
        return null;
    }

    @Override
    public Admin getMe() {
        return null;
    }

    @Override
    public void addOnlineAdmin(Admin admin, Long expirationSecond) {

    }

    @Override
    public String addAdmin(AdminView AdminView) {
        String mobile = AdminView.getMobile();
        String userName = AdminView.getUserName();
        String email = AdminView.getEmail();
        if (StringUtils.isEmpty(userName)) {
            return com.zy.blog.utils.util.ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        if (StringUtils.isEmpty(email) && StringUtils.isEmpty(mobile)) {
            throw new QueryException("邮箱和手机号至少一项不能为空");
            /*return com.zy.blog.utils.util.ResultUtil.errorWithMessage("邮箱和手机号至少一项不能为空!!!");*/
        }
        String defaultPassword = sysParamsService.getSysParamsValueByKey(SysConf.SYS_DEFAULT_PASSWORD);
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.USER_NAME, userName);
        Admin temp = adminService.getOne(queryWrapper);
        if (temp == null) {
            Admin admin = new Admin();
            admin.setAvatar(AdminView.getAvatar());
            admin.setEmail(AdminView.getEmail());
            admin.setGender(AdminView.getGender());
            admin.setUserName(AdminView.getUserName());
            admin.setNickName(AdminView.getNickName());
            admin.setRoleUid(AdminView.getRoleUid());
            // 设置为未审核状态
            admin.setStatus(EStatus.ENABLE);
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            //设置默认密码
            admin.setPassWord(encoder.encode(defaultPassword));
            adminService.save(admin);
            //TODO 这里需要通过SMS模块，发送邮件告诉初始密码
            AdminRole adminRole =new AdminRole();
            adminRole.setRoleUid(AdminView.getRoleUid());
            adminRole.setAdminUid(admin.getUid());
            adminRoleService.save(adminRole);

            // 更新成功后，同时申请网盘存储空间
            String maxStorageSize = sysParamsService.getSysParamsValueByKey(SysConf.MAX_STORAGE_SIZE);
            // 初始化网盘的容量, 单位 B
            pictureFeignClient.initStorageSize(admin.getUid(), StringUtils.getLong(maxStorageSize, 0L) * 1024 * 1024);
            return com.zy.blog.utils.util.ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
        }
        return com.zy.blog.utils.util.ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
    }

    @Override
    public String editAdmin(AdminView adminView) {
        Admin admin = adminService.getById(adminView.getUid());
        Assert.notNull(admin, MessageConf.PARAM_INCORRECT);
        //判断修改的对象是否是admin，admin的用户名必须是admin
        /*if (admin.getUserName().equals(SysConf.ADMIN) && !adminView.getUserName().equals(SysConf.ADMIN)) {
            return ResultUtil.errorWithMessage("超级管理员用户名必须为admin");
        }*/
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.eq(SQLConf.USER_NAME, adminView.getUserName());
        List<Admin> adminList = adminService.list(queryWrapper);
        if (adminList != null) {
            for (Admin item : adminList) {
                if (item.getUid().equals(adminView.getUid())) {
                    continue;
                } else {
                    return ResultUtil.errorWithMessage("修改失败，用户名存在");
                }
            }
        }

        // 判断是否更改了RoleUid，更新redis中admin的URL访问路径
        if (StringUtils.isNotEmpty(adminView.getRoleUid()) && !adminView.getRoleUid().equals(admin.getRoleUid())) {
            redisUtil.delete(RedisConf.ADMIN_VISIT_MENU + RedisConf.SEGMENTATION + admin.getUid());
        }
        admin.setUserName(adminView.getUserName());
        admin.setAvatar(adminView.getAvatar());
        admin.setNickName(adminView.getNickName());
        admin.setGender(adminView.getGender());
        admin.setEmail(adminView.getEmail());
        admin.setQqNumber(adminView.getQqNumber());
        admin.setGithub(adminView.getGithub());
        admin.setGitee(adminView.getGitee());
        admin.setOccupation(adminView.getOccupation());
        admin.setUpdateTime(new Date());
        admin.setMobile(adminView.getMobile());
        admin.setRoleUid(adminView.getRoleUid());
        // 无法直接修改密码，只能通过重置密码完成密码修改
        admin.setPassWord(null);
        admin.updateById();

        // 更新完成后，判断是否调整了网盘的大小
        String result = pictureFeignClient.editStorageSize(admin.getUid(), adminView.getMaxStorageSize() * 1024 * 1024);
        Map<String, String> resultMap = webUtil.getMessage(result);
        if(SysConf.SUCCESS.equals(resultMap.get(SysConf.CODE))) {
            return ResultUtil.successWithMessage(resultMap.get(SysConf.MESSAGE));
        } else {
            return ResultUtil.errorWithMessage(resultMap.get(SysConf.MESSAGE));
        }
    }

    @Override
    public String editMe(AdminView AdminView) {
        return null;
    }

    @Override
    public String changePwd(String oldPwd, String newPwd) {
        String adminUid = RequestHolder.getAdminUid();
        if (StringUtils.isEmpty(oldPwd) || StringUtils.isEmpty(newPwd)) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        Admin admin = adminService.getById(adminUid);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean isPassword = encoder.matches(oldPwd, admin.getPassWord());
        if (isPassword) {
            admin.setPassWord(encoder.encode(newPwd));
            admin.setUpdateTime(new Date());
            admin.updateById();
            return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
        } else {
            return ResultUtil.errorWithMessage(MessageConf.ERROR_PASSWORD);
        }
    }

    @Override
    public String resetPwd(AdminView adminView) {
        String defaultPassword = sysParamsService.getSysParamsValueByKey(SysConf.SYS_DEFAULT_PASSWORD);
        // 获取当前用户的管理员uid
        String adminUid = RequestHolder.getAdminUid();
        Admin admin = adminService.getById(adminView.getUid());
        System.out.println(admin.getUid()+"===");
        // 判断是否是admin重置密码【其它超级管理员，无法重置admin的密码】
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        admin.setPassWord(encoder.encode(defaultPassword));
        admin.setUpdateTime(new Date());
        admin.updateById();
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);

    }

    @Override
    public String deleteBatchAdmin(List<String> adminUids) {
        boolean checkResult = StringUtils.checkUidList(adminUids);
        if (!checkResult) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        List<Admin> adminList = new ArrayList<>();
        adminUids.forEach(item -> {
            Admin admin = new Admin();
            admin.setUid(item);
            admin.setStatus(EStatus.DISABLED);
            admin.setUpdateTime(new Date());
            adminList.add(admin);
        });
        adminService.updateBatchById(adminList);
        return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
    }

    @Override
    public String forceLogout(List<String> tokenList) {
        return null;
    }


}
