package com.zy.blog.service.service;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Menu;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MenuService extends ServiceBase<Menu> {
    public List<Menu> getRouterList(@RequestParam("userid")String userid);
}
