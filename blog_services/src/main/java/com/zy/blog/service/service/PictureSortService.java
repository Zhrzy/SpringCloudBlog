package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.PictureSort;
import com.zy.blog.view.PictureSortView;

/**
 * 图片分类表 服务类
 *
 * @author 小章鱼
 * @date 2021-09-04
 */
public interface PictureSortService extends ServiceBase<PictureSort> {

    /**
     * 获取图片分类列表
     *
     * @param PictureSortView
     * @return
     */
    public IPage<PictureSort> getPageList(PictureSortView PictureSortView);

    /**
     * 新增图片分类
     *
     * @param PictureSortView
     */
    public String addPictureSort(PictureSortView PictureSortView);

    /**
     * 编辑图片分类
     *
     * @param PictureSortView
     */
    public String editPictureSort(PictureSortView PictureSortView);

    /**
     * 删除图片分类
     *
     * @param PictureSortView
     */
    public String deletePictureSort(PictureSortView PictureSortView);

    /**
     * 置顶图片分类
     *
     * @param PictureSortView
     */
    public String stickPictureSort(PictureSortView PictureSortView);
}
