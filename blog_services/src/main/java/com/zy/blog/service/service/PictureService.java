package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Picture;
import com.zy.blog.view.PictureView;

import java.util.List;

/**
 * 图片表 服务类
 *
 * @author 小章鱼
 * @date 2021年9月17日16:17:22
 */
public interface PictureService extends ServiceBase<Picture> {

    /**
     * 获取图片列表
     *
     * @param PictureView
     * @return
     */
    public IPage<Picture> getPageList(PictureView PictureView);

    /**
     * 新增图片
     *
     * @param PictureViewList
     * @return
     */
    public String addPicture(List<PictureView> PictureViewList);

    /**
     * 编辑图片
     *
     * @param PictureView
     * @return
     */
    public String editPicture(PictureView PictureView);

    /**
     * 批量删除图片
     *
     * @param PictureView
     */
    public String deleteBatchPicture(PictureView PictureView);

    /**
     * 设置图片封面
     *
     * @param PictureView
     */
    public String setPictureCover(PictureView PictureView);

    /**
     * 获取最新图片,按时间排序
     *
     * @return
     */
    public Picture getTopOne();
}
