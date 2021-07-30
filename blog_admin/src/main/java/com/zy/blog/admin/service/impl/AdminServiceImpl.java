package com.zy.blog.admin.service.impl;

import com.zy.blog.admin.mapper.AdminMapper;
import com.zy.blog.admin.mapper.MenuMapper;
import com.zy.blog.admin.service.AdminService;
import com.zy.blog.entity.Admin;
import com.zy.blog.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public Admin login(String username, String password) {

        System.out.println(username+"--"+password+"===");
        return adminMapper.login(username,password);
    }




}
