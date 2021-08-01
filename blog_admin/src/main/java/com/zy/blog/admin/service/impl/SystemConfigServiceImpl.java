package com.zy.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zy.blog.admin.mapper.SystemConfigMapper;
import com.zy.blog.admin.service.SystemConfigService;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.constant.EntityConstant;
import com.zy.blog.constant.SqlConstant;
import com.zy.blog.entity.SystemConfig;
import com.zy.blog.example.SystemConfigExample;
import com.zy.blog.view.SystemConfigView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemConfigServiceImpl extends ServiceImplBase<SystemConfigMapper,SystemConfig> implements SystemConfigService {
    @Resource
    private SystemConfigMapper systemConfigMapper;
    @Override
    public SystemConfig selectSystemConfig() {
        //from redis

        //from mysql
        QueryWrapper<SystemConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(EntityConstant.STATUS,"1")
                    .orderByDesc(EntityConstant.CREATE_TIME).last(SqlConstant.LIMIT_ONE);
        SystemConfig systemConfig = systemConfigMapper.selectOne(queryWrapper);
        return systemConfig;
    }

    @Override
    public int editSystemConfig(SystemConfigView systemConfigView) {
        UpdateWrapper<SystemConfig> uw = new UpdateWrapper();
        SystemConfig systemConfig = new SystemConfig();
        BeanUtils.copyProperties(systemConfigView,systemConfig);
        SystemConfigExample example =new SystemConfigExample();
        SystemConfigExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(systemConfigView.getUid());
        return systemConfigMapper.editSystemConfig(systemConfig,example);
    }
}
