package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Tag;
import com.zy.blog.view.TagView;

import java.util.List;

/**
 * @author: 小章鱼
 * @description:
 * @date: 2021/8/26 22:32
 **/
public interface TagService extends ServiceBase<Tag> {
    /**
     * 获取博客标签列表
     *
     * @param tagVO
     * @return
     */
    public IPage<Tag> getPageList(TagView tagVO);

    /**
     * 获取全部博客标签列表
     *
     * @return
     */
    public List<Tag> getList();

    /**
     * 新增博客标签
     *
     * @param tagVO
     */
    public String addTag(TagView tagVO);

    /**
     * 编辑博客标签
     *
     * @param tagVO
     */
    public String editTag(TagView tagVO);

    /**
     * 批量删除博客标签
     *
     * @param tagVOList
     */
    public String deleteBatchTag(List<TagView> tagVOList);

    /**
     * 置顶博客标签
     *
     * @param tagVO
     */
    public String stickTag(TagView tagVO);

    /**
     * 通过点击量排序博客
     *
     * @return
     */
    public String tagSortByClickCount();

    /**
     * 通过引用量排序博客
     *
     * @return
     */
    public String tagSortByCite();

    /**
     * 获取热门标签
     *
     * @return
     */
    public List<Tag> getHotTag(Integer hotTagCount);

    /**
     * 获取一个排序最高的标签
     *
     * @return
     */
    public Tag getTopTag();

}
