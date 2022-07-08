package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.StudyVideo;
import com.zy.blog.view.StudyVideoView;

import java.util.List;

/**
 * 学习视频表 服务类
 *
 * @author 小章鱼
 * @date 2021年10月19日21:26:25
 */
public interface StudyVideoService extends ServiceBase<StudyVideo> {
    /**
     * 获取学习视频列表
     *
     * @param StudyVideoView
     * @return
     */
    public IPage<StudyVideo> getPageList(StudyVideoView StudyVideoView);

    /**
     * 新增学习视频
     *
     * @param StudyVideoView
     */
    public String addStudyVideo(StudyVideoView StudyVideoView);

    /**
     * 编辑学习视频
     *
     * @param StudyVideoView
     */
    public String editStudyVideo(StudyVideoView StudyVideoView);

    /**
     * 批量删除学习视频
     *
     * @param StudyVideoViewList
     */
    public String deleteBatchStudyVideo(List<StudyVideoView> StudyVideoViewList);
}
