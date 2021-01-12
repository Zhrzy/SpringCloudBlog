package com.zy.blog.oauth.service;

import com.alibaba.fastjson.JSON;
import com.zy.blog.entity.Admin;
import com.zy.blog.oauth.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
* 用户详情服务
* */
@Service
public class OauthUserDetailServices implements UserDetailsService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminMapper.getUserByUsername(username);
        if (admin == null) {
            return null;
        }
        String principal = JSON.toJSONString(admin);
        List<String> list = new ArrayList<>();
        list.add("p1");
        String[] permissionArray = new String[1];
        list.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(principal).password(admin.getPassWord()).authorities(permissionArray).build();
        return userDetails;
    }
}
