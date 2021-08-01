package com.zy.blog.admin.service;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.SystemConfig;
import com.zy.blog.view.SystemConfigView;

import java.util.List;

public interface SystemConfigService extends ServiceBase<SystemConfig> {

    public SystemConfig selectSystemConfig();

    public int editSystemConfig(SystemConfigView systemConfigView);
}
