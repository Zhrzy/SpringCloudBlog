package com.zy.blog.oauth.mapper;

import com.zy.blog.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface AdminMapper {
    public Admin getUserByUsername(@RequestParam("username") String username);
}
