package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/9/28 16:13
 **/

@TableName(value = "t_collect")
public class Collect extends EntityBase<Collect> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户的uid
     */
    private String userUid;

    /**
     * 博客的uid
     */
    private String blogUid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getBlogUid() {
        return blogUid;
    }

    public void setBlogUid(String blogUid) {
        this.blogUid = blogUid;
    }
}