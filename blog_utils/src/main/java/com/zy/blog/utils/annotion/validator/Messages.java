package com.zy.blog.utils.annotion.validator;

/**
 * @description: 消息模板
 * @author: 小章鱼
 * @date: 2021/9/29 19:29
 **/
public interface Messages {
    /**
     * 类内部使用,自定义reject value
     */
    String CK_RANG_MESSAGE_LENGTH_TYPE = "length must be between 0 and 11:%s";
    String CK_NUMERIC_TYPE = "field must be a number:%s";

    /**
     * 注解默认
     */
    String CK_NOT_BLANK_DEFAULT = "can not be blank";
    String CK_NOT_NULL_DEFAULT = "can not be null";
    String CK_NUMERIC_DEFAULT = "must be a number";
    String CK_RANGE_DEFAULT = "should be an integer,between {min} and {max}";
    String ID_NOT_NULL = "can not be null";
    String PAGE_NOT_NULL = "page not be null";
    String SIZE_NOT_NULL = "size not be null";

    String ID_LENGTH_THIRTY_TWO = "length must be 32";
}

