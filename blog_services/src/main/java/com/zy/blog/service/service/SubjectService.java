package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Subject;
import com.zy.blog.view.SubjectView;

import java.util.List;

/**
 * 专题表 服务类
 *
 * @author 小章鱼
 * @date 2021年8月22日22:03:52
 */
public interface SubjectService extends ServiceBase<Subject> {

    /**
     * 获取专题列表
     *
     * @param SubjectView
     * @return
     */
    public IPage<Subject> getPageList(SubjectView SubjectView);

    /**
     * 新增专题
     *
     * @param SubjectView
     */
    public String addSubject(SubjectView SubjectView);

    /**
     * 编辑专题
     *
     * @param SubjectView
     */
    public String editSubject(SubjectView SubjectView);

    /**
     * 批量删除专题
     *
     * @param SubjectViewList
     */
    public String deleteBatchSubject(List<SubjectView> SubjectViewList);

}
