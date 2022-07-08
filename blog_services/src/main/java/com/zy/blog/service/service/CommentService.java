package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Comment;
import com.zy.blog.view.CommentView;

import java.util.List;

/**
 * 评论表 服务类
 *
 * @author 小章鱼
 * @date 2021-09-08
 */
public interface CommentService extends ServiceBase<Comment> {

    /**
     * 获取评论数目
     *
     * @author xzx19950624@qq.com
     * @date 2021年10月22日下午3:43:38
     */
    Integer getCommentCount(int status);

    /**
     * 获取评论列表
     *
     * @param CommentView
     * @return
     */
    IPage<Comment> getPageList(CommentView CommentView);

    /**
     * 新增评论
     *
     * @param CommentView
     */
    String addComment(CommentView CommentView);

    /**
     * 编辑评论
     *
     * @param CommentView
     */
    String editComment(CommentView CommentView);

    /**
     * 删除评论
     *
     * @param CommentView
     */
    String deleteComment(CommentView CommentView);

    /**
     * 批量删除评论
     *
     * @param CommentViewList
     */
    String deleteBatchComment(List<CommentView> CommentViewList);

    /**
     *
     * @param blogUidList
     * @return
     */
    String batchDeleteCommentByBlogUid(List<String> blogUidList);


}
