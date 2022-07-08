package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/9/28 16:13
 **/

@TableName("t_category_menu")
public class CategoryMenu extends EntityBase<CategoryMenu> implements Comparable<CategoryMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单级别 （一级分类，二级分类）
     */
    private Integer menuLevel;

    /**
     * 菜单类型 （菜单，按钮）
     */
    private Integer menuType;

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

    /**
     * 是否显示  1: 是  0: 否
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
    private CategoryMenu parentCategoryMenu;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<CategoryMenu> childCategoryMenu;

    @Override
    public int compareTo(CategoryMenu o) {

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

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
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

    public CategoryMenu getParentCategoryMenu() {
        return parentCategoryMenu;
    }

    public void setParentCategoryMenu(CategoryMenu parentCategoryMenu) {
        this.parentCategoryMenu = parentCategoryMenu;
    }

    public List<CategoryMenu> getChildCategoryMenu() {
        return childCategoryMenu;
    }

    public void setChildCategoryMenu(List<CategoryMenu> childCategoryMenu) {
        this.childCategoryMenu = childCategoryMenu;
    }
}
