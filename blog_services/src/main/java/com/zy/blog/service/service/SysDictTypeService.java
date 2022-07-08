package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.SysDictType;
import com.zy.blog.view.SysDictTypeView;

import java.util.List;

/**
 * @author: 小章鱼
 * @description: 数据字段表类型Service
 * @date:
 **/
public interface SysDictTypeService extends ServiceBase<SysDictType> {
    public List<SysDictType> selectDictTypeList(List<String> types);
    /**
     * 获取字典类型列表
     *
     * @param sysDictTypeVO
     * @return
     */
    public IPage<SysDictType> getPageList(SysDictTypeView sysDictTypeVO);

    /**
     * 新增字典类型
     *
     * @param sysDictTypeVO
     */
    public String addSysDictType(SysDictTypeView sysDictTypeVO);

    /**
     * 编辑字典类型
     *
     * @param sysDictTypeVO
     */
    public String editSysDictType(SysDictTypeView sysDictTypeVO);

    /**
     * 批量删除字典类型
     *
     * @param sysDictTypeVOList
     */
    public String deleteBatchSysDictType(List<SysDictTypeView> sysDictTypeVOList);
}
