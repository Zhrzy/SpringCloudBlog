package com.zy.blog.oauth.service;

import com.zy.blog.oauth.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
* 用户详情服务
* */
@Service
public class OauthUserDetailServices implements UserDetailsService {

    @Resource
    AdminMapper adminMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
