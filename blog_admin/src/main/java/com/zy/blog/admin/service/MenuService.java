package com.zy.blog.admin.service;

import com.zy.blog.entity.Menu;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MenuService {
    public List<Menu> getRouterList(@RequestParam("userid")String userid);
}
