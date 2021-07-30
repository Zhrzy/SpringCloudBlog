package com.zy.blog.entity;

import com.zy.blog.base.EntityBase;

public class PictureSort extends EntityBase {
    private String fileUid;

    private String name;

    private String parentUid;

    private Integer sort;

    public String getFileUid() {
        return fileUid;
    }

    public void setFileUid(String fileUid) {
        this.fileUid = fileUid == null ? null : fileUid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentUid() {
        return parentUid;
    }

    public void setParentUid(String parentUid) {
        this.parentUid = parentUid == null ? null : parentUid.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}