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
@TableName(value = "t_picture_sort")
public class PictureSort extends EntityBase<PictureSort> {

    /**
     *
     */
    private static final long serialVersionUID = 3454006152368184626L;

    /**
     * 父UID
     */
    private String parentUid;

    /**
     * 分类名
     */
    private String name;

    /**
     * 分类图片Uid
     */
    private String fileUid;

    /**
     * 排序字段，数值越大，越靠前
     */
    private int sort;

    /**
     * 是否显示  1: 是  0: 否
     */
    private Integer isShow;

    //以下字段不存入数据库

    /**
     * 分类图
     */
    @TableField(exist = false)
    private List<String> photoList;
}