package com.zy.blog.service.mapper;

import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.SystemConfig;
import com.zy.blog.example.SystemConfigExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemConfigMapper extends SuperMapper<SystemConfig> {

    public List<SystemConfig> selectSystemConfig();

    int editSystemConfig(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);
}
