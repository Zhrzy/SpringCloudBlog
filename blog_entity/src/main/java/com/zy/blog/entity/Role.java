package com.zy.blog.entity;



/**
 * <p>
 * 角色信息表
 * </p>
 */

public class Role{

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 介绍
     */
    private String summary;

    /**
     * 该角色所能操作的菜单uid
     */
    private String categoryMenuUids;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCategoryMenuUids() {
        return categoryMenuUids;
    }

    public void setCategoryMenuUids(String categoryMenuUids) {
        this.categoryMenuUids = categoryMenuUids;
    }
}