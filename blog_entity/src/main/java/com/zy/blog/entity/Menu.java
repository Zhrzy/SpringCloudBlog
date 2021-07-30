package com.zy.blog.entity;

import com.zy.blog.base.EntityBase;

import java.util.List;

public class Menu extends EntityBase {
    private String name;

    /**
     * 菜单级别 （一级分类，二级分类）
     */
    private Integer menuLevel;

    /**
     * 介绍
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

    private Menu parentCategoryMenu;

    private List<Menu> childCategoryMenu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
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

    public Menu getParentCategoryMenu() {
        return parentCategoryMenu;
    }

    public void setParentCategoryMenu(Menu parentCategoryMenu) {
        this.parentCategoryMenu = parentCategoryMenu;
    }

    public List<Menu> getChildCategoryMenu() {
        return childCategoryMenu;
    }

    public void setChildCategoryMenu(List<Menu> childCategoryMenu) {
        this.childCategoryMenu = childCategoryMenu;
    }
}
