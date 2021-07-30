package com.zy.blog.entity;

import com.zy.blog.base.EntityBase;

public class FeedBack extends EntityBase {
    private String userUid;

    private String content;

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid == null ? null : userUid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}