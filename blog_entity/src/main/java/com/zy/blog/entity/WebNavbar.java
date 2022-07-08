package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/5/28 16:00
 **/

@TableName("t_web_navbar")
public class WebNavbar extends EntityBase<WebNavbar> implements Comparable<WebNavbar> {

    private static final long serialVersionUID = 1L;

    /**
     * 导航栏名称
     */
    private String name;

    /**
     * 导航栏级别 （一级分类，二级分类）
     */
    private Integer navbarLevel;

    /**
     * 导航栏介绍
     */
    private String summary;

    /**
     * Icon图标
     */
    private String icon;

    /**
     * 父UID
     */
    private String parentUid;

    /**
     * URL地址
     */
    private String url;

    /**
     * 排序字段(越大越靠前)
     */
    private Integer sort;

    /**
     * 是否显示  1:是  0:否
     */
    private Integer isShow;

    /**
     * 是否跳转外部URL
     */
    private Integer isJumpExternalUrl;

    /**
     * 父菜单
     */
    @TableField(exist = false)
    private WebNavbar parentWebNavbar;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<WebNavbar> childWebNavbar;

    @Override
    public int compareTo(WebNavbar o) {

        if (this.sort >= o.getSort()) {
            return -1;
        }
        return 1;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNavbarLevel() {
        return navbarLevel;
    }

    public void setNavbarLevel(Integer navbarLevel) {
        this.navbarLevel = navbarLevel;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentUid() {
        return parentUid;
    }

    public void setParentUid(String parentUid) {
        this.parentUid = parentUid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsJumpExternalUrl() {
        return isJumpExternalUrl;
    }

    public void setIsJumpExternalUrl(Integer isJumpExternalUrl) {
        this.isJumpExternalUrl = isJumpExternalUrl;
    }

    public WebNavbar getParentWebNavbar() {
        return parentWebNavbar;
    }

    public void setParentWebNavbar(WebNavbar parentWebNavbar) {
        this.parentWebNavbar = parentWebNavbar;
    }

    public List<WebNavbar> getChildWebNavbar() {
        return childWebNavbar;
    }

    public void setChildWebNavbar(List<WebNavbar> childWebNavbar) {
        this.childWebNavbar = childWebNavbar;
    }
}
