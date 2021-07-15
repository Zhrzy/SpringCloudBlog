package com.zy.blog.oauth.config;

import com.zy.blog.utils.ResultUtil;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class OAuthExceptionHandler {

    /**
     * 用户不存在
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public String handleUsernameNotFoundException(UsernameNotFoundException e) {
        return ResultUtil.result("123", "123", "123");
    }

        /**
         * 用户名和密码异常
         *
         * @param e
         * @return
         */
        @ExceptionHandler(InvalidGrantException.class)
        public String handleInvalidGrantException (InvalidGrantException e){
            return ResultUtil.result("123", "123", "123");
        }


        /**
         * 账户异常(禁用、锁定、过期)
         *
         * @param e
         * @return
         */
        @ExceptionHandler({InternalAuthenticationServiceException.class})
        public String handleInternalAuthenticationServiceException (InternalAuthenticationServiceException e){
            return ResultUtil.result("123", "123", "123");
        }


}
