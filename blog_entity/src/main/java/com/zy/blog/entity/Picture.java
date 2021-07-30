package com.zy.blog.entity;

import com.zy.blog.base.EntityBase;

public class Picture extends EntityBase {
    private String fileUid;

    private String picName;

    private String pictureSortUid;

    public String getFileUid() {
        return fileUid;
    }

    public void setFileUid(String fileUid) {
        this.fileUid = fileUid == null ? null : fileUid.trim();
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public String getPictureSortUid() {
        return pictureSortUid;
    }

    public void setPictureSortUid(String pictureSortUid) {
        this.pictureSortUid = pictureSortUid == null ? null : pictureSortUid.trim();
    }
}