package com.zy.blog.entity;


import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

/**
 * <p>
 * 角色信息表
 * </p>
 */

@TableName(value = "t_role")
public class Role extends EntityBase<Role> {

    private static final long serialVersionUID = 1L;


    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 介绍
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String summary;

    /**
     * 该角色所能管辖的区域
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
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