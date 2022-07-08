package com.zy.blog.utils.enums;

/**
 * 社交账号类型枚举类
 *
 * @author: 小章鱼
 * @date: 2021/9/28
 */
public enum EAccountType {

    /**
     * 邮箱
     */
    EMail("1", "邮箱"),

    /**
     * QQ号
     */
    QQNumber("2", "QQ号"),

    /**
     * QQ群
     */
    QQGroup("3", "QQ群"),

    /**
     * Github
     */
    Github("4", "Github"),

    /**
     * Gitee
     */
    Gitee("5", "Gitee"),

    /**
     * 微信
     */
    WeChat("6", "微信");


    private final String code;
    private final String name;

    EAccountType(String code, String name) {
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