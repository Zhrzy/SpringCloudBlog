package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/9/28 16:13
 **/

@TableName("t_comment_report")
@Data
public class CommentReport extends EntityBase<CommentReport> {

    private static final long serialVersionUID = 1L;

    /**
     * 举报人UID
     */
    private String userUid;

    /**
     * 被举报的评论Uid
     */
    private String reportCommentUid;

    /**
     * 被举报的用户uid
     */
    private String reportUserUid;


    /**
     * 举报原因
     */
    private String content;

    /**
     * 进展状态: 0 未查看   1: 已查看  2：已处理
     */
    private Integer progress;

}
