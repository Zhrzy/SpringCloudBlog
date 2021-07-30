package com.zy.blog.entity;

import com.zy.blog.base.EntityBase;

public class Blog extends EntityBase {
    private String title;

    private String summary;

    private String tagUid;

    private Integer clickCount;

    private Integer collectCount;

    private String fileUid;

    private String adminUid;

    private String isOriginal;

    private String author;

    private String articlesPart;

    private String blogSortUid;

    private Boolean level;

    private String isPublish;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getTagUid() {
        return tagUid;
    }

    public void setTagUid(String tagUid) {
        this.tagUid = tagUid == null ? null : tagUid.trim();
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public String getFileUid() {
        return fileUid;
    }

    public void setFileUid(String fileUid) {
        this.fileUid = fileUid == null ? null : fileUid.trim();
    }

    public String getAdminUid() {
        return adminUid;
    }

    public void setAdminUid(String adminUid) {
        this.adminUid = adminUid == null ? null : adminUid.trim();
    }

    public String getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(String isOriginal) {
        this.isOriginal = isOriginal == null ? null : isOriginal.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getArticlesPart() {
        return articlesPart;
    }

    public void setArticlesPart(String articlesPart) {
        this.articlesPart = articlesPart == null ? null : articlesPart.trim();
    }

    public String getBlogSortUid() {
        return blogSortUid;
    }

    public void setBlogSortUid(String blogSortUid) {
        this.blogSortUid = blogSortUid == null ? null : blogSortUid.trim();
    }

    public Boolean getLevel() {
        return level;
    }

    public void setLevel(Boolean level) {
        this.level = level;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish == null ? null : isPublish.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}