package com.zy.blog.service.mapper;


import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.Visitor;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游客表 Mapper 接口
 *
 * @author 小章鱼
 * @since 2021-09-08
 */
@Mapper
public interface VisitorMapper extends SuperMapper<Visitor> {

}
