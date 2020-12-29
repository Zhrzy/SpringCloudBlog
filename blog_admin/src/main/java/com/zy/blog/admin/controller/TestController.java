package com.zy.blog.admin.controller;

import com.zy.blog.admin.service.AdminService;
import com.zy.blog.entity.Admin;
import com.zy.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy 1716457206@qq.com
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/login")
    public Object login(@RequestParam("username")String username, @RequestParam("password")String password){
        Admin admin = adminService.login(username, password);
        System.out.println(admin+"...........");
        return ResultUtil.result("200","success",admin);
    }
}
