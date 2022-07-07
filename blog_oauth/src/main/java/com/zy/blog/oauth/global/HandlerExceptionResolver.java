package com.zy.blog.oauth.global;



import com.zy.blog.utils.constant.BaseMessageConf;
import com.zy.blog.utils.constant.ErrorCode;
import com.zy.blog.utils.exception.type.*;
import com.zy.blog.utils.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @description: 认证服务重构
 * @author: 小章鱼
 * @date: 2022/5/30 22:35
 *
 **/
@Slf4j
@Component
public class HandlerExceptionResolver implements org.springframework.web.servlet.HandlerExceptionResolver{
    /**
     * 异常处理方法
     *
     * @param request
     * @param response
     * @param handler   出现异常的对象
     * @param exception 出现的异常信息
     * @return ModelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        log.error("系统统一异常处理：", exception);
        // 若响应已响应或已关闭，则不操作
        if (response.isCommitted()) {
            return new ModelAndView();
        }

        // 组装错误提示信息
        String errorCode = ErrorCode.ERROR;
        String message = BaseMessageConf.OPERATION_FAIL;

        if (exception instanceof InvalidGrantException){
             errorCode = ErrorCode.ERROR;
            message = "用户名密码错误了";
        }

        // 自定义业务相关异常
        if (exception instanceof BusinessException) {
            errorCode = ((BusinessException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof ApiInvalidParamException) {
            // 自定义参数校验相关的异常
            // 自动拼接异常信息
            errorCode = ErrorCode.PARAM_INCORRECT;
            message = exception.getMessage();
        } else if (exception instanceof LoginException) {
            // 自定义登录相关的异常
            errorCode = ((LoginException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof QueryException) {
            // 自定义查询相关的异常
            errorCode = ((QueryException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof UpdateException) {
            // 自定义更新操作相关的异常
            errorCode = ((UpdateException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof InsertException) {
            // 自定义新增操作相关的异常
            errorCode = ((InsertException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof DeleteException) {
            // 自定义删除操作相关的异常
            errorCode = ((DeleteException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof Exception) {
            // 其它异常
            message = exception.getMessage();
            log.error(exception.getMessage());
        }else {
            message = "未知错误";
            log.error(exception.getMessage());
        }

        // 响应类型设置
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        // 响应结果输出
        try (PrintWriter writer = response.getWriter()) {
            writer.write(ResultUtil.resultWithMessage(errorCode, message));
        } catch (Exception e) {
            log.error("响应输出失败！原因如下：", e);
        }
        return new ModelAndView();
    }


}
