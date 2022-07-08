package com.zy.blog.utils.exception.type;


import com.zy.blog.utils.constant.BaseMessageConf;
import com.zy.blog.utils.constant.ErrorCode;

import java.io.Serializable;


/**
 * @description: 自定义新增操作相关的异常
 * @author: 小章鱼
 * @date: 2021/9/30 18:55
 **/
public class InsertException extends RuntimeException implements Serializable {

    /**
     * 异常状态码
     */
    private String code;

    public InsertException() {
        super(BaseMessageConf.INSERT_DEFAULT_ERROR);
        this.code = ErrorCode.INSERT_DEFAULT_ERROR;
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCode.INSERT_DEFAULT_ERROR;
    }

    public InsertException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public InsertException(String message) {
        super(message);
        this.code = ErrorCode.INSERT_DEFAULT_ERROR;
    }

    public InsertException(String code, String message) {
        super(message);
        this.code = code;
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
