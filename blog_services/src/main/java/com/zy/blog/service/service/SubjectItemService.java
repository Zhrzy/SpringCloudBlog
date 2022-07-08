package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.SubjectItem;
import com.zy.blog.view.SubjectItemView;

import java.util.List;

/**
 * 专题item表 服务类
 *
 * @author 小章鱼
 * @date 2021年8月23日07:56:21
 */
public interface SubjectItemService extends ServiceBase<SubjectItem> {

    /**
     * 获取专题item列表
     *
     * @param SubjectItemView
     * @return
     */
    IPage<SubjectItem> getPageList(SubjectItemView SubjectItemView);

    /**
     * 批量新增专题
     *
     * @param SubjectItemViewList
     */
    String addSubjectItemList(List<SubjectItemView> SubjectItemViewList);

    /**
     * 编辑专题item
     *
     * @param SubjectItemViewList
     */
    String editSubjectItemList(List<SubjectItemView> SubjectItemViewList);

    /**
     * 批量删除专题item
     *
     * @param SubjectItemViewList
     */
    String deleteBatchSubjectItem(List<SubjectItemView> SubjectItemViewList);

    /**
     * 通过博客uid批量删除专题item
     *
     * @param blogUid
     * @return
     */
    String deleteBatchSubjectItemByBlogUid(List<String> blogUid);

    /**
     * 通过创建时间排序专题列表
     * @param isDesc
     * @return
     */
    String sortByCreateTime(String subjectUid, Boolean isDesc);

}
