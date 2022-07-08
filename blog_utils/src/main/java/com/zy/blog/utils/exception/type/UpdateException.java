package com.zy.blog.utils.exception.type;


import com.zy.blog.utils.constant.BaseMessageConf;
import com.zy.blog.utils.constant.ErrorCode;

import java.io.Serializable;


/**
 * @description: 自定义查询操作相关的异常
 * @author: 小章鱼
 * @date: 2021/10/01 18:15
 **/
public class UpdateException extends RuntimeException implements Serializable {
    /**
     * 异常状态码
     */
    private String code;

    public UpdateException() {
        super(BaseMessageConf.UPDATE_DEFAULT_ERROR);
        this.code = ErrorCode.UPDATE_DEFAULT_ERROR;
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCode.UPDATE_DEFAULT_ERROR;
    }

    public UpdateException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public UpdateException(String message) {
        super(message);
        this.code = ErrorCode.UPDATE_DEFAULT_ERROR;
    }

    public UpdateException(String code, String message) {
        super(message);
        this.code = code;
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
