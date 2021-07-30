package com.zy.blog.entity;

import com.zy.blog.base.EntityBase;

public class Collect extends EntityBase {
    private String userUid;

    private String blogUid;

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid == null ? null : userUid.trim();
    }

    public String getBlogUid() {
        return blogUid;
    }

    public void setBlogUid(String blogUid) {
        this.blogUid = blogUid == null ? null : blogUid.trim();
    }
}