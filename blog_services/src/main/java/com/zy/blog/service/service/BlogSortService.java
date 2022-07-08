package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.BlogSort;
import com.zy.blog.view.BlogSortView;

import java.util.List;

/**
 * @author: 小章鱼
 * @description:
 * @date: 2021/8/26 22:32
 **/
public interface BlogSortService extends ServiceBase<BlogSort> {
    /**
     * 获取博客分类列表
     *
     * @param BlogSortView
     * @return
     */
    public IPage<BlogSort> getPageList(BlogSortView BlogSortView);

    /**
     * 获取博客分类列表
     *
     * @return
     */
    public List<BlogSort> getList();

    /**
     * 新增博客分类
     *
     * @param BlogSortView
     */
    public String addBlogSort(BlogSortView BlogSortView);

    /**
     * 编辑博客分类
     *
     * @param BlogSortView
     */
    public String editBlogSort(BlogSortView BlogSortView);

    /**
     * 批量删除博客分类
     *
     * @param blogSortVoList
     */
    public String deleteBatchBlogSort(List<BlogSortView> blogSortVoList);

    /**
     * 置顶博客分类
     *
     * @param BlogSortView
     */
    public String stickBlogSort(BlogSortView BlogSortView);

    /**
     * 通过点击量排序博客
     *
     * @return
     */
    public String blogSortByClickCount();

    /**
     * 通过引用量排序博客
     *
     * @return
     */
    public String blogSortByCite();

    /**
     * 获取排序最高的一个博客分类
     *
     * @return
     */
    public BlogSort getTopOne();

}
