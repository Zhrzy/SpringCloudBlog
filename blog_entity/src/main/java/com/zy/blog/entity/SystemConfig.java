package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;

@TableName(value = "t_system_config")
public class SystemConfig extends EntityBase<SystemConfig> {
    private int iconType;

    private String qiNiuAccessKey;

    private String qiNiuSecretKey;

    private String email;

    private String emailUserName;

    private String emailPassword;

    private String smtpAddress;

    private String smtpPort;

    private String qiNiuBucket;

    private String qiNiuArea;

    private String uploadQiNiu;

    private String uploadLocal;

    private String picturePriority;

    private String qiNiuPictureBaseUrl;

    private String localPictureBaseUrl;

    private String startEmailNotification;

    private Boolean editorModel;

    private String themeColor;

    private String minioEndPoint;

    private String minioAccessKey;

    private String minioSecretKey;

    private String minioBucket;

    private Boolean uploadMinio;

    private String minioPictureBaseUrl;

    private Boolean openDashboardNotification;

    private Boolean contentPicturePriority;

    private Boolean openEmailActivate;

    private String dashboardNotification;

    public int getIconType() {
        return iconType;
    }

    public void setIconType(int iconType) {
        this.iconType = iconType;
    }

    public String getQiNiuAccessKey() {
        return qiNiuAccessKey;
    }

    public void setQiNiuAccessKey(String qiNiuAccessKey) {
        this.qiNiuAccessKey = qiNiuAccessKey == null ? null : qiNiuAccessKey.trim();
    }

    public String getQiNiuSecretKey() {
        return qiNiuSecretKey;
    }

    public void setQiNiuSecretKey(String qiNiuSecretKey) {
        this.qiNiuSecretKey = qiNiuSecretKey == null ? null : qiNiuSecretKey.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmailUserName() {
        return emailUserName;
    }

    public void setEmailUserName(String emailUserName) {
        this.emailUserName = emailUserName == null ? null : emailUserName.trim();
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword == null ? null : emailPassword.trim();
    }

    public String getSmtpAddress() {
        return smtpAddress;
    }

    public void setSmtpAddress(String smtpAddress) {
        this.smtpAddress = smtpAddress == null ? null : smtpAddress.trim();
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort == null ? null : smtpPort.trim();
    }

    public String getQiNiuBucket() {
        return qiNiuBucket;
    }

    public void setQiNiuBucket(String qiNiuBucket) {
        this.qiNiuBucket = qiNiuBucket == null ? null : qiNiuBucket.trim();
    }

    public String getQiNiuArea() {
        return qiNiuArea;
    }

    public void setQiNiuArea(String qiNiuArea) {
        this.qiNiuArea = qiNiuArea == null ? null : qiNiuArea.trim();
    }

    public String getUploadQiNiu() {
        return uploadQiNiu;
    }

    public void setUploadQiNiu(String uploadQiNiu) {
        this.uploadQiNiu = uploadQiNiu == null ? null : uploadQiNiu.trim();
    }

    public String getUploadLocal() {
        return uploadLocal;
    }

    public void setUploadLocal(String uploadLocal) {
        this.uploadLocal = uploadLocal == null ? null : uploadLocal.trim();
    }

    public String getPicturePriority() {
        return picturePriority;
    }

    public void setPicturePriority(String picturePriority) {
        this.picturePriority = picturePriority == null ? null : picturePriority.trim();
    }

    public String getQiNiuPictureBaseUrl() {
        return qiNiuPictureBaseUrl;
    }

    public void setQiNiuPictureBaseUrl(String qiNiuPictureBaseUrl) {
        this.qiNiuPictureBaseUrl = qiNiuPictureBaseUrl == null ? null : qiNiuPictureBaseUrl.trim();
    }

    public String getLocalPictureBaseUrl() {
        return localPictureBaseUrl;
    }

    public void setLocalPictureBaseUrl(String localPictureBaseUrl) {
        this.localPictureBaseUrl = localPictureBaseUrl == null ? null : localPictureBaseUrl.trim();
    }

    public String getStartEmailNotification() {
        return startEmailNotification;
    }

    public void setStartEmailNotification(String startEmailNotification) {
        this.startEmailNotification = startEmailNotification == null ? null : startEmailNotification.trim();
    }

    public Boolean getEditorModel() {
        return editorModel;
    }

    public void setEditorModel(Boolean editorModel) {
        this.editorModel = editorModel;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor == null ? null : themeColor.trim();
    }

    public String getMinioEndPoint() {
        return minioEndPoint;
    }

    public void setMinioEndPoint(String minioEndPoint) {
        this.minioEndPoint = minioEndPoint == null ? null : minioEndPoint.trim();
    }

    public String getMinioAccessKey() {
        return minioAccessKey;
    }

    public void setMinioAccessKey(String minioAccessKey) {
        this.minioAccessKey = minioAccessKey == null ? null : minioAccessKey.trim();
    }

    public String getMinioSecretKey() {
        return minioSecretKey;
    }

    public void setMinioSecretKey(String minioSecretKey) {
        this.minioSecretKey = minioSecretKey == null ? null : minioSecretKey.trim();
    }

    public String getMinioBucket() {
        return minioBucket;
    }

    public void setMinioBucket(String minioBucket) {
        this.minioBucket = minioBucket == null ? null : minioBucket.trim();
    }

    public Boolean getUploadMinio() {
        return uploadMinio;
    }

    public void setUploadMinio(Boolean uploadMinio) {
        this.uploadMinio = uploadMinio;
    }

    public String getMinioPictureBaseUrl() {
        return minioPictureBaseUrl;
    }

    public void setMinioPictureBaseUrl(String minioPictureBaseUrl) {
        this.minioPictureBaseUrl = minioPictureBaseUrl == null ? null : minioPictureBaseUrl.trim();
    }

    public Boolean getOpenDashboardNotification() {
        return openDashboardNotification;
    }

    public void setOpenDashboardNotification(Boolean openDashboardNotification) {
        this.openDashboardNotification = openDashboardNotification;
    }

    public Boolean getContentPicturePriority() {
        return contentPicturePriority;
    }

    public void setContentPicturePriority(Boolean contentPicturePriority) {
        this.contentPicturePriority = contentPicturePriority;
    }

    public Boolean getOpenEmailActivate() {
        return openEmailActivate;
    }

    public void setOpenEmailActivate(Boolean openEmailActivate) {
        this.openEmailActivate = openEmailActivate;
    }

    public String getDashboardNotification() {
        return dashboardNotification;
    }

    public void setDashboardNotification(String dashboardNotification) {
        this.dashboardNotification = dashboardNotification == null ? null : dashboardNotification.trim();
    }
}