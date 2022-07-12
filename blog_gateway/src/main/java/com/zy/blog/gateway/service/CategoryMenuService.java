package com.zy.blog.gateway.service;


import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.CategoryMenu;
import com.zy.blog.view.CategoryMenuView;

import java.util.List;
import java.util.Map;

/**
 * 菜单表 服务类
 *
 * @author 小章鱼
 * @date 2021年11月23日10:41:47
 */
public interface CategoryMenuService extends ServiceBase<CategoryMenu> {

    /**
     * 获取菜单列表
     *
     * @param categoryMenuVO
     * @return
     */
    public Map<String, Object> getPageList(CategoryMenuView categoryMenuVO);

    /**
     * 获取全部菜单列表
     *
     * @param keyword
     * @return
     */
    public List<CategoryMenu> getAllList(String keyword);

    /**
     * 获取所有二级菜单-按钮列表
     *
     * @param keyword
     * @return
     */
    public List<CategoryMenu> getButtonAllList(String keyword);

    /**
     * 新增菜单
     *
     * @param categoryMenuVO
     */
    public String addCategoryMenu(CategoryMenuView categoryMenuVO);

    /**
     * 编辑菜单
     *
     * @param categoryMenuVO
     */
    public String editCategoryMenu(CategoryMenuView categoryMenuVO);

    /**
     * 批量删除菜单
     *
     * @param categoryMenuVO
     */
    public String deleteCategoryMenu(CategoryMenuView categoryMenuVO);

    /**
     * 置顶菜单
     *
     * @param categoryMenuVO
     */
    public String stickCategoryMenu(CategoryMenuView categoryMenuVO);
}
