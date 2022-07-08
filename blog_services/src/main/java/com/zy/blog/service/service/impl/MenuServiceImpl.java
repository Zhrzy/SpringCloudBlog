package com.zy.blog.service.service.impl;


import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.Menu;
import com.zy.blog.service.mapper.MenuMapper;
import com.zy.blog.service.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImplBase<MenuMapper,Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    public List<Menu> getRouterList(String userid) {
        return menuMapper.getRouterList(userid);
    }

}
