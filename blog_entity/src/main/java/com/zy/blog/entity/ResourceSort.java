package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/9/28 16:13
 **/
@Data
@TableName(value = "t_resource_sort")
public class ResourceSort extends EntityBase<ResourceSort> {
    private static final long serialVersionUID = 1L;


    /**
     * 分类名
     */
    private String sortName;

    /**
     * 分类介绍
     */
    private String content;

    /**
     * 分类图片UID
     */
    private String fileUid;

    /**
     * 分类点击数
     */
    private String clickCount;

    /**
     * 排序字段，数值越大，越靠前
     */
    private int sort;

    /**
     * 分类图
     */
    @TableField(exist = false)
    private List<String> photoList;
}