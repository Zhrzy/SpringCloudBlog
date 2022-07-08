package com.zy.blog.web.annotion.log;

import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EBehavior;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.AopUtils;
import com.zy.blog.utils.util.AspectUtil;
import com.zy.blog.utils.util.IpUtils;
import com.zy.blog.utils.util.RedisUtil;
import com.zy.blog.web.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 日志切面
 */
@Aspect
@Component("WebLoggerAspect")
@Slf4j
public class LoggerAspect {

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    RedisUtil redisUtil;

    @Pointcut(value = "@annotation(bussinessLog)")
    public void pointcut(com.zy.blog.web.annotion.log.BussinessLog bussinessLog) {

    }

    @Around(value = "pointcut(bussinessLog)")
    public Object doAround(ProceedingJoinPoint joinPoint, com.zy.blog.web.annotion.log.BussinessLog  bussinessLog) throws Throwable {

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

    private void handle(ProceedingJoinPoint point) throws Exception {

        HttpServletRequest request = RequestHolder.getRequest();

        Method currentMethod = AspectUtil.INSTANCE.getMethod(point);
        //获取操作名称
        com.zy.blog.web.annotion.log.BussinessLog  annotation = currentMethod.getAnnotation(com.zy.blog.web.annotion.log.BussinessLog .class);

        boolean save = annotation.save();

        EBehavior behavior = annotation.behavior();

        String bussinessName = AspectUtil.INSTANCE.parseParams(point.getArgs(), annotation.value());

        String ua = RequestUtil.getUa();

        log.info("{} | {} - {} {} - {}", bussinessName, IpUtils.getIpAddr(request), RequestUtil.getMethod(), RequestUtil.getRequestUrl(), ua);
        if (!save) {
            return;
        }

        // 获取参数名称和值
        Map<String, Object> nameAndArgsMap = AopUtils.getFieldsName(point);

        Map<String, String> result = EBehavior.getModuleAndOtherData(behavior, nameAndArgsMap, bussinessName);

        if (result != null) {
            String userUid = "";
            if (request.getAttribute(SysConf.USER_UID) != null) {
                userUid = request.getAttribute(SysConf.USER_UID).toString();
            }

            Map<String, String> map = IpUtils.getOsAndBrowserInfo(request);
            String os = map.get(SysConf.OS);
            String browser = map.get(SysConf.BROWSER);
            String ip = IpUtils.getIpAddr(request);
            // 异步存储日志
            threadPoolTaskExecutor.execute(
                    new com.zy.blog.web.annotion.log.SysLogHandle(userUid, ip, os, browser,
                            behavior.getBehavior(),
                            result.get(SysConf.MODULE_UID),
                            result.get(SysConf.OTHER_DATA), redisUtil));
        }
    }
}
