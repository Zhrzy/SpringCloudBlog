package com.zy.blog.oauth.service;

import com.alibaba.fastjson.JSON;
import com.zy.blog.entity.Admin;
import com.zy.blog.entity.Role;
import com.zy.blog.oauth.mapper.AdminMapper;
import com.zy.blog.oauth.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
* 用户详情服务
* */
@Service
public class OauthUserDetailServices implements UserDetailsService {

    @Resource
    AdminMapper adminMapper;

    @Resource
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminMapper.getUserByUsername(username);
        if (admin == null) {
            return null;
        }
        String principal = JSON.toJSONString(admin);
        //获取角色
        List<Role> listRole = roleMapper.getRoleListByName(username);
        String[] permissionArray = new String[listRole.size()];
        List<String> listRoleName=listRole.stream().filter(r->r!=null).map(s->s.getRoleName()).collect(Collectors.toList());
        listRoleName.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(principal).password(admin.getPassWord()).authorities(permissionArray).build();
        return userDetails;
    }
}
