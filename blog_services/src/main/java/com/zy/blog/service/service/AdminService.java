package com.zy.blog.service.service;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Admin;
import com.zy.blog.view.AdminView;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AdminService extends ServiceBase<Admin> {

    public Admin login(@RequestParam("username")String username, @RequestParam("password")String password);
    /**
     * 获取管理员列表
     *
     * @param AdminView
     * @return
     */
    public String getList(AdminView AdminView);


    /**
     * 通过UID获取Admin
     *
     * @param uid
     * @return
     */
    public Admin getAdminByUid(String uid);

    /**
     * 获取在线用户列表
     *
     * @param AdminView
     * @return
     */
    public String getOnlineAdminList(AdminView AdminView);

    /**
     * Web端通过用户名获取一个Admin
     *
     * @param userName
     * @return
     */
    public Admin getAdminByUser(String userName);

    /**
     * 获取当前管理员
     *
     * @return
     */
    public Admin getMe();

    /**
     * 添加在线用户
     *
     * @param admin            管理员
     * @param expirationSecond 过期时间【秒】
     */
    public void addOnlineAdmin(Admin admin, Long expirationSecond);



    /**
     * 添加管理员
     *
     * @param AdminView
     * @return
     */
    public String addAdmin(AdminView AdminView);

    /**
     * 编辑管理员
     *
     * @param AdminView
     * @return
     */
    public String editAdmin(AdminView AdminView);

    /**
     * 编辑当前管理员信息
     *
     * @return
     */
    public String editMe(AdminView AdminView);

    /**
     * 修改密码
     *
     * @return
     */
    public String changePwd(String oldPwd, String newPwd);

    /**
     * 重置密码
     *
     * @param AdminView
     * @return
     */
    public String resetPwd(AdminView AdminView);

    /**
     * 批量删除管理员
     *
     * @param adminUids
     * @return
     */
    public String deleteBatchAdmin(List<String> adminUids);

    public String forceLogout(List<String> tokenList);


}
