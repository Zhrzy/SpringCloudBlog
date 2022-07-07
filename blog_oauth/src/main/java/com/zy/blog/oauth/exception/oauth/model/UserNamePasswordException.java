package com.zy.blog.oauth.exception.oauth.model;

import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * @description: 认证服务重构
 * @author: 小章鱼
 * @date: 2022/6/25 10:46
 **/
public class UserNamePasswordException extends HystrixBadRequestException {
    public UserNamePasswordException(String message) {
        super(message);
    }

    public UserNamePasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
