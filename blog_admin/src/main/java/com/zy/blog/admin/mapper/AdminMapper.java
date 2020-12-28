package com.zy.blog.admin.mapper;

import com.zy.blog.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface AdminMapper {
    public Admin login(@RequestParam("username")String username, @RequestParam("password")String password);
}
