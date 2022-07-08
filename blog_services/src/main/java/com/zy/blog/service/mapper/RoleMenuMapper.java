package com.zy.blog.service.mapper;


import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.Role;
import com.zy.blog.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色表 Mapper 接口
 *
 * @author limbo
 * @since 2021-09-30
 */
@Mapper
public interface RoleMenuMapper extends SuperMapper<RoleMenu> {

}
