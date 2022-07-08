package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.User;
import com.zy.blog.view.UserView;

/*
import javax.servlet.http.HttpServletRequest;
*/
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 管理员表 服务类
 *
 * @author 小章鱼
 * @date 2021-09-04
 */
public interface UserService extends ServiceBase<User> {

    /**
     * 记录用户信息
     *
     * @param response
     */

    User insertUserInfo(HttpServletRequest request, String response);


    /**
     * 通过source uuid获取用户类
     *
     * @param source
     * @param uuid
     * @return
     */
    User getUserBySourceAnduuid(String source, String uuid);

    /**
     * 获取用户数
     *
     * @param status
     * @return
     */
    public Integer getUserCount(int status);

    /**
     * 设置Request相关，如浏览器，IP，IP来源
     *
     * @param user
     * @return
     */
    public User serRequestInfo(User user);

    /**
     * 通过ids获取用户列表
     *
     * @param ids
     * @return
     */
    public List<User> getUserListByIds(List<String> ids);

    /**
     * 获取用户列表
     *
     * @param UserView
     * @return
     */
    public IPage<User> getPageList(UserView UserView);

    /**
     * 新增用户
     *
     * @param UserView
     */
    public String addUser(UserView UserView);

    /**
     * 编辑用户
     *
     * @param UserView
     */
    public String editUser(UserView UserView);

    /**
     * 删除用户
     *
     * @param UserView
     */
    public String deleteUser(UserView UserView);

    /**
     * 重置用户密码
     *
     * @param UserView
     * @return
     */
    public String resetUserPassword(UserView UserView);


}
