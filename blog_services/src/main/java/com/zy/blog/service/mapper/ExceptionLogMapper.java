package com.zy.blog.service.mapper;


import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作日志 Mapper 接口
 *
 * @author limbo
 * @since 2021-11-18
 */
@Mapper
public interface ExceptionLogMapper extends SuperMapper<ExceptionLog> {

}
