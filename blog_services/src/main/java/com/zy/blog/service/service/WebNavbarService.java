package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.WebNavbar;
import com.zy.blog.view.WebNavbarView;

import java.util.List;

/**
 * 门户页导航栏 服务类
 *
 * @author 小章鱼
 * @date 2021年2月22日17:02:38
 */
public interface WebNavbarService extends ServiceBase<WebNavbar> {

    /**
     * 分页获取门户导航栏
     *
     * @param webNavbarView
     * @return
     */
    public IPage<WebNavbar> getPageList(WebNavbarView webNavbarView);
    
    /**
     * 获取所有门户导航栏
     *
     * @return
     */
    public List<WebNavbar> getAllList();

    /**
     * 新增门户导航栏
     *
     * @param webNavbarView
     */
    public String addWebNavbar(WebNavbarView webNavbarView);

    /**
     * 编辑门户导航栏
     *
     * @param webNavbarView
     */
    public String editWebNavbar(WebNavbarView webNavbarView);

    /**
     * 删除门户导航栏
     *
     * @param webNavbarView
     */
    public String deleteWebNavbar(WebNavbarView webNavbarView);
}
