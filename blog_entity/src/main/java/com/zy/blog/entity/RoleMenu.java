package com.zy.blog.entity;

import com.zy.blog.base.EntityBase;

public class RoleMenu extends EntityBase {
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