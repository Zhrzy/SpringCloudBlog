package com.zy.blog.utils.enums;

/**
 * 评论来源枚举类
 *
 * @author: 小章鱼
 * @date: 2021/9/28
 */

public enum ECommentSource {

    /**
     * 关于我
     */
    ABOUT("ABOUT", "关于我"),

    /**
     * 博客详情
     */
    BLOG_INFO("BLOG_INFO", "博客详情"),

    /**
     * 留言板
     */
    MESSAGE_BOARD("MESSAGE_BOARD", "留言板");


    private final String code;
    private final String name;

    ECommentSource(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}