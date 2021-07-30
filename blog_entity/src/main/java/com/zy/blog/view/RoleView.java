package com.zy.blog.view;

import com.zy.blog.base.ViewBase;

public class RoleView extends ViewBase {
    private String roleName;

    private String summary;

    private String categoryMenuUids;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getCategoryMenuUids() {
        return categoryMenuUids;
    }

    public void setCategoryMenuUids(String categoryMenuUids) {
        this.categoryMenuUids = categoryMenuUids == null ? null : categoryMenuUids.trim();
    }
}