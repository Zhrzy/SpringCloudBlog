package com.zy.blog.view;

import com.zy.blog.base.ViewBase;

public class FeedBackView extends ViewBase {
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