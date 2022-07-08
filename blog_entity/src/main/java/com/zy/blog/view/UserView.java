package com.zy.blog.view;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zy.blog.base.ViewBase;
import com.zy.blog.utils.annotion.validator.annotion.NotBlank;
import com.zy.blog.utils.annotion.validator.annotion.Range;
import com.zy.blog.utils.annotion.validator.group.GetOne;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class UserView extends ViewBase {
    /**
     * 用户名
     */
    @NotBlank(groups = {Insert.class, GetOne.class})
    @Range(groups = {Insert.class, Update.class}, min = 5, max = 30)
    private String userName;

    /**
     * 密码
     */
    @NotBlank(groups = {GetOne.class})
    private String passWord;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别(1:男2:女)
     */
    private String gender;

    /**
     * 个人头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    @NotBlank(groups = {Insert.class})
    private String email;

    /**
     * 出生年月日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 手机
     */
    private String mobile;

    /**
     * QQ号
     */
    private String qqNumber;

    /**
     * 微信号
     */
    private String weChat;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 自我简介最多150字
     */
    @Range(groups = {Insert.class, Update.class}, max = 200)
    private String summary;


    /**
     * 资料来源
     */
    private String source;

    /**
     * 平台uuid
     */
    private String uuid;

    /**
     * 评论状态，0 禁言， 1 正常
     */
    private Integer commentStatus;

    /**
     * 开启邮件通知：  0：关闭， 1：开启
     */
    private Integer startEmailNotification;

    /**
     * 用户标签  0：普通，1：管理员，2：博主
     */
    private Integer userTag;

    /**
     * 用户头像
     */
    @TableField(exist = false)
    private String photoUrl;

    /**
     * OrderBy排序字段（desc: 降序）
     */
    private String orderByDescColumn;

    /**
     * OrderBy排序字段（asc: 升序）
     */
    private String orderByAscColumn;
}