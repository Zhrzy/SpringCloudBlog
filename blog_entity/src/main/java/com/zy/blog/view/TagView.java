package com.zy.blog.view;

import com.zy.blog.base.ViewBase;
import com.zy.blog.utils.annotion.validator.annotion.NotBlank;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import lombok.Data;

@Data
public class TagView extends ViewBase {
    /**
     * 标签内容
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String content;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * OrderBy排序字段（desc: 降序）
     */
    private String orderByDescColumn;

    /**
     * OrderBy排序字段（asc: 升序）
     */
    private String orderByAscColumn;

    /**
     * 无参构造方法，初始化默认值
     */
    TagView() {

    }
}