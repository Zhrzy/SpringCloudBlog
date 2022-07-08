package com.zy.blog.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.Admin;
import com.zy.blog.entity.Role;
import com.zy.blog.service.mapper.RoleMapper;
import com.zy.blog.service.service.AdminService;
import com.zy.blog.service.service.RoleMenuService;
import com.zy.blog.service.service.RoleService;
import com.zy.blog.utils.constant.*;
import com.zy.blog.utils.util.RedisUtil;
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

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleMenuService roleMenuService;


    @Override
    public IPage<Role> getPageList(RoleView roleVO) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(roleVO.getKeyword()) && StringUtils.isNotEmpty(roleVO.getKeyword().trim())) {
            queryWrapper.like(SQLConf.ROLENAEM, roleVO.getKeyword().trim());
        }
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        Page<Role> page = new Page<>();
        page.setCurrent(roleVO.getCurrentPage());
        page.setSize(roleVO.getPageSize());
        IPage<Role> pageList = roleService.page(page, queryWrapper);
        return pageList;
    }

    @Transactional
    @Override
    public String addRole(RoleView roleVO) {
        String roleName = roleVO.getRoleName();
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ROLENAEM, roleName);
        Role getRole = roleService.getOne(queryWrapper);
        if (getRole == null) {
            Role role = new Role();
            role.setRoleName(roleVO.getRoleName());
            role.setCategoryMenuUids(roleVO.getCategoryMenuUids());
            role.setSummary(roleVO.getSummary());
            role.insert();
            roleMenuService.addRoleMenu(role.getUid(),roleVO.getCategoryMenuUids());
            return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
        }
        return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
    }

    @Transactional
    @Override
    public String editRole(RoleView RoleView) {
        String uid = RoleView.getUid();
        Role getRole = roleService.getById(uid);
        if (getRole == null) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        getRole.setRoleName(RoleView.getRoleName());
        getRole.setCategoryMenuUids(RoleView.getCategoryMenuUids());
        getRole.setSummary(RoleView.getSummary());
        getRole.setUpdateTime(new Date());
        getRole.updateById();
        roleMenuService.updateRoleMenu(RoleView);
        // 修改成功后，需要删除redis中所有的admin访问路径
        deleteAdminVisitUrl();
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Transactional
    @Override
    public String deleteRole(RoleView RoleView) {
        // 判断该角色下是否绑定了管理员
        QueryWrapper<Admin> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        blogQueryWrapper.in(SQLConf.ROLEUID, RoleView.getUid());
        Integer adminCount = adminService.count(blogQueryWrapper);
        if (adminCount > 0) {
            return ResultUtil.errorWithMessage(MessageConf.ADMIN_UNDER_THIS_ROLE);
        }
        Role role = roleService.getById(RoleView.getUid());
        role.setStatus(EStatus.DISABLED);
        role.setUpdateTime(new Date());
        role.updateById();
        //删除角色菜单
        roleMenuService.deleteRoleMenu(role.getUid());
        deleteAdminVisitUrl();
        return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
    }
    /**
     * 删除Redis中管理员的访问路径
     */
    private void deleteAdminVisitUrl() {
        Set<String> keys = redisUtil.keys(RedisConf.ADMIN_VISIT_MENU + "*");
        redisUtil.delete(keys);
    }
}
