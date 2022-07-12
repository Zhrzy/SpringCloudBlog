package com.zy.blog.gateway.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;

import com.zy.blog.entity.Admin;
import com.zy.blog.entity.AdminRole;
import com.zy.blog.entity.Role;
import com.zy.blog.entity.Storage;
import com.zy.blog.gateway.mapper.AdminMapper;
import com.zy.blog.gateway.service.AdminService;
import com.zy.blog.utils.ResultUtil1;
import com.zy.blog.utils.StringUtils;
import com.zy.blog.utils.constant.*;
import com.zy.blog.utils.exception.type.QueryException;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.RedisUtil;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.AdminView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AdminServiceImpl extends ServiceImplBase<AdminMapper,Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;

}
