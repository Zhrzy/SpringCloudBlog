package com.zy.blog.view;

import com.zy.blog.base.ViewBase;
import lombok.Data;

@Data
public class SystemConfigView extends ViewBase {
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

    private int editorModel;

    private String themeColor;

    private String minioEndPoint;

    private String minioAccessKey;

    private String minioSecretKey;

    private String minioBucket;

    private int uploadMinio;

    private String minioPictureBaseUrl;

    private int openDashboardNotification;

    private int contentPicturePriority;

    private int openEmailActivate;

    private String dashboardNotification;


}