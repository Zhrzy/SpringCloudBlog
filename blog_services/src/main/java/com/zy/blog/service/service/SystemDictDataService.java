package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Dict;
import com.zy.blog.entity.SysDictData;
import com.zy.blog.view.SysDictDataView;

import java.util.List;
import java.util.Map;


public interface SystemDictDataService  extends ServiceBase<SysDictData> {

    public Map<String, Map<String, Object>> selectByTypeList(List<String> typeIds);

    /**
     * 根据字典类型获取字典数据
     *
     * @param dictType
     * @return
     */
    public Map<String, Object> getListByDictType(String dictType);

    /**
     * 获取数据字典列表
     *
     * @param sysDictDataVO
     * @return
     */
    public IPage<SysDictData> getPageList(SysDictDataView sysDictDataVO);

    /**
     * 新增数据字典
     *
     * @param sysDictDataVO
     */
    public String addSysDictData(SysDictDataView sysDictDataVO);

    /**
     * 编辑数据字典
     *
     * @param sysDictDataVO
     */
    public String editSysDictData(SysDictDataView sysDictDataVO);

    /**
     * 批量删除数据字典
     *
     * @param sysDictDataVOList
     */
    public String deleteBatchSysDictData(List<SysDictDataView> sysDictDataVOList);


    /**
     * 根据字典类型数组获取字典数据
     *
     * @param dictTypeList
     * @return
     */
    public Map<String, Map<String, Object>> getListByDictTypeList(List<String> dictTypeList);


}
