package com.zy.blog.admin.mapper;

import com.zy.blog.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Mapper
public interface MenuMapper {
    public List<Menu> getRouterList(@RequestParam("userid") String userid);
}
