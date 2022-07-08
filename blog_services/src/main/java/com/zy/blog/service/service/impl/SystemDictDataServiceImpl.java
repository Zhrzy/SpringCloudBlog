package com.zy.blog.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.Dict;
import com.zy.blog.entity.SysDictData;
import com.zy.blog.entity.SysDictType;
import com.zy.blog.service.mapper.SystemDictDataMapper;
import com.zy.blog.service.service.SysDictTypeService;
import com.zy.blog.service.service.SystemDictDataService;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SQLConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.constant.SysConstant;
import com.zy.blog.utils.enums.EPublish;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.JsonUtils;
import com.zy.blog.utils.util.RedisUtil;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.SysDictDataView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class SystemDictDataServiceImpl extends ServiceImplBase<SystemDictDataMapper,SysDictData> implements SystemDictDataService {

    @Resource
    private SystemDictDataMapper systemDictDataMapper;
    @Resource
    private SysDictTypeService sysDictTypeService;
    @Autowired
    private SystemDictDataService systemDictDataService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Map<String, Map<String, Object>> selectByTypeList(List<String> types) {
        Map<String, Map<String, Object>> map = new HashMap<>();
        //from redis

        //数据库查询
        List<SysDictType> dictTypes =sysDictTypeService.selectDictTypeList(types);
        dictTypes.forEach(dictType -> {
            List<SysDictData> list =  systemDictDataMapper.selectByTypeList(dictType.getUid());
            QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("dict_type_uid",dictType.getUid());
            List<SysDictData> list1 = systemDictDataMapper.selectList(queryWrapper);
            Map<String,Object>  result = new HashMap<>();
            result.put(SysConstant.LIST,list1);
            map.put(dictType.getDictType(),result);
        });
        return map;
    }

    public Map<String, Object> getListByDictType(String dictType) {
        //从Redis中获取内容
        String jsonResult = redisUtil.get(SysConf.REDIS_DICT_TYPE + SysConf.REDIS_SEGMENTATION + dictType);
        //判断redis中是否有字典
        if (StringUtils.isNotEmpty(jsonResult)) {
            Map<String, Object> map = JsonUtils.jsonToMap(jsonResult);
            return map;
        }
        //获取字典类型的完整数据
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.DICT_TYPE, dictType);
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.eq(SQLConf.IS_PUBLISH, EPublish.PUBLISH);
        queryWrapper.last(SysConf.LIMIT_ONE);
        SysDictType sysDictType = sysDictTypeService.getOne(queryWrapper);
        if (sysDictType == null) {
            return new HashMap<>();
        }
        //获取字典类型的完整的数据
        QueryWrapper<SysDictData> sysDictDataQueryWrapper = new QueryWrapper<>();
        sysDictDataQueryWrapper.eq(SQLConf.IS_PUBLISH, EPublish.PUBLISH);
        sysDictDataQueryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        sysDictDataQueryWrapper.eq(SQLConf.DICT_TYPE_UID, sysDictType.getUid());
        sysDictDataQueryWrapper.orderByDesc(SQLConf.SORT, SQLConf.CREATE_TIME);
        List<SysDictData> list = systemDictDataService.list(sysDictDataQueryWrapper);

        String defaultValue = null;
        for (SysDictData sysDictData : list) {
            // 获取默认值
            if (sysDictData.getIsDefault() == SysConf.ONE) {
                defaultValue = sysDictData.getDictValue();
                break;
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put(SysConf.DEFAULT_VALUE, defaultValue);
        result.put(SysConf.LIST, list);
        redisUtil.setEx(SysConf.REDIS_DICT_TYPE + SysConf.REDIS_SEGMENTATION + dictType, JsonUtils.objectToJson(result).toString(), 1, TimeUnit.DAYS);
        return result;
    }


    @Override
    public IPage<SysDictData> getPageList(SysDictDataView sysDictDataVO) {
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
        // 字典类型UID
        if (StringUtils.isNotEmpty(sysDictDataVO.getDictTypeUid())) {
            queryWrapper.eq(SQLConf.DICT_TYPE_UID, sysDictDataVO.getDictTypeUid());
        }
        // 字典标签
        if (StringUtils.isNotEmpty(sysDictDataVO.getDictLabel()) && !StringUtils.isEmpty(sysDictDataVO.getDictLabel().trim())) {
            queryWrapper.like(SQLConf.DICT_LABEL, sysDictDataVO.getDictLabel().trim());
        }
        Page<SysDictData> page = new Page<>();
        page.setCurrent(sysDictDataVO.getCurrentPage());
        page.setSize(sysDictDataVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.SORT, SQLConf.CREATE_TIME);
        IPage<SysDictData> pageList = systemDictDataService.page(page, queryWrapper);
        List<SysDictData> sysDictDataList = pageList.getRecords();
        Set<String> dictTypeUidList = new HashSet<>();
        sysDictDataList.forEach(item -> {
            dictTypeUidList.add(item.getDictTypeUid());
        });
        Collection<SysDictType> dictTypeList = new ArrayList<>();
        if (dictTypeUidList.size() > 0) {
            dictTypeList = sysDictTypeService.listByIds(dictTypeUidList);
        }
        Map<String, SysDictType> dictTypeMap = new HashMap<>();
        dictTypeList.forEach(item -> {
            dictTypeMap.put(item.getUid(), item);
        });
        sysDictDataList.forEach(item -> {
            item.setSysDictType(dictTypeMap.get(item.getDictTypeUid()));
        });
        pageList.setRecords(sysDictDataList);
        return pageList;
    }

    @Override
    public String addSysDictData(SysDictDataView sysDictDataVO) {
        HttpServletRequest request = RequestHolder.getRequest();
        String adminUid = request.getAttribute(SysConf.ADMIN_UID).toString();
        // 判断添加的字典数据是否存在
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.DICT_LABEL, sysDictDataVO.getDictLabel());
        queryWrapper.eq(SQLConf.DICT_TYPE_UID, sysDictDataVO.getDictTypeUid());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.last(SysConf.LIMIT_ONE);
        SysDictData temp = systemDictDataService.getOne(queryWrapper);
        if (temp != null) {
            return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
        }
        SysDictData sysDictData = new SysDictData();
        // 插入字典数据，忽略状态位【使用Spring工具类提供的深拷贝，避免出现大量模板代码】
        BeanUtils.copyProperties(sysDictDataVO, sysDictData, SysConf.STATUS);
        sysDictData.setCreateByUid(adminUid);
        sysDictData.setUpdateByUid(adminUid);
        sysDictData.insert();
        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editSysDictData(SysDictDataView sysDictDataVO) {
        HttpServletRequest request = RequestHolder.getRequest();
        String adminUid = request.getAttribute(SysConf.ADMIN_UID).toString();
        SysDictData sysDictData = systemDictDataService.getById(sysDictDataVO.getUid());
        // 更改了标签名时，判断更改的字典数据是否存在
        if (!sysDictData.getDictLabel().equals(sysDictDataVO.getDictLabel())) {
            QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(SQLConf.DICT_LABEL, sysDictDataVO.getDictLabel());
            queryWrapper.eq(SQLConf.DICT_TYPE_UID, sysDictDataVO.getDictTypeUid());
            queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
            queryWrapper.last(SysConf.LIMIT_ONE);
            SysDictData temp = systemDictDataService.getOne(queryWrapper);
            if (temp != null) {
                return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
            }
        }
        // 更新数据字典【使用Spring工具类提供的深拷贝，避免出现大量模板代码】
        BeanUtils.copyProperties(sysDictDataVO, sysDictData, SysConf.STATUS, SysConf.UID);
        sysDictData.setUpdateByUid(adminUid);
        sysDictData.setUpdateTime(new Date());
        sysDictData.setUpdateByUid(adminUid);
        sysDictData.updateById();

        // 获取Redis中特定前缀
        Set<String> keys = redisUtil.keys(SysConf.REDIS_DICT_TYPE + SysConf.REDIS_SEGMENTATION + "*");
        redisUtil.delete(keys);
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteBatchSysDictData(List<SysDictDataView> sysDictDataVOList) {
        HttpServletRequest request = RequestHolder.getRequest();
        String adminUid = request.getAttribute(SysConf.ADMIN_UID).toString();
        if (sysDictDataVOList.size() <= 0) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        List<String> uids = new ArrayList<>();
        sysDictDataVOList.forEach(item -> {
            uids.add(item.getUid());
        });
        Collection<SysDictData> sysDictDataList = systemDictDataService.listByIds(uids);
        sysDictDataList.forEach(item -> {
            item.setStatus(EStatus.DISABLED);
            item.setUpdateTime(new Date());
            item.setUpdateByUid(adminUid);
        });
        Boolean save = systemDictDataService.updateBatchById(sysDictDataList);
        // 获取Redis中特定前缀
        Set<String> keys = redisUtil.keys(SysConf.REDIS_DICT_TYPE + SysConf.REDIS_SEGMENTATION + "*");
        redisUtil.delete(keys);
        if (save) {
            return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
        } else {
            return ResultUtil.errorWithMessage(MessageConf.DELETE_FAIL);
        }
    }



    @Override
    public Map<String, Map<String, Object>> getListByDictTypeList(List<String> dictTypeList) {
        Map<String, Map<String, Object>> map = new HashMap<>();
        List<String> tempTypeList = new ArrayList<>();
        dictTypeList.forEach(item -> {
            //从Redis中获取内容
            String jsonResult = redisUtil.get(SysConf.REDIS_DICT_TYPE + SysConf.REDIS_SEGMENTATION + item);
            //判断redis中是否有字典
            if (StringUtils.isNotEmpty(jsonResult)) {
                Map<String, Object> tempMap = JsonUtils.jsonToMap(jsonResult);
                map.put(item, tempMap);
            } else {
                // 如果redis中没有该字典，那么从数据库中查询
                tempTypeList.add(item);
            }
        });
        // 表示数据全部从redis中获取到了，直接返回即可
        if (tempTypeList.size() <= 0) {
            return map;
        }
        // 查询 dict_type 在 tempTypeList中的
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(SQLConf.DICT_TYPE, tempTypeList);
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.eq(SQLConf.IS_PUBLISH, EPublish.PUBLISH);
        List<SysDictType> sysDictTypeList = sysDictTypeService.list(queryWrapper);
        sysDictTypeList.forEach(item -> {
            QueryWrapper<SysDictData> sysDictDataQueryWrapper = new QueryWrapper<>();
            sysDictDataQueryWrapper.eq(SQLConf.IS_PUBLISH, EPublish.PUBLISH);
            sysDictDataQueryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
            sysDictDataQueryWrapper.eq(SQLConf.DICT_TYPE_UID, item.getUid());
            sysDictDataQueryWrapper.orderByDesc(SQLConf.SORT, SQLConf.CREATE_TIME);
            List<SysDictData> list = systemDictDataService.list(sysDictDataQueryWrapper);
            String defaultValue = null;
            for (SysDictData sysDictData : list) {
                // 获取默认值
                if (sysDictData.getIsDefault() == SysConf.ONE) {
                    defaultValue = sysDictData.getDictValue();
                    break;
                }
            }
            Map<String, Object> result = new HashMap<>();
            result.put(SysConf.DEFAULT_VALUE, defaultValue);
            result.put(SysConf.LIST, list);
            map.put(item.getDictType(), result);
            redisUtil.setEx(SysConf.REDIS_DICT_TYPE + SysConf.REDIS_SEGMENTATION + item.getDictType(), JsonUtils.objectToJson(result).toString(), 1, TimeUnit.DAYS);
        });
        return map;
    }



}
