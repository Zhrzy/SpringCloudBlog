package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.ExceptionLog;
import com.zy.blog.view.ExceptionLogView;

/**
 * 操作异常日志 服务类
 *
 * @author limbo
 * @date 2021-09-30
 */
public interface ExceptionLogService extends ServiceBase<ExceptionLog> {

    /**
     * 获取异常日志列表
     *
     * @param exceptionLogVO
     * @return
     */
    public IPage<ExceptionLog> getPageList(ExceptionLogView exceptionLogVO);
}
