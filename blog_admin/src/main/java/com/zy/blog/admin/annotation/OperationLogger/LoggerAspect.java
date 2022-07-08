package com.zy.blog.admin.annotation.OperationLogger;

import com.alibaba.cloud.sentinel.datasource.RuleType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import com.zy.blog.entity.ExceptionLog;
import com.zy.blog.securityconfig.SecurityUser;
import com.zy.blog.utils.constant.Constants;
import com.zy.blog.utils.constant.RedisConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 日志切面类
 *
 * @author 小章鱼
 * @date 2020年12月31日21:26:04
 */
@Aspect
@Component
@Slf4j
public class LoggerAspect {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 开始时间
     */
    Date startTime;

    @Pointcut(value = "@annotation(operationLogger)")
    public void pointcut(OperationLogger operationLogger) {

    }

    @Around(value = "pointcut(operationLogger)")
    public Object doAround(ProceedingJoinPoint joinPoint, OperationLogger operationLogger) throws Throwable {

        startTime = new Date();

        //先执行业务
        Object result = joinPoint.proceed();

        try {
            // 日志收集
            handle(joinPoint);

        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }


    @AfterThrowing(value = "pointcut(operationLogger)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, OperationLogger operationLogger, Throwable e) throws Exception {

        ExceptionLog exception = new ExceptionLog();
        HttpServletRequest request = RequestHolder.getRequest();
        String ip = IpUtils.getIpAddr(request);
        exception.setIp(ip);
        String operationName = AspectUtil.INSTANCE.parseParams(joinPoint.getArgs(), operationLogger.value());

        //从Redis中获取IP来源
        String jsonResult = redisUtil.get(RedisConf.IP_SOURCE + Constants.SYMBOL_COLON + ip);
        if (StringUtils.isEmpty(jsonResult)) {
            String addresses = IpUtils.getAddresses(SysConf.IP + SysConf.EQUAL_TO + ip, SysConf.UTF_8);
            if (StringUtils.isNotEmpty(addresses)) {
                exception.setIpSource(addresses);
                redisUtil.setEx(RedisConf.IP_SOURCE + Constants.SYMBOL_COLON + ip, addresses, 24, TimeUnit.HOURS);
            }
        } else {
            exception.setIpSource(jsonResult);
        }

        //设置请求信息
        exception.setIp(ip);

        //设置调用的方法
        exception.setMethod(joinPoint.getSignature().getName());

        exception.setExceptionJson(JSON.toJSONString(e,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        exception.setExceptionMessage(e.getMessage());

        exception.setOperation(operationName);
        exception.setCreateTime(new Date());
        exception.setUpdateTime(new Date());

        exception.insert();
    }


    /**
     * 管理员日志收集
     *
     * @param point
     * @throws Exception
     */
    private void handle(ProceedingJoinPoint point) throws Exception {

        HttpServletRequest request = RequestHolder.getRequest();

        Method currentMethod = AspectUtil.INSTANCE.getMethod(point);

        //获取操作名称
        OperationLogger annotation = currentMethod.getAnnotation(OperationLogger.class);

        boolean save = annotation.save();

        String bussinessName = AspectUtil.INSTANCE.parseParams(point.getArgs(), annotation.value());

        String ua = com.zy.blog.admin.util.RequestUtil.getUa();

        log.info("{} | {} - {} {} - {}", bussinessName, IpUtils.getIpAddr(request), com.zy.blog.admin.util.RequestUtil.getMethod(), com.zy.blog.admin.util.RequestUtil.getRequestUrl(), ua);
        if (!save) {
            return;
        }
        // 获取参数名称和值
        Map<String, Object> nameAndArgsMap = AopUtils.getFieldsName(point);
        // 当前操作用户
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       // String paramsJson = JSONObject.toJSONString(nameAndArgsMap);
        String type = request.getMethod();
        String ip = IpUtils.getIpAddr(request);
        String url = request.getRequestURI();

        // 异步存储日志
        threadPoolTaskExecutor.execute(
                new SysLogHandle(ip, type, url, securityUser,
                        null, point.getTarget().getClass().getName(),
                        point.getSignature().getName(), bussinessName,
                        startTime, redisUtil));
    }
}
