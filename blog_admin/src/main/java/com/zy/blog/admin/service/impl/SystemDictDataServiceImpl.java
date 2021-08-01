package com.zy.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.blog.admin.mapper.SystemDictDataMapper;
import com.zy.blog.admin.service.SysDictTypeService;
import com.zy.blog.admin.service.SystemDictDataService;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.constant.SysConstant;
import com.zy.blog.entity.Dict;
import com.zy.blog.entity.SysDictType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemDictDataServiceImpl extends ServiceImplBase<SystemDictDataMapper,Dict> implements SystemDictDataService {

    @Resource
    private SystemDictDataMapper systemDictDataMapper;
    @Resource
    private SysDictTypeService sysDictTypeService;

    @Override
    public Map<String, Map<String, Object>> selectByTypeList(List<String> types) {
        Map<String, Map<String, Object>> map = new HashMap<>();
        //from redis

        //数据库查询
        List<SysDictType> dictTypes =sysDictTypeService.selectDictTypeList(types);
        dictTypes.forEach(dictType -> {
            List<Dict> list =  systemDictDataMapper.selectByTypeList(dictType.getUid());
            QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("dict_type_uid",dictType.getUid());
            List<Dict> list1 = systemDictDataMapper.selectList(queryWrapper);

            Map<String,Object>  result = new HashMap<>();
            result.put(SysConstant.LIST,list1);
            map.put(dictType.getDictType(),result);
        });
        return map;
    }
}
