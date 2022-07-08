package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/9/28 16:13
 **/
@Data
@TableName(value = "t_admin_role")
public class AdminRole extends EntityBase<AdminRole> {

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String adminUid;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String roleUid;


}