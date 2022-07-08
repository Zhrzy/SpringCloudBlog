package com.zy.blog.view;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zy.blog.base.ViewBase;
import lombok.Data;

@Data
public class WebVisitView extends ViewBase {
    /**
     * 用户UID
     */
    private String userUid;

    /**
     * 用户IP
     */
    private String ip;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 用户访问行为   (点击了文章，点击了标签，点击了分类，进行了搜索)
     */
    private String behavior;

    /**
     * 文章uid，标签uid，分类uid
     */
    private String moduleUid;

    /**
     * 附加数据(比如搜索内容)
     */
    private String otherData;

    /**
     * 日志时间段
     */
    private String startTime;

    /**
     * 内容(点击的博客名，点击的标签名，搜索的内容，点击的作者)
     */
    @TableField(exist = false)
    private String content;

    /**
     * 行为名称
     */
    @TableField(exist = false)
    private String behaviorContent;
}