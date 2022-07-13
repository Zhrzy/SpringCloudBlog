package com.zy.blog.service.service.impl;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.CategoryMenu;
import com.zy.blog.entity.Menu;
import com.zy.blog.entity.Role;
import com.zy.blog.entity.RoleMenu;
import com.zy.blog.service.mapper.RoleMapper;
import com.zy.blog.service.mapper.RoleMenuMapper;
import com.zy.blog.service.service.AdminService;
import com.zy.blog.service.service.CategoryMenuService;
import com.zy.blog.service.service.RoleMenuService;
import com.zy.blog.service.service.RoleService;
import com.zy.blog.utils.constant.EStatus;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SQLConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EMenuType;
import com.zy.blog.utils.util.RedisUtil;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.RoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class RoleMenuServiceImpl extends ServiceImplBase<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Resource
    RoleMenuService roleMenuService;
    @Resource
    CategoryMenuService categoryMenuService;

    @Resource
    RoleMenuMapper roleMenuMapper;
    @Transactional
    @Override
    public String addRoleMenu(String roleId ,String menuUids) {
        menuUids = menuUids.substring(1,menuUids.length()-1);
        menuUids =  menuUids.replaceAll("\"","");
        String[] uids = StringUtils.split(menuUids,",");
        List<RoleMenu> list = new ArrayList<>();
        //二级菜单
        QueryWrapper<CategoryMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(SQLConf.UID,Arrays.asList(uids));
        queryWrapper.eq(SQLConf.STATUS,1);
        queryWrapper.isNotNull("parent_uid");
        queryWrapper.select("DISTINCT parent_uid");

        List<CategoryMenu>  menus = categoryMenuService.list(queryWrapper);
        List<String> levelSecondMenuIds = new ArrayList<>();
        for(CategoryMenu menu:menus){
            levelSecondMenuIds.add(menu.getParentUid());
        }
        //一级菜单
        QueryWrapper<CategoryMenu> queryWrapperOne = new QueryWrapper<>();
        queryWrapperOne.in(SQLConf.UID,levelSecondMenuIds);
        queryWrapperOne.eq(SQLConf.STATUS,1);
        queryWrapperOne.isNotNull("parent_uid");
        queryWrapperOne.select("DISTINCT parent_uid");
        List<CategoryMenu>  menuLevelOne = categoryMenuService.list(queryWrapperOne);
        List<String> levelOneMenuIds =new ArrayList<>();
        for(CategoryMenu menu:menuLevelOne){
            levelOneMenuIds.add(menu.getParentUid());
        }
        Set<String> setMenuIds = new HashSet<String>(Arrays.asList(uids));
        setMenuIds.addAll(levelSecondMenuIds);
        setMenuIds.addAll(levelOneMenuIds);
        setMenuIds.stream().forEach(menuId -> {
            RoleMenu roleMenu =new RoleMenu();
            roleMenu.setRoleUid(roleId);
            roleMenu.setMenuUid(menuId);
            roleMenu.setStatus(EStatus.ENABLE);
            list.add(roleMenu);
        });
        roleMenuService.saveBatch(list,20);
        return ResultUtil.successWithMessage("插入角色菜单成功");
    }

    @Transactional
    @Override
    public String deleteRoleMenu(String roleIds) {
        QueryWrapper<RoleMenu> delete = new QueryWrapper<>();
        delete.eq(SQLConf.ROLE_UID, roleIds);
        roleMenuMapper.delete(delete);
        /*QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ROLE_UID,roleIds);
        List<RoleMenu> roleMenus = roleMenuService.list(queryWrapper);
        roleMenus.stream().forEach(roleMenu->{
            roleMenu.setStatus(EStatus.DISABLED);
            roleMenuService.updateById(roleMenu);
        });*/
        /*roleMenuService.updateBatchById(roleMenus);*/
        return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
    }

    @Transactional
    @Override
    public String updateRoleMenu(RoleView roleView) {
        //获取到全部的菜单id
        String roleUid = roleView.getUid();
        String uids = roleView.getCategoryMenuUids();
        uids = uids.substring(2,uids.length()-2).replaceAll("\"","");
        String[] menuUidsArray = StringUtils.split(uids,",");
        //将老的删除
        /*UpdateWrapper<RoleMenu> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq(SQLConf.ROLE_UID, roleUid);
        //updateWrapper.set(SQLConf.STATUS, 0);
        roleMenuService.update(updateWrapper);*/
        QueryWrapper<RoleMenu> delete = new QueryWrapper<>();
        delete.eq(SQLConf.ROLE_UID, roleUid);
        roleMenuMapper.delete(delete);
        //重建所有的菜单，放入
        //二级菜单
        List<String> listUid = Arrays.asList(menuUidsArray);
        QueryWrapper<CategoryMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(SQLConf.UID,listUid);
        queryWrapper.eq(SQLConf.STATUS,1);
        queryWrapper.isNotNull("parent_uid");
        queryWrapper.select("DISTINCT parent_uid");
        List<CategoryMenu>  menus = categoryMenuService.list(queryWrapper);
        List<String> levelSecondMenuIds = menus.stream()
                .filter(a->a.getParentUid()!=null&&!"".equals(a.getParentUid()))
                .map(s->s.getParentUid()).collect(Collectors.toList());
        //一级菜单
        QueryWrapper<CategoryMenu> queryWrapperOne = new QueryWrapper<>();
        queryWrapperOne.in(SQLConf.UID,levelSecondMenuIds);
        queryWrapperOne.eq(SQLConf.STATUS,1);
        queryWrapperOne.isNotNull("parent_uid");
        queryWrapperOne.select("DISTINCT parent_uid");
        List<CategoryMenu>  menuLevelOne = categoryMenuService.list(queryWrapperOne);
        List<String> levelOneMenuIds = menuLevelOne.stream()
                .filter(a->a.getParentUid()!=null&&!"".equals(a.getParentUid()))
                .map(s->s.getParentUid()).collect(Collectors.toList());
        //报文中的 + 二级 +一级菜单  去重处理
        Set<String> setMenuIds = new HashSet<String>(listUid);
        setMenuIds.addAll(levelSecondMenuIds);
        setMenuIds.addAll(levelOneMenuIds);
        //构建
        List<RoleMenu> list = new ArrayList<>();
        setMenuIds.parallelStream().forEach(menuId -> {
            RoleMenu roleMenu =new RoleMenu();
            roleMenu.setRoleUid(roleView.getUid());
            roleMenu.setMenuUid(menuId);
            roleMenu.setStatus(EStatus.ENABLE);
            list.add(roleMenu);
        });
        roleMenuService.saveBatch(list);
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

}
