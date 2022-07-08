package com.zy.blog.service.mapper;


import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.Dict;
import com.zy.blog.entity.SysDictData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface SystemDictDataMapper extends SuperMapper<SysDictData> {

    public List<SysDictData> selectByTypeList(@RequestParam("typeId") String typeId);
}
