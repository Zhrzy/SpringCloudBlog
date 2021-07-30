package com.zy.blog.view;

import com.zy.blog.base.ViewBase;

public class TodoView extends ViewBase {
    private String adminUid;

    private String text;

    private Boolean done;

    public String getAdminUid() {
        return adminUid;
    }

    public void setAdminUid(String adminUid) {
        this.adminUid = adminUid == null ? null : adminUid.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}