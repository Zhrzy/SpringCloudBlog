package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.FeedBack;
import com.zy.blog.view.FeedBackView;

import java.util.List;

/**
 * 反馈表 服务类
 *
 * @author 小章鱼
 * @date 2021-09-08
 */
public interface FeedbackService extends ServiceBase<FeedBack> {

    /**
     * 获取反馈列表
     *
     * @param feedbackVO
     * @return
     */
    public IPage<FeedBack> getPageList(FeedBackView feedbackVO);

    /**
     * 新增反馈
     *
     * @param feedbackVO
     */
    public String addFeedback(FeedBackView feedbackVO);

    /**
     * 编辑反馈
     *
     * @param feedbackVO
     */
    public String editFeedback(FeedBackView feedbackVO);

    /**
     * 批量删除反馈
     *
     * @param feedbackVOList
     */
    public String deleteBatchFeedback(List<FeedBackView> feedbackVOList);
}
