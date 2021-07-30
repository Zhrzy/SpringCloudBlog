package com.zy.blog.view;

import com.zy.blog.base.ViewBase;

public class DictView extends ViewBase {
    private Integer oid;

    private String dictTypeUid;

    private String dictLabel;

    private String dictValue;

    private String cssClass;

    private String listClass;

    private Boolean isDefault;

    private String createByUid;

    private String updateByUid;

    private String remark;

    private String isPublish;

    private Integer sort;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getDictTypeUid() {
        return dictTypeUid;
    }

    public void setDictTypeUid(String dictTypeUid) {
        this.dictTypeUid = dictTypeUid == null ? null : dictTypeUid.trim();
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel == null ? null : dictLabel.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass == null ? null : cssClass.trim();
    }

    public String getListClass() {
        return listClass;
    }

    public void setListClass(String listClass) {
        this.listClass = listClass == null ? null : listClass.trim();
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getCreateByUid() {
        return createByUid;
    }

    public void setCreateByUid(String createByUid) {
        this.createByUid = createByUid == null ? null : createByUid.trim();
    }

    public String getUpdateByUid() {
        return updateByUid;
    }

    public void setUpdateByUid(String updateByUid) {
        this.updateByUid = updateByUid == null ? null : updateByUid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish == null ? null : isPublish.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}