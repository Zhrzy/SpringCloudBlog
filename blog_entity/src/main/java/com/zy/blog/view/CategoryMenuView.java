package com.zy.blog.view;

import com.zy.blog.base.ViewBase;
import com.zy.blog.utils.annotion.validator.annotion.*;
import com.zy.blog.utils.annotion.validator.group.*;
import lombok.Data;


@Data
public class CategoryMenuView extends ViewBase<CategoryMenuView> {

    /**
     * 菜单名称
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String name;

    /**
     * 菜单级别 （一级分类，二级分类）
     */
    @IntegerNotNull(groups = {Insert.class, Update.class})
    private Integer menuLevel;

    /**
     * 菜单类型 （菜单，按钮）
     */
    @IntegerNotNull(groups = {Insert.class, Update.class})
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
    @NotBlank(groups = {Insert.class, Update.class})
    private String url;

    /**
     * 排序字段(越大越靠前)
     */
    private Integer sort;

    /**
     * 是否显示  1: 是  0: 否
     */
    @IntegerNotNull(groups = {Insert.class, Update.class})
    private Integer isShow;

    /**
     * 是否跳转外部URL，如果是，那么路由为外部的链接
     */
    @IntegerNotNull(groups = {Insert.class, Update.class})
    private Integer isJumpExternalUrl;

}
