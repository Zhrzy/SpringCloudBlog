package com.zy.blog.admin.service.impl;

import com.zy.blog.admin.mapper.SystemDictDataMapper;
import com.zy.blog.admin.service.SystemDictDataService;
import com.zy.blog.entity.Dict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemDictDataServiceImpl implements SystemDictDataService {

    @Resource
    private SystemDictDataMapper systemDictDataMapper;

    @Override
    public Map<String, Map<String, Object>> selectByTypeList(List<String> typeIds) {
        Map<String, Map<String, Object>> map = new HashMap<>();
        Map<String,Object>  result = new HashMap<>();
        List<Dict> list = systemDictDataMapper.selectByTypeList("1");
        result.put("list",list);
        map.put("icon_type",result);
        return map;
    }
}
