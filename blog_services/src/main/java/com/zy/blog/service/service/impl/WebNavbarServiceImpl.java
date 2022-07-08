package com.zy.blog.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.WebNavbar;
import com.zy.blog.service.mapper.WebNavbarMapper;
import com.zy.blog.service.service.WebNavbarService;
import com.zy.blog.utils.constant.Constants;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SQLConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.WebNavbarView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 门户页导航栏 服务实现类
 *
 * @author 小章鱼
 * @date 2021年2月22日17:11:28
 */
@Service
public class WebNavbarServiceImpl extends ServiceImplBase<WebNavbarMapper, WebNavbar> implements WebNavbarService {

    @Autowired
    WebNavbarService webNavbarService;

    @Override
    public IPage<WebNavbar> getPageList(WebNavbarView webNavbarVO) {
        Map<String, Object> resultMap = new HashMap<>();
        QueryWrapper<WebNavbar> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(webNavbarVO.getKeyword()) && !StringUtils.isEmpty(webNavbarVO.getKeyword().trim())) {
            queryWrapper.like(SQLConf.NAME, webNavbarVO.getKeyword().trim());
        }
        if (webNavbarVO.getNavbarLevel() != 0) {
            queryWrapper.eq(SQLConf.MENU_LEVEL, webNavbarVO.getNavbarLevel());
        }
        Page<WebNavbar> page = new Page<>();
        page.setCurrent(webNavbarVO.getCurrentPage());
        page.setSize(webNavbarVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.SORT);
        IPage<WebNavbar> pageList = webNavbarService.page(page, queryWrapper);
        return pageList;
    }

    @Override
    public List<WebNavbar> getAllList() {
        QueryWrapper<WebNavbar> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.NAVBAR_LEVEL, Constants.STR_ONE);
        queryWrapper.orderByDesc(SQLConf.SORT);
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);

        List<WebNavbar> list = webNavbarService.list(queryWrapper);
        //获取所有的ID，去寻找他的子目录
        List<String> ids = new ArrayList<>();
        list.forEach(item -> {
            if (StringUtils.isNotEmpty(item.getUid())) {
                ids.add(item.getUid());
            }
        });
        QueryWrapper<WebNavbar> childWrapper = new QueryWrapper<>();
        childWrapper.in(SQLConf.PARENT_UID, ids);
        childWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        Collection<WebNavbar> childList = webNavbarService.list(childWrapper);

        // 给一级导航栏设置二级导航栏
        for (WebNavbar parentItem : list) {
            List<WebNavbar> tempList = new ArrayList<>();
            for (WebNavbar item : childList) {
                if (item.getParentUid().equals(parentItem.getUid())) {
                    tempList.add(item);
                }
            }
            Collections.sort(tempList);
            parentItem.setChildWebNavbar(tempList);
        }
        return list;
    }

    @Override
    public String addWebNavbar(WebNavbarView webNavbarVO) {
        //如果是一级菜单，将父ID清空
        if (webNavbarVO.getNavbarLevel() == 1) {
            webNavbarVO.setParentUid("");
        }
        WebNavbar webNavbar = new WebNavbar();
        // 插入数据【使用Spring工具类提供的深拷贝】
        BeanUtils.copyProperties(webNavbarVO, webNavbar, SysConf.STATUS);
        webNavbar.insert();
        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editWebNavbar(WebNavbarView webNavbarVO) {
        //如果是一级菜单，将父ID清空
        if (webNavbarVO.getNavbarLevel() == 1) {
            webNavbarVO.setParentUid("");
        }
        WebNavbar webNavbar = webNavbarService.getById(webNavbarVO.getUid());
        // 插入数据【使用Spring工具类提供的深拷贝】
        BeanUtils.copyProperties(webNavbarVO, webNavbar, SysConf.STATUS, SysConf.UID);
        webNavbar.setUpdateTime(new Date());
        webNavbarService.updateById(webNavbar);
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteWebNavbar(WebNavbarView webNavbarVO) {
        QueryWrapper<WebNavbar> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.in(SQLConf.PARENT_UID, webNavbarVO.getUid());
        Integer menuCount = webNavbarService.count(queryWrapper);
        if (menuCount > 0) {
            return ResultUtil.errorWithMessage(MessageConf.CHILDREN_MENU_UNDER_THIS_MENU);
        }
        WebNavbar webNavbar = webNavbarService.getById(webNavbarVO.getUid());
        webNavbar.setStatus(EStatus.DISABLED);
        webNavbar.setUpdateTime(new Date());
        webNavbar.updateById();
        return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
    }
}
