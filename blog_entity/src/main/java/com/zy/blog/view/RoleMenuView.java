package com.zy.blog.view;

import com.zy.blog.base.ViewBase;

public class RoleMenuView extends ViewBase {
    private String roleUid;

    private String menuUid;

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid == null ? null : roleUid.trim();
    }

    public String getMenuUid() {
        return menuUid;
    }

    public void setMenuUid(String menuUid) {
        this.menuUid = menuUid == null ? null : menuUid.trim();
    }
}