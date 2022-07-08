package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

import java.util.Date;
@Data
@TableName(value = "t_visitor")
public class Visitor extends EntityBase<Visitor> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String user_name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 登录次数
     */
    private Integer login_count;

    /**
     * 最后登录时间
     */
    private Date last_login_time;

    /**
     * 最后登录IP
     */
    private String last_login_ip;
}