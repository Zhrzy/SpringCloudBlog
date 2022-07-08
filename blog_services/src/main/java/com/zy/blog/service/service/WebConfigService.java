package com.zy.blog.service.service;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.WebConfig;
import com.zy.blog.view.WebConfigView;

/**
 * 网站配置表 服务类
 *
 * @author 小章鱼
 * @date 2021年11月11日14:55:05
 */
public interface WebConfigService extends ServiceBase<WebConfig> {

    /**
     * 获取网站配置
     *
     * @return
     */
    WebConfig getWebConfig();

    /**
     * 获取网站名称
     * @return
     */
    String getWebSiteName();

    /**
     * 通过显示列表获取配置
     *
     * @return
     */
    WebConfig getWebConfigByShowList();

    /**
     * 修改网站配置
     *
     * @param webConfigVO
     * @return
     */
    String editWebConfig(WebConfigView webConfigVO);

    /**
     * 是否开启该登录方式【账号密码、码云、Github、QQ、微信】
     * @param loginType
     * @return
     */
    Boolean isOpenLoginType(String loginType);
}
