package com.zy.blog.service.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.SysDictData;
import com.zy.blog.entity.SysDictType;
import com.zy.blog.service.mapper.SysDictTypeMapper;
import com.zy.blog.service.service.SysDictTypeService;
import com.zy.blog.service.service.SystemDictDataService;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SQLConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.RedisUtil;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.SysDictTypeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author: 小章鱼
 * @description:数据字典类型服务实现
 * @date: 2021/7/31 11:20
 **/

@Service
public class SysDictTypeServiceImpl extends ServiceImplBase<SysDictTypeMapper,SysDictType> implements SysDictTypeService {


    @Resource
    private SysDictTypeMapper sysDictTypeMapper;

    @Autowired
    SystemDictDataService systemDictDataService;

    @Autowired
    SysDictTypeService sysDictTypeService;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<SysDictType> selectDictTypeList(List<String> types) {
        //from redis

        //from mysql
        return sysDictTypeMapper.selectDictTypeList(types);
    }

    @Override
    public boolean saveBatch(Collection<SysDictType> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    public IPage<SysDictType> getPageList(SysDictTypeView sysDictTypeVO) {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();

        // 字典名称
        if (StringUtils.isNotEmpty(sysDictTypeVO.getDictName()) && !StringUtils.isEmpty(sysDictTypeVO.getDictName().trim())) {
            queryWrapper.like(SQLConf.DICT_NAME, sysDictTypeVO.getDictName().trim());
        }

        // 字典类型
        if (StringUtils.isNotEmpty(sysDictTypeVO.getDictType()) && !StringUtils.isEmpty(sysDictTypeVO.getDictType().trim())) {
            queryWrapper.like(SQLConf.DICT_TYPE, sysDictTypeVO.getDictType().trim());
        }

        if(StringUtils.isNotEmpty(sysDictTypeVO.getOrderByAscColumn())) {
            // 将驼峰转换成下划线
            String column = StringUtils.underLine(new StringBuffer(sysDictTypeVO.getOrderByAscColumn())).toString();
            queryWrapper.orderByAsc(column);
        }else if(StringUtils.isNotEmpty(sysDictTypeVO.getOrderByDescColumn())) {
            // 将驼峰转换成下划线
            String column = StringUtils.underLine(new StringBuffer(sysDictTypeVO.getOrderByDescColumn())).toString();
            queryWrapper.orderByDesc(column);
        } else {
            queryWrapper.orderByDesc(SQLConf.SORT, SQLConf.CREATE_TIME);
        }

        Page<SysDictType> page = new Page<>();
        page.setCurrent(sysDictTypeVO.getCurrentPage());
        page.setSize(sysDictTypeVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        IPage<SysDictType> pageList = sysDictTypeService.page(page, queryWrapper);
        return pageList;
    }

    @Override
    public String addSysDictType(SysDictTypeView sysDictTypeVO) {
        HttpServletRequest request = RequestHolder.getRequest();
        // 判断添加的字典类型是否存在
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.DICT_TYPE, sysDictTypeVO.getDictType());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.last(SysConf.LIMIT_ONE);
        SysDictType temp = sysDictTypeService.getOne(queryWrapper);
        if (temp != null) {
            return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
        }
        SysDictType sysDictType = new SysDictType();
        sysDictType.setDictName(sysDictTypeVO.getDictName());
        sysDictType.setDictType(sysDictTypeVO.getDictType());
        sysDictType.setRemark(sysDictTypeVO.getRemark());
        sysDictType.setIsPublish(sysDictTypeVO.getIsPublish());
        sysDictType.setSort(sysDictTypeVO.getSort());
        sysDictType.setCreateByUid(request.getAttribute(SysConf.ADMIN_UID).toString());
        sysDictType.setUpdateByUid(request.getAttribute(SysConf.ADMIN_UID).toString());
        sysDictType.insert();
        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editSysDictType(SysDictTypeView sysDictTypeVO) {
        HttpServletRequest request = RequestHolder.getRequest();
        SysDictType sysDictType = sysDictTypeService.getById(sysDictTypeVO.getUid());

        // 判断编辑的字典类型是否存在
        if (!sysDictType.getDictType().equals(sysDictTypeVO.getDictType())) {
            QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(SQLConf.DICT_TYPE, sysDictTypeVO.getDictType());
            queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
            queryWrapper.last(SysConf.LIMIT_ONE);
            SysDictType temp = sysDictTypeService.getOne(queryWrapper);
            if (temp != null) {
                return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
            }
        }

        sysDictType.setDictName(sysDictTypeVO.getDictName());
        sysDictType.setDictType(sysDictTypeVO.getDictType());
        sysDictType.setRemark(sysDictTypeVO.getRemark());
        sysDictType.setIsPublish(sysDictTypeVO.getIsPublish());
        sysDictType.setSort(sysDictTypeVO.getSort());
        sysDictType.setUpdateByUid(request.getAttribute(SysConf.ADMIN_UID).toString());
        sysDictType.setUpdateTime(new Date());
        sysDictType.updateById();

        // 获取Redis中特定前缀
        Set<String> keys = redisUtil.keys(SysConf.REDIS_DICT_TYPE + SysConf.REDIS_SEGMENTATION + "*");
        redisUtil.delete(keys);
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteBatchSysDictType(List<SysDictTypeView> sysDictTypeVOList) {
        HttpServletRequest request = RequestHolder.getRequest();
        String adminUid = request.getAttribute(SysConf.ADMIN_UID).toString();
        if (sysDictTypeVOList.size() <= 0) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        List<String> uids = new ArrayList<>();
        sysDictTypeVOList.forEach(item -> {
            uids.add(item.getUid());
        });

        // 判断要删除的分类，是否有博客
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.in(SQLConf.DICT_TYPE_UID, uids);
        Integer count = systemDictDataService.count(queryWrapper);
        if (count > 0) {
            return ResultUtil.errorWithMessage(MessageConf.DICT_DATA_UNDER_THIS_SORT);
        }
        Collection<SysDictType> sysDictTypeList = sysDictTypeService.listByIds(uids);
        sysDictTypeList.forEach(item -> {
            item.setStatus(EStatus.DISABLED);
            item.setUpdateByUid(adminUid);
        });

        Boolean save = sysDictTypeService.updateBatchById(sysDictTypeList);

        // 获取Redis中特定前缀
        Set<String> keys = redisUtil.keys(SysConf.REDIS_DICT_TYPE + SysConf.REDIS_SEGMENTATION + "*");
        redisUtil.delete(keys);
        if (save) {
            return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
        } else {
            return ResultUtil.errorWithMessage(MessageConf.DELETE_FAIL);
        }
    }

}
