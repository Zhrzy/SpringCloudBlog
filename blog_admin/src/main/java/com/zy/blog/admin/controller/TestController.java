package com.zy.blog.admin.controller;

import com.zy.blog.admin.service.AdminService;
import com.zy.blog.entity.Admin;
import com.zy.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/login")
    public Object login(@RequestParam( value = "username",defaultValue = "3")String username, @RequestParam("password")String password){
        System.out.println(username+"==>"+password);
        Admin admin = adminService.login(username, password);
        System.out.println(admin+"...........");
        return ResultUtil.result("200","success",admin);
       // return "result success";
    }

    @GetMapping("/test1")
    public Object test(){

        return "result success test1";
    }

}
