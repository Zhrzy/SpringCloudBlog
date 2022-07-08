package com.zy.blog.view;

import com.zy.blog.base.ViewBase;
import com.zy.blog.utils.annotion.validator.annotion.IntegerNotNull;
import com.zy.blog.utils.annotion.validator.annotion.NotBlank;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import lombok.Data;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/8/22 23:10
 **/
@Data
public class SysParamsView extends ViewBase {

    /**
     * 参数名称
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String paramsName;

    /**
     * 参数键名
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String paramsKey;

    /**
     * 参数键值
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String paramsValue;

    /**
     * 参数类型，是否系统内置（1：是，0：否）
     */
    @IntegerNotNull(groups = {Insert.class, Update.class})
    private Integer paramsType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序字段
     */
    @IntegerNotNull(groups = {Insert.class, Update.class})
    private Integer sort;
}
