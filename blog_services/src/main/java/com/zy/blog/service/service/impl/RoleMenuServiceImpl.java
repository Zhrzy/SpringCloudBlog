package com.zy.blog.service.service.impl;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.Role;
import com.zy.blog.entity.RoleMenu;
import com.zy.blog.service.mapper.RoleMapper;
import com.zy.blog.service.mapper.RoleMenuMapper;
import com.zy.blog.service.service.AdminService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoleMenuServiceImpl extends ServiceImplBase<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Resource
    RoleMenuService roleMenuService;

    @Transactional
    @Override
    public String addRoleMenu(String roleId ,String menuUids) {
        menuUids = menuUids.substring(1,menuUids.length()-1);
        menuUids.replaceAll("\"","");
        String[] uids = StringUtils.split(menuUids,",");
        List<RoleMenu> list = new ArrayList<>();
        for(String uid :uids){
            RoleMenu roleMenu =new RoleMenu();
            roleMenu.setRoleUid(roleId);
            roleMenu.setMenuUid(uid);
            roleMenu.setStatus(EStatus.ENABLE);
            roleMenu.insert();
        }
        return ResultUtil.successWithMessage("插入角色菜单成功");
    }

    @Transactional
    @Override
    public String deleteRoleMenu(String roleIds) {
        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ROLE_UID,roleIds);
        List<RoleMenu> roleMenus = roleMenuService.list(queryWrapper);
        roleMenus.stream().forEach(roleMenu->{
            roleMenu.setStatus(EStatus.DISABLED);
            roleMenuService.updateById(roleMenu);
        });
        /*roleMenuService.updateBatchById(roleMenus);*/
        return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
    }

    @Transactional
    @Override
    public String updateRoleMenu(RoleView roleView) {
        String roleUid = roleView.getUid();
        String menuUids = roleView.getCategoryMenuUids();
        menuUids = menuUids.substring(2,menuUids.length()-2).replaceAll("\"","");
        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ROLE_UID, roleUid);
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        //老的
        List<RoleMenu> listOld = roleMenuService.list(queryWrapper);
        List<String> uidsOld = listOld.stream().map(s->s.getMenuUid()).collect(Collectors.toList());
        //新的
        String[] uids = StringUtils.split(menuUids,",");
        List<String> uidsNew = Arrays.stream(uids).collect(Collectors.toList());
        //获取需要删除的菜单
        List<String> dump = new ArrayList<>(uidsOld);
        dump.removeAll(uidsNew);
        if(dump.size()>0){
            QueryWrapper<RoleMenu> del = new QueryWrapper<>();
            del.eq(SQLConf.ROLE_UID,roleUid);
            del.in(SQLConf.MENU_UID,dump);
            List<RoleMenu> roleMenus = roleMenuService.list(del);
            if (roleMenus.size()>0)
                roleMenus.stream().forEach(roleMenu->{
                    roleMenu.setStatus(EStatus.DISABLED);
                    roleMenuService.updateById(roleMenu);
                });
        }

        //获取需要新增的
        List<String> addNeed = new ArrayList<>(uidsNew);
        addNeed.removeAll(listOld);
        for(String uid :addNeed){
            RoleMenu roleMenu =new RoleMenu();
            roleMenu.setRoleUid(roleUid);
            roleMenu.setMenuUid(uid);
            roleMenu.setStatus(EStatus.ENABLE);
            roleMenu.insert();
            System.out.println("");
        }
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

}
