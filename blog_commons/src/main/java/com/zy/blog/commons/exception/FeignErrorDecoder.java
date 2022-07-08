package com.zy.blog.commons.exception;
/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/6/25 8:55
 **/
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.zy.blog.utils.exception.type.LoginException;
import com.zy.blog.utils.exception.type.QueryException;
import com.zy.blog.utils.util.ResultUtil;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Configuration
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status() >= 400 && response.status() <= 499){
            if(response.status() ==401 ){
                return new UserNamePasswordException("用户名或密码错误！");
            }

        }
        return feign.FeignException.errorStatus(methodKey, response);
    }

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, LoginException e) {
//        ResultSet resultSet = new rS();
//        if (e.getStatus() == 400) {
//            resultSet.setResultCode(-1);
//            resultSet.setResultMsg(e.getMessage());
//            resultSet.setData(null);
//            resp.setStatus(400);
//        } else {
//            resp.setStatus(500);
//            if(logger.isErrorEnabled()){
//                logger.error("系统异常，请联系系统开发人员进行处理", e);
//            }
//            resultSet.setResultCode(-1);
//            resultSet.setResultMsg(e.getMessage());
//            resultSet.setData(null);
//        }
//        return resultSet;
        return ResultUtil.resultWithDataAndMessage("13","12","DENG");
    }

}
