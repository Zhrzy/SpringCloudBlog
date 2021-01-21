package com.zy.blog.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy 1716457206@qq.com
 */
@RestController
@RequestMapping("/testpom")
public class TestController {

    @GetMapping("/test1")
    public String test1(){
        return "meesahges1";
    }
}
