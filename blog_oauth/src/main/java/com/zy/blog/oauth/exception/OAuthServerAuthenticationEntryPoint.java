package com.zy.blog.oauth.exception;

import com.zy.blog.oauth.model.ResultCode;
import com.zy.blog.oauth.model.ResultMsg;
import com.zy.blog.oauth.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 认证服务重构
 * @author: 小章鱼
 * @date: 2022/6/22 13:07
 **/
@Component
@Slf4j
public class OAuthServerAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * 认证失败处理器会调用这个方法返回提示信息
     * TODO 实际开发中可以自己定义，此处直接返回JSON数据：客户端认证失败错误提示
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ResponseUtils.result(response,new ResultMsg(ResultCode.CLIENT_AUTHENTICATION_FAILED.getStatus(),null,ResultCode.CLIENT_AUTHENTICATION_FAILED.getMessage()));
    }
}