package com.zy.blog.utils.enums;

/**
 * @author: 小章鱼
 * @date: 2021/10/03
 */
public enum SystemLanguageEnum {

    /**
     * 中文
     */
    ZH("zh", "中文"),

    /**
     * 英文
     */
    EN("en", "英文");

    private final String code;
    private final String name;

    SystemLanguageEnum(String code, String name) {
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