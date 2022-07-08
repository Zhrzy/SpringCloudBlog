package com.zy.blog.commons.exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * @description:
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
