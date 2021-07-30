package com.zy.blog.view;

import com.zy.blog.base.ViewBase;

public class PictureSortView extends ViewBase {
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