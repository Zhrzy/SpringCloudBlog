package com.zy.blog.base;

import com.zy.blog.utils.annotion.validator.Messages;
import com.zy.blog.utils.annotion.validator.annotion.LongNotNull;
import com.zy.blog.utils.annotion.validator.group.GetList;
import lombok.Data;

/**
 *
 * @description:分页
 *  @author: 小章鱼
 * @date: 2021/8/26 23:14
 **/
@Data
public class Page<T> {
    /**
     * 关键字
     */
    private String keyword;

    /**
     * 当前页
     */
    @LongNotNull(groups = {GetList.class}, message = Messages.PAGE_NOT_NULL)
    private Long currentPage;

    /**
     * 页大小
     */
    @LongNotNull(groups = {GetList.class}, message = Messages.SIZE_NOT_NULL)
    private Long pageSize;
}
