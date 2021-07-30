package com.zy.blog.view;

import com.zy.blog.base.ViewBase;

public class AdminRoleView extends ViewBase {
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