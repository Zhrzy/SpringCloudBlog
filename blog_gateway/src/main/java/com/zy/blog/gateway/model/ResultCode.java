package com.zy.blog.gateway.model;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/6/22 2:13
 **/
public enum ResultCode {


    CLIENT_AUTHENTICATION_FAILED("1001","客户端认证失败"),

    USERNAME_OR_PASSWORD_ERROR("1002","用户名或密码错误"),

    UNSUPPORTED_GRANT_TYPE("1003", "不支持的认证模式"),

    TOKEN_INVALID("1004","token失效！"),

    NO_PERMISSION("1005","对不起，您没有操作权限！"),

    UNAUTHORIZED("401", "系统错误");
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    private  String Message;

    ResultCode(String status, String message) {
        this.status = status;
        Message = message;
    }

}
