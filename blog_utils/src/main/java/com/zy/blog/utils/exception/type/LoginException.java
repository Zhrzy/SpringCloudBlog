package com.zy.blog.utils.exception.type;

import com.zy.blog.utils.constant.BaseMessageConf;
import com.zy.blog.utils.constant.ErrorCode;

import java.io.Serializable;

/**
 * @description: 登录的异常
 * @author: 小章鱼
 * @date: 2021/9/30 19:21
 **/
public class LoginException extends RuntimeException implements Serializable {

    /**
     * 异常状态码
     */
    private String code;

    public LoginException() {
        super(BaseMessageConf.QUERY_DEFAULT_ERROR);
        this.code = ErrorCode.QUERY_DEFAULT_ERROR;
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCode.QUERY_DEFAULT_ERROR;
    }

    public LoginException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public LoginException(String message) {
        super(message);
        this.code = ErrorCode.QUERY_DEFAULT_ERROR;
    }

    public LoginException(String code, String message) {
        super(message);
        this.code = code;
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
