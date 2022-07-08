package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.ResourceSort;
import com.zy.blog.view.ResourceSortView;

import java.util.List;

/**
 * 资源分类表 服务类
 *
 * @author 小章鱼
 * @date 2021-09-04
 */
public interface ResourceSortService extends ServiceBase<ResourceSort> {

    /**
     * 获取资源分类列表
     *
     * @param ResourceSortView
     * @return
     */
    public IPage<ResourceSort> getPageList(ResourceSortView ResourceSortView);

    /**
     * 新增资源分类
     *
     * @param ResourceSortView
     */
    public String addResourceSort(ResourceSortView ResourceSortView);

    /**
     * 编辑资源分类
     *
     * @param ResourceSortView
     */
    public String editResourceSort(ResourceSortView ResourceSortView);

    /**
     * 批量删除资源分类
     *
     * @param ResourceSortViewList
     */
    public String deleteBatchResourceSort(List<ResourceSortView> ResourceSortViewList);

    /**
     * 置顶资源分类
     *
     * @param ResourceSortView
     */
    public String stickResourceSort(ResourceSortView ResourceSortView);
}
