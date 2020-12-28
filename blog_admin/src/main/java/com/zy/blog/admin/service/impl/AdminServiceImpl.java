package com.zy.blog.admin.service.impl;

import com.zy.blog.admin.mapper.AdminMapper;
import com.zy.blog.admin.service.AdminService;
import com.zy.blog.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;
    @Override
    public Admin login(String username, String password) {

        return adminMapper.login(username,password);
    }
}
