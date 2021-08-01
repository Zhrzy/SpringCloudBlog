package com.zy.blog.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidIsNull() {
            addCriterion("dict_type_uid is null");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidIsNotNull() {
            addCriterion("dict_type_uid is not null");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidEqualTo(String value) {
            addCriterion("dict_type_uid =", value, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidNotEqualTo(String value) {
            addCriterion("dict_type_uid <>", value, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidGreaterThan(String value) {
            addCriterion("dict_type_uid >", value, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidGreaterThanOrEqualTo(String value) {
            addCriterion("dict_type_uid >=", value, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidLessThan(String value) {
            addCriterion("dict_type_uid <", value, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidLessThanOrEqualTo(String value) {
            addCriterion("dict_type_uid <=", value, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidLike(String value) {
            addCriterion("dict_type_uid like", value, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidNotLike(String value) {
            addCriterion("dict_type_uid not like", value, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidIn(List<String> values) {
            addCriterion("dict_type_uid in", values, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidNotIn(List<String> values) {
            addCriterion("dict_type_uid not in", values, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidBetween(String value1, String value2) {
            addCriterion("dict_type_uid between", value1, value2, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictTypeUidNotBetween(String value1, String value2) {
            addCriterion("dict_type_uid not between", value1, value2, "dictTypeUid");
            return (Criteria) this;
        }

        public Criteria andDictLabelIsNull() {
            addCriterion("dict_label is null");
            return (Criteria) this;
        }

        public Criteria andDictLabelIsNotNull() {
            addCriterion("dict_label is not null");
            return (Criteria) this;
        }

        public Criteria andDictLabelEqualTo(String value) {
            addCriterion("dict_label =", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelNotEqualTo(String value) {
            addCriterion("dict_label <>", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelGreaterThan(String value) {
            addCriterion("dict_label >", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelGreaterThanOrEqualTo(String value) {
            addCriterion("dict_label >=", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelLessThan(String value) {
            addCriterion("dict_label <", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelLessThanOrEqualTo(String value) {
            addCriterion("dict_label <=", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelLike(String value) {
            addCriterion("dict_label like", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelNotLike(String value) {
            addCriterion("dict_label not like", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelIn(List<String> values) {
            addCriterion("dict_label in", values, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelNotIn(List<String> values) {
            addCriterion("dict_label not in", values, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelBetween(String value1, String value2) {
            addCriterion("dict_label between", value1, value2, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelNotBetween(String value1, String value2) {
            addCriterion("dict_label not between", value1, value2, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictValueIsNull() {
            addCriterion("dict_value is null");
            return (Criteria) this;
        }

        public Criteria andDictValueIsNotNull() {
            addCriterion("dict_value is not null");
            return (Criteria) this;
        }

        public Criteria andDictValueEqualTo(String value) {
            addCriterion("dict_value =", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotEqualTo(String value) {
            addCriterion("dict_value <>", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueGreaterThan(String value) {
            addCriterion("dict_value >", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueGreaterThanOrEqualTo(String value) {
            addCriterion("dict_value >=", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLessThan(String value) {
            addCriterion("dict_value <", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLessThanOrEqualTo(String value) {
            addCriterion("dict_value <=", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLike(String value) {
            addCriterion("dict_value like", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotLike(String value) {
            addCriterion("dict_value not like", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueIn(List<String> values) {
            addCriterion("dict_value in", values, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotIn(List<String> values) {
            addCriterion("dict_value not in", values, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueBetween(String value1, String value2) {
            addCriterion("dict_value between", value1, value2, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotBetween(String value1, String value2) {
            addCriterion("dict_value not between", value1, value2, "dictValue");
            return (Criteria) this;
        }

        public Criteria andCssClassIsNull() {
            addCriterion("css_class is null");
            return (Criteria) this;
        }

        public Criteria andCssClassIsNotNull() {
            addCriterion("css_class is not null");
            return (Criteria) this;
        }

        public Criteria andCssClassEqualTo(String value) {
            addCriterion("css_class =", value, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassNotEqualTo(String value) {
            addCriterion("css_class <>", value, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassGreaterThan(String value) {
            addCriterion("css_class >", value, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassGreaterThanOrEqualTo(String value) {
            addCriterion("css_class >=", value, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassLessThan(String value) {
            addCriterion("css_class <", value, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassLessThanOrEqualTo(String value) {
            addCriterion("css_class <=", value, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassLike(String value) {
            addCriterion("css_class like", value, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassNotLike(String value) {
            addCriterion("css_class not like", value, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassIn(List<String> values) {
            addCriterion("css_class in", values, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassNotIn(List<String> values) {
            addCriterion("css_class not in", values, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassBetween(String value1, String value2) {
            addCriterion("css_class between", value1, value2, "cssClass");
            return (Criteria) this;
        }

        public Criteria andCssClassNotBetween(String value1, String value2) {
            addCriterion("css_class not between", value1, value2, "cssClass");
            return (Criteria) this;
        }

        public Criteria andListClassIsNull() {
            addCriterion("list_class is null");
            return (Criteria) this;
        }

        public Criteria andListClassIsNotNull() {
            addCriterion("list_class is not null");
            return (Criteria) this;
        }

        public Criteria andListClassEqualTo(String value) {
            addCriterion("list_class =", value, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassNotEqualTo(String value) {
            addCriterion("list_class <>", value, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassGreaterThan(String value) {
            addCriterion("list_class >", value, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassGreaterThanOrEqualTo(String value) {
            addCriterion("list_class >=", value, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassLessThan(String value) {
            addCriterion("list_class <", value, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassLessThanOrEqualTo(String value) {
            addCriterion("list_class <=", value, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassLike(String value) {
            addCriterion("list_class like", value, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassNotLike(String value) {
            addCriterion("list_class not like", value, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassIn(List<String> values) {
            addCriterion("list_class in", values, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassNotIn(List<String> values) {
            addCriterion("list_class not in", values, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassBetween(String value1, String value2) {
            addCriterion("list_class between", value1, value2, "listClass");
            return (Criteria) this;
        }

        public Criteria andListClassNotBetween(String value1, String value2) {
            addCriterion("list_class not between", value1, value2, "listClass");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Boolean value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Boolean value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Boolean value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Boolean value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Boolean> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Boolean> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andCreateByUidIsNull() {
            addCriterion("create_by_uid is null");
            return (Criteria) this;
        }

        public Criteria andCreateByUidIsNotNull() {
            addCriterion("create_by_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByUidEqualTo(String value) {
            addCriterion("create_by_uid =", value, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidNotEqualTo(String value) {
            addCriterion("create_by_uid <>", value, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidGreaterThan(String value) {
            addCriterion("create_by_uid >", value, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidGreaterThanOrEqualTo(String value) {
            addCriterion("create_by_uid >=", value, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidLessThan(String value) {
            addCriterion("create_by_uid <", value, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidLessThanOrEqualTo(String value) {
            addCriterion("create_by_uid <=", value, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidLike(String value) {
            addCriterion("create_by_uid like", value, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidNotLike(String value) {
            addCriterion("create_by_uid not like", value, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidIn(List<String> values) {
            addCriterion("create_by_uid in", values, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidNotIn(List<String> values) {
            addCriterion("create_by_uid not in", values, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidBetween(String value1, String value2) {
            addCriterion("create_by_uid between", value1, value2, "createByUid");
            return (Criteria) this;
        }

        public Criteria andCreateByUidNotBetween(String value1, String value2) {
            addCriterion("create_by_uid not between", value1, value2, "createByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidIsNull() {
            addCriterion("update_by_uid is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidIsNotNull() {
            addCriterion("update_by_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidEqualTo(String value) {
            addCriterion("update_by_uid =", value, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidNotEqualTo(String value) {
            addCriterion("update_by_uid <>", value, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidGreaterThan(String value) {
            addCriterion("update_by_uid >", value, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidGreaterThanOrEqualTo(String value) {
            addCriterion("update_by_uid >=", value, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidLessThan(String value) {
            addCriterion("update_by_uid <", value, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidLessThanOrEqualTo(String value) {
            addCriterion("update_by_uid <=", value, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidLike(String value) {
            addCriterion("update_by_uid like", value, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidNotLike(String value) {
            addCriterion("update_by_uid not like", value, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidIn(List<String> values) {
            addCriterion("update_by_uid in", values, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidNotIn(List<String> values) {
            addCriterion("update_by_uid not in", values, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidBetween(String value1, String value2) {
            addCriterion("update_by_uid between", value1, value2, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andUpdateByUidNotBetween(String value1, String value2) {
            addCriterion("update_by_uid not between", value1, value2, "updateByUid");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsPublishIsNull() {
            addCriterion("is_publish is null");
            return (Criteria) this;
        }

        public Criteria andIsPublishIsNotNull() {
            addCriterion("is_publish is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublishEqualTo(String value) {
            addCriterion("is_publish =", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotEqualTo(String value) {
            addCriterion("is_publish <>", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThan(String value) {
            addCriterion("is_publish >", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThanOrEqualTo(String value) {
            addCriterion("is_publish >=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThan(String value) {
            addCriterion("is_publish <", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThanOrEqualTo(String value) {
            addCriterion("is_publish <=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLike(String value) {
            addCriterion("is_publish like", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotLike(String value) {
            addCriterion("is_publish not like", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishIn(List<String> values) {
            addCriterion("is_publish in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotIn(List<String> values) {
            addCriterion("is_publish not in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishBetween(String value1, String value2) {
            addCriterion("is_publish between", value1, value2, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotBetween(String value1, String value2) {
            addCriterion("is_publish not between", value1, value2, "isPublish");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}