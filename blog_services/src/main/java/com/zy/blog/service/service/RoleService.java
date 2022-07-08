package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Role;
import com.zy.blog.view.RoleView;

/**
 * 角色表 服务类
 *
 * @author 小章鱼
 * @date 2021-09-04
 */
public interface RoleService extends ServiceBase<Role> {

    /**
     * 获取角色列表
     *
     * @param RoleView
     * @return
     */
    public IPage<Role> getPageList(RoleView RoleView);

    /**
     * 新增角色
     *
     * @param RoleView
     */
    public String addRole(RoleView RoleView);

    /**
     * 编辑角色
     *
     * @param RoleView
     */
    public String editRole(RoleView RoleView);

    /**
     * 删除角色
     *
     * @param RoleView
     */
    public String deleteRole(RoleView RoleView);

}
