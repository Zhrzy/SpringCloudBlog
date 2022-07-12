package com.zy.blog.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.Admin;
import com.zy.blog.entity.Role;
import com.zy.blog.gateway.mapper.RoleMapper;
import com.zy.blog.gateway.service.AdminService;
import com.zy.blog.gateway.service.RoleService;

import com.zy.blog.gateway.util.RedisUtil;
import com.zy.blog.utils.constant.*;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.RoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author limbo
 * @since 2021-09-30
 */
@Service
public class RoleServiceImpl extends ServiceImplBase<RoleMapper, Role> implements RoleService {


}
