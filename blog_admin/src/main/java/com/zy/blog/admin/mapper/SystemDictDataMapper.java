package com.zy.blog.admin.mapper;

import com.zy.blog.entity.Dict;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface SystemDictDataMapper {

    public List<Dict> selectByTypeList(@RequestParam("typeId") String typeId);
}
