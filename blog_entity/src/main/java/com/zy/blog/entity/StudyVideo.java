package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;


@TableName(value = "t_study_video")
public class StudyVideo extends EntityBase<StudyVideo> {
    private String fileUid;

    private String resourceSortUid;

    private String name;

    private String summary;

    private String content;

    private String baiduPath;

    private String clickCount;

    private String parentUid;

    public String getFileUid() {
        return fileUid;
    }

    public void setFileUid(String fileUid) {
        this.fileUid = fileUid == null ? null : fileUid.trim();
    }

    public String getResourceSortUid() {
        return resourceSortUid;
    }

    public void setResourceSortUid(String resourceSortUid) {
        this.resourceSortUid = resourceSortUid == null ? null : resourceSortUid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getBaiduPath() {
        return baiduPath;
    }

    public void setBaiduPath(String baiduPath) {
        this.baiduPath = baiduPath == null ? null : baiduPath.trim();
    }

    public String getClickCount() {
        return clickCount;
    }

    public void setClickCount(String clickCount) {
        this.clickCount = clickCount == null ? null : clickCount.trim();
    }

    public String getParentUid() {
        return parentUid;
    }

    public void setParentUid(String parentUid) {
        this.parentUid = parentUid == null ? null : parentUid.trim();
    }
}