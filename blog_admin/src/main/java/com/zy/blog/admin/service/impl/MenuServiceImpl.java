package com.zy.blog.admin.service.impl;

import com.zy.blog.admin.mapper.MenuMapper;
import com.zy.blog.admin.service.MenuService;
import com.zy.blog.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    public List<Menu> getRouterList(String userid) {
        return menuMapper.getRouterList(userid);
    }
}
