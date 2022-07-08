package com.zy.blog.admin.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @description: 日志记录 Spring Aop实现
 * @author 小章鱼
 * @date 2020年12月31日
 **/
@Aspect
public class AspectAutoLog {

    @Pointcut("@annotation(com.zy.blog.admin.annotation.AutoLog)")
    public void pointcut() {
    }

    Date beginTime;
    public Object aroundlog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //开始
        beginTime = new Date();
        //执行
        Object proceed = proceedingJoinPoint.proceed();
        //收集


        return proceed;
    }

    public void savalOG(ProceedingJoinPoint proceedingJoinPoint){
        ServletRequestAttributes request= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = request.getRequest();
        httpServletRequest.getRequestURI();

    }


}
