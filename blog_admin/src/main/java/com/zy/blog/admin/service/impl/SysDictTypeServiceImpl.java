package com.zy.blog.admin.service.impl;

import com.zy.blog.admin.mapper.SysDictTypeMapper;
import com.zy.blog.admin.service.SysDictTypeService;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.SysDictType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Zy_Zhr
 * @description:数据字典类型服务实现
 * @date: 2021/7/31 11:20
 **/

@Service
public class SysDictTypeServiceImpl extends ServiceImplBase<SysDictTypeMapper,SysDictType> implements SysDictTypeService {


    @Resource
    private SysDictTypeMapper sysDictTypeMapper;

    @Override
    public List<SysDictType> selectDictTypeList(List<String> types) {
        //from redis

        //from mysql
        return sysDictTypeMapper.selectDictTypeList(types);
    }
}
