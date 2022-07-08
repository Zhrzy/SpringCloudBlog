package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

/**
 * @description:
 * <p>
 *  * 专题Item表
 *  * </p>
 *
 * @author: 小章鱼
 * @date: 2021/9/28 16:14
 **/
@Data
@TableName("t_subject_item")
public class SubjectItem extends EntityBase<SubjectItem> {
    private static final long serialVersionUID = 1L;

    /**
     * 专题UID
     */
    private String subjectUid;
    /**
     * 博客uid
     */
    private String blogUid;

    /**
     * 排序字段，数值越大，越靠前
     */
    private int sort;

    /**
     * 博客
     */
    @TableField(exist = false)
    private Blog blog;
}
