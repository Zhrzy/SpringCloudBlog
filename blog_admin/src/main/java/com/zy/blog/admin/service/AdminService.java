package com.zy.blog.admin.service;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Admin;
import com.zy.blog.entity.Menu;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AdminService extends ServiceBase<Admin> {

    public Admin login(@RequestParam("username")String username, @RequestParam("password")String password);



}
