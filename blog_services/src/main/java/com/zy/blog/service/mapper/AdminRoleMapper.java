package com.zy.blog.service.mapper;

import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.Admin;
import com.zy.blog.entity.AdminRole;
import com.zy.blog.view.AdminView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AdminRoleMapper extends SuperMapper<AdminRole> {


}
