package com.zy.blog.admin.service;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.SysDictType;

import java.util.List;

/**
 * @author: Zy_Zhr
 * @description: 数据字段表类型Service
 * @date:
 **/
public interface SysDictTypeService extends ServiceBase<SysDictType> {
    public List<SysDictType> selectDictTypeList(List<String> types);
}
