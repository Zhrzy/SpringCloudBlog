package com.zy.blog.view;

import com.zy.blog.base.ViewBase;
import com.zy.blog.utils.annotion.validator.annotion.NotBlank;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import lombok.Data;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/8/22 23:08
 **/
@Data
public class SubjectView  extends ViewBase {
    /**
     * 专题名
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String subjectName;

    /**
     * 专题介绍
     */
    private String summary;

    /**
     * 封面图片UID
     */
    private String fileUid;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 专题点击数
     */
    private String clickCount;

    /**
     * 专题收藏数
     */
    private String collectCount;
}
