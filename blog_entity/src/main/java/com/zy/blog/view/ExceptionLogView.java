package com.zy.blog.view;

import com.zy.blog.base.ViewBase;
import lombok.Data;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/8/22 23:00
 **/
@Data
public class ExceptionLogView extends ViewBase {
    /**
     * 操作IP
     */
    private String ip;

    /**
     * ip来源
     */
    private String ipSource;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 描述
     */
    private String operation;

    /**
     * 参数
     */
    private String params;

    /**
     * 异常对象json格式
     */
    private String exceptionJson;

    /**
     * 异常简单信息,等同于e.getMessage
     */
    private String exceptionMessage;

    /**
     * 开始时间
     */
    private String startTime;
}
