package com.zy.blog.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.blog.entity.Admin;
import com.zy.blog.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface RoleMapper  extends BaseMapper<Role> {
    public List<Role> getRoleListByName(@RequestParam("username") String username);
}
