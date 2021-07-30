package com.zy.blog.entity;

import com.zy.blog.base.EntityBase;

public class AdminRole extends EntityBase {
    private String adminUid;

    private String roleUid;

    public String getAdminUid() {
        return adminUid;
    }

    public void setAdminUid(String adminUid) {
        this.adminUid = adminUid == null ? null : adminUid.trim();
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid == null ? null : roleUid.trim();
    }
}