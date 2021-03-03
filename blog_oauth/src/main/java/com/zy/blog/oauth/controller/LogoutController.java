package com.zy.blog.oauth.controller;

import com.zy.blog.utils.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy 1716457206@qq.com
 */
@RestController
@RequestMapping("/oauth")
public class LogoutController {

    @RequestMapping("/logout")
    public ResultUtil logout(){

        return new ResultUtil();
    }
}
