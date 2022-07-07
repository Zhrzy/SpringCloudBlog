package com.zy.blog.oauth.exception;

import com.zy.blog.oauth.exception.oauth.model.UserNamePasswordException;
import com.zy.blog.oauth.model.ResultCode;
import com.zy.blog.oauth.model.ResultMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * @description: 认证服务重构
 * @author: 小章鱼
 * @date: 2022/6/22 2:09
 **/
public class ExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity translate(Exception e) throws Exception {

        ResultMsg message = doTranslate(e);
        return new ResponseEntity(message, HttpStatus.UNAUTHORIZED);
    }
    private ResultMsg doTranslate(Exception e){
        //初始值，系统错误，
        ResultCode resultCode = ResultCode.UNAUTHORIZED;
        //判断异常，不支持的认证方式
        if(e instanceof UnsupportedGrantTypeException){
            resultCode = ResultCode.UNSUPPORTED_GRANT_TYPE;
            //用户名或密码异常
        }else if(e instanceof InvalidGrantException){
            resultCode = ResultCode.USERNAME_OR_PASSWORD_ERROR;
//            throw new UserNamePasswordException(e.getMessage());
        }
        return new ResultMsg(resultCode.getStatus(),resultCode.getMessage(),null);
    }
}
