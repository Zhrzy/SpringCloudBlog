package com.zy.blog.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.Dict;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface SystemDictDataMapper extends SuperMapper<Dict> {

    public List<Dict> selectByTypeList(@RequestParam("typeId") String typeId);
}
