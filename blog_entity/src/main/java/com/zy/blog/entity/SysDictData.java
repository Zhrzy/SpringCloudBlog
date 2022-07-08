package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/9/28 16:13
 **/

@TableName("t_sys_dict_data")
public class SysDictData extends EntityBase<SysDictData> {
    private static final long serialVersionUID = 1L;
    /**
     * 自增键 oid
     */
    private Long oid;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 字典类型UID
     */
    private String dictTypeUid;

    /**
     * 样式属性（其他样式扩展）
     */
    private String cssClass;

    /**
     * 表格回显样式
     */
    private String listClass;

    /**
     * 是否默认（1是 0否）,默认为0
     */
    private Integer isDefault;

    /**
     * 是否发布  1：是，0:否，默认为0
     */
    private String isPublish;

    /**
     * 创建人UID
     */
    private String createByUid;

    /**
     * 最后更新人UID
     */
    private String updateByUid;

    /**
     * 备注
     */
    private String remark;

    // 以下字段不存入数据库，封装为了前端使用

    /**
     * 字典类型
     */
    @TableField(exist = false)
    private SysDictType sysDictType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDictTypeUid() {
        return dictTypeUid;
    }

    public void setDictTypeUid(String dictTypeUid) {
        this.dictTypeUid = dictTypeUid;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getListClass() {
        return listClass;
    }

    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public String getCreateByUid() {
        return createByUid;
    }

    public void setCreateByUid(String createByUid) {
        this.createByUid = createByUid;
    }

    public String getUpdateByUid() {
        return updateByUid;
    }

    public void setUpdateByUid(String updateByUid) {
        this.updateByUid = updateByUid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public SysDictType getSysDictType() {
        return sysDictType;
    }

    public void setSysDictType(SysDictType sysDictType) {
        this.sysDictType = sysDictType;
    }
}
