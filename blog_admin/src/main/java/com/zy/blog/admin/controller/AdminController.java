package com.zy.blog.admin.controller;

import com.zy.blog.admin.service.AdminService;
import com.zy.blog.entity.Admin;
import com.zy.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public Object login(@RequestParam( value = "username",defaultValue = "3")String username, @RequestParam("password")String password){
        System.out.println(username+"==>"+password);
        Admin admin = adminService.login(username, password);
        System.out.println(admin+"...........");
        return ResultUtil.result("200","success",admin);
        // return "result success";
    }


}
