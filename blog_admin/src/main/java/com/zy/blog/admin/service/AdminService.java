package com.zy.blog.admin.service;

import com.zy.blog.entity.Admin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminService {

    public Admin login(@RequestParam("username")String username, @RequestParam("password")String password);

}
