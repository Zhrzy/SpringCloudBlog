package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Role;
import com.zy.blog.entity.RoleMenu;
import com.zy.blog.view.RoleView;

/**
 * 角色表 服务类
 *
 * @author 小章鱼
 * @date 2021-09-04
 */
public interface RoleMenuService extends ServiceBase<RoleMenu> {



    /**
     * 新增角色
     *
     * @param RoleView
     */
    public String addRoleMenu(String roleId,String menuUids);

    public String deleteRoleMenu(String roleIds);
    public String updateRoleMenu(RoleView RoleView);


}
