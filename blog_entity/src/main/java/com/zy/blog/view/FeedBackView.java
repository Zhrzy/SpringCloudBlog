package com.zy.blog.view;

import com.zy.blog.base.ViewBase;
import com.zy.blog.utils.annotion.validator.annotion.*;
import com.zy.blog.utils.annotion.validator.group.*;
import lombok.Data;

@Data
public class FeedBackView extends ViewBase {

    /**
     * 用户uid
     */
    private String userUid;

    /**
     * 标题
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String title;

    /**
     * 反馈的内容
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String content;

    /**
     * 回复
     */
    private String reply;

    /**
     * 反馈状态： 0：已开启  1：进行中  2：已完成  3：已拒绝
     */
    private Integer feedbackStatus;

}