package com.zy.blog.view;

import com.zy.blog.base.ViewBase;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * FileVO
 *
 * @author: 小章鱼
 * @create: 2019年12月31日15:19:31
 */
@Data
@ToString
public class FileView extends ViewBase<FileView> {
    /**
     * 如果是用户上传，则包含用户uid
     */
    private String userUid;

    /**
     * 如果是管理员上传，则包含管理员uid
     */
    private String adminUid;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 模块名
     */
    private String sortName;

    /**
     * 图片Url集合
     */
    private List<String> urlList;

    /**
     * 系统配置
     */
    private Map<String, String> systemConfig;

    /**
     * 上传图片时携带的token令牌
     */
    private String token;

}
