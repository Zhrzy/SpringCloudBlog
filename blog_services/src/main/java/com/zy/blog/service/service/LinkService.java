package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Link;
import com.zy.blog.view.LinkView;

import java.util.List;

/**
 * 标签表 服务类
 *
 * @author 小章鱼
 * @date 2021-09-08
 */
public interface LinkService extends ServiceBase<Link> {

    /**
     * 通过页大小获取友链列表
     *
     * @param pageSize
     * @return
     */
    public List<Link> getListByPageSize(Integer pageSize);

    /**
     * 获取友链列表
     *
     * @param LinkView
     * @return
     */
    public IPage<Link> getPageList(LinkView LinkView);

    /**
     * 新增友链
     *
     * @param LinkView
     */
    public String addLink(LinkView LinkView);

    /**
     * 编辑友链
     *
     * @param LinkView
     */
    public String editLink(LinkView LinkView);

    /**
     * 删除友链
     *
     * @param LinkView
     */
    public String deleteLink(LinkView LinkView);

    /**
     * 置顶友链
     *
     * @param LinkView
     */
    public String stickLink(LinkView LinkView);

    /**
     * 点击友链
     *
     * @return
     */
    public String addLinkCount(String uid);
}
