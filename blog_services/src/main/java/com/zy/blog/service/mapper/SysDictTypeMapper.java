package com.zy.blog.service.mapper;


import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.SysDictType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysDictTypeMapper extends SuperMapper<SysDictType> {
    public List<SysDictType> selectDictTypeList(List<String> types);
}
