package com.zy.blog.admin.filter;

import com.zy.blog.securityconfig.CurentUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 重构认证
 * @author: 小章鱼
 * @date: 2022/6/26 21:19
 **/
@Component
public class UserInfoHandlerInterceptorAdapter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CurentUser.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
