package com.zy.blog.service.service;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.SystemConfig;
import com.zy.blog.view.SystemConfigView;

import java.util.List;

public interface SystemConfigService extends ServiceBase<SystemConfig> {

    public SystemConfig selectSystemConfig();

    public int editSystemConfig(SystemConfigView systemConfigView);
    /**
     * 获取系统配置
     *
     * @return
     */
    public SystemConfig getConfig();

    /**
     * 通过Key前缀清空Redis缓存
     *
     * @param key
     * @return
     */
    public String cleanRedisByKey(List<String> key);



    /**
     * 获取系统配置中的搜索模式
     * @return
     */
    public String getSearchModel();
}
