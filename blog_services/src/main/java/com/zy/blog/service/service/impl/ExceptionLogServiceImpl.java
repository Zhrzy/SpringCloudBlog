package com.zy.blog.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.ExceptionLog;
import com.zy.blog.service.mapper.ExceptionLogMapper;
import com.zy.blog.service.service.ExceptionLogService;
import com.zy.blog.utils.constant.Constants;
import com.zy.blog.utils.constant.SQLConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.util.DateUtils;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.ExceptionLogView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 操作日志 服务实现类
 *
 * @author limbo
 * @date 2021-09-30
 */
@Service
public class ExceptionLogServiceImpl extends ServiceImplBase<ExceptionLogMapper, ExceptionLog> implements ExceptionLogService {

    @Autowired
    private ExceptionLogService exceptionLogService;



    @Override
    public IPage<ExceptionLog> getPageList(ExceptionLogView exceptionLogVO) {
        QueryWrapper<ExceptionLog> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(exceptionLogVO.getKeyword())) {
            queryWrapper.like(SQLConf.CONTENT, exceptionLogVO.getKeyword());
        }

        if (!StringUtils.isEmpty(exceptionLogVO.getOperation())) {
            queryWrapper.like(SQLConf.OPERATION, exceptionLogVO.getOperation());
        }

        if (!StringUtils.isEmpty(exceptionLogVO.getStartTime())) {
            String[] time = exceptionLogVO.getStartTime().split(SysConf.FILE_SEGMENTATION);
            if (time.length == Constants.NUM_TWO) {
                queryWrapper.between(SQLConf.CREATE_TIME, DateUtils.str2Date(time[0]), DateUtils.str2Date(time[1]));
            }
        }

        Page<ExceptionLog> page = new Page<>();
        page.setCurrent(exceptionLogVO.getCurrentPage());
        page.setSize(exceptionLogVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.CREATE_TIME);
//        queryWrapper.select(ExceptionLog.class, i -> !i.getProperty().equals(SQLConf.EXCEPTION_JSON));
        IPage<ExceptionLog> pageList = exceptionLogService.page(page, queryWrapper);
        return pageList;
    }
}
