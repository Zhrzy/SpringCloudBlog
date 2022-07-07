package com.zy.blog.oauth.controller;

import com.zy.blog.utils.ResultUtil1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  小章鱼 1716457206@qq.com
 */
@RestController
@RequestMapping("/oauth")
public class LogoutController {

    @RequestMapping("/logout")
    public ResultUtil1 logout(){

        return new ResultUtil1();
    }
}
