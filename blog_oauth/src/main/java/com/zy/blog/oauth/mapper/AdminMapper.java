package com.zy.blog.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.blog.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    public Admin getUserByUsername(@RequestParam("username") String username);
}
