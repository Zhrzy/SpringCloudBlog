package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.SysLog;
import com.zy.blog.view.SysLogView;

/**
 * 操作日志 服务类
 *
 * @author limbo
 * @date 2021-09-30
 */
public interface SysLogService extends ServiceBase<SysLog> {

    /**
     * 获取操作日志列表
     *
     * @param sysLogVO
     * @return
     */
    public IPage<SysLog> getPageList(SysLogView sysLogVO);
}
