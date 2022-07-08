package com.zy.blog.utils.exception.type;


/**
 * @description: 自定义业务异常
 * @author: 小章鱼
 * @date: 2021/9/30 18:36
 **/
public class BusinessException extends RuntimeException {

    /**
     * 异常编码
     */
    private String code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
