package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.SysParams;
import com.zy.blog.view.SysParamsView;

import java.util.List;

/**
 * 参数配置 服务类
 *
 * @author 小章鱼
 * @date 2021年7月21日15:54:00
 */
public interface SysParamsService extends ServiceBase<SysParams> {

    /**
     * 获取参数配置列表
     *
     * @param SysParamsView
     * @return
     */
    public IPage<SysParams> getPageList(SysParamsView SysParamsView);

    /**
     * 通过 参数键名 获取参数配置
     *
     * @param paramsKey
     * @return
     */
    public SysParams getSysParamsByKey(String paramsKey);

    /**
     * 通过 参数键名 获取参数值
     *
     * @param paramsKey
     * @return
     */
    public String getSysParamsValueByKey(String paramsKey);

    /**
     * 新增参数配置
     *
     * @param SysParamsView
     */
    public String addSysParams(SysParamsView SysParamsView);

    /**
     * 编辑参数配置
     *
     * @param SysParamsView
     */
    public String editSysParams(SysParamsView SysParamsView);

    /**
     * 批量删除参数配置
     *
     * @param SysParamsViewList
     */
    public String deleteBatchSysParams(List<SysParamsView> SysParamsViewList);
}
