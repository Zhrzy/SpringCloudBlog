package com.zy.blog.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudyVideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudyVideoExample() {
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

        public Criteria andFileUidIsNull() {
            addCriterion("file_uid is null");
            return (Criteria) this;
        }

        public Criteria andFileUidIsNotNull() {
            addCriterion("file_uid is not null");
            return (Criteria) this;
        }

        public Criteria andFileUidEqualTo(String value) {
            addCriterion("file_uid =", value, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidNotEqualTo(String value) {
            addCriterion("file_uid <>", value, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidGreaterThan(String value) {
            addCriterion("file_uid >", value, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidGreaterThanOrEqualTo(String value) {
            addCriterion("file_uid >=", value, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidLessThan(String value) {
            addCriterion("file_uid <", value, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidLessThanOrEqualTo(String value) {
            addCriterion("file_uid <=", value, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidLike(String value) {
            addCriterion("file_uid like", value, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidNotLike(String value) {
            addCriterion("file_uid not like", value, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidIn(List<String> values) {
            addCriterion("file_uid in", values, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidNotIn(List<String> values) {
            addCriterion("file_uid not in", values, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidBetween(String value1, String value2) {
            addCriterion("file_uid between", value1, value2, "fileUid");
            return (Criteria) this;
        }

        public Criteria andFileUidNotBetween(String value1, String value2) {
            addCriterion("file_uid not between", value1, value2, "fileUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidIsNull() {
            addCriterion("resource_sort_uid is null");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidIsNotNull() {
            addCriterion("resource_sort_uid is not null");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidEqualTo(String value) {
            addCriterion("resource_sort_uid =", value, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidNotEqualTo(String value) {
            addCriterion("resource_sort_uid <>", value, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidGreaterThan(String value) {
            addCriterion("resource_sort_uid >", value, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidGreaterThanOrEqualTo(String value) {
            addCriterion("resource_sort_uid >=", value, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidLessThan(String value) {
            addCriterion("resource_sort_uid <", value, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidLessThanOrEqualTo(String value) {
            addCriterion("resource_sort_uid <=", value, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidLike(String value) {
            addCriterion("resource_sort_uid like", value, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidNotLike(String value) {
            addCriterion("resource_sort_uid not like", value, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidIn(List<String> values) {
            addCriterion("resource_sort_uid in", values, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidNotIn(List<String> values) {
            addCriterion("resource_sort_uid not in", values, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidBetween(String value1, String value2) {
            addCriterion("resource_sort_uid between", value1, value2, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andResourceSortUidNotBetween(String value1, String value2) {
            addCriterion("resource_sort_uid not between", value1, value2, "resourceSortUid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andBaiduPathIsNull() {
            addCriterion("baidu_path is null");
            return (Criteria) this;
        }

        public Criteria andBaiduPathIsNotNull() {
            addCriterion("baidu_path is not null");
            return (Criteria) this;
        }

        public Criteria andBaiduPathEqualTo(String value) {
            addCriterion("baidu_path =", value, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathNotEqualTo(String value) {
            addCriterion("baidu_path <>", value, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathGreaterThan(String value) {
            addCriterion("baidu_path >", value, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathGreaterThanOrEqualTo(String value) {
            addCriterion("baidu_path >=", value, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathLessThan(String value) {
            addCriterion("baidu_path <", value, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathLessThanOrEqualTo(String value) {
            addCriterion("baidu_path <=", value, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathLike(String value) {
            addCriterion("baidu_path like", value, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathNotLike(String value) {
            addCriterion("baidu_path not like", value, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathIn(List<String> values) {
            addCriterion("baidu_path in", values, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathNotIn(List<String> values) {
            addCriterion("baidu_path not in", values, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathBetween(String value1, String value2) {
            addCriterion("baidu_path between", value1, value2, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andBaiduPathNotBetween(String value1, String value2) {
            addCriterion("baidu_path not between", value1, value2, "baiduPath");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNull() {
            addCriterion("click_count is null");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNotNull() {
            addCriterion("click_count is not null");
            return (Criteria) this;
        }

        public Criteria andClickCountEqualTo(String value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(String value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(String value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(String value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(String value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(String value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLike(String value) {
            addCriterion("click_count like", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotLike(String value) {
            addCriterion("click_count not like", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<String> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<String> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(String value1, String value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(String value1, String value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
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

        public Criteria andParentUidIsNull() {
            addCriterion("parent_uid is null");
            return (Criteria) this;
        }

        public Criteria andParentUidIsNotNull() {
            addCriterion("parent_uid is not null");
            return (Criteria) this;
        }

        public Criteria andParentUidEqualTo(String value) {
            addCriterion("parent_uid =", value, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidNotEqualTo(String value) {
            addCriterion("parent_uid <>", value, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidGreaterThan(String value) {
            addCriterion("parent_uid >", value, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidGreaterThanOrEqualTo(String value) {
            addCriterion("parent_uid >=", value, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidLessThan(String value) {
            addCriterion("parent_uid <", value, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidLessThanOrEqualTo(String value) {
            addCriterion("parent_uid <=", value, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidLike(String value) {
            addCriterion("parent_uid like", value, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidNotLike(String value) {
            addCriterion("parent_uid not like", value, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidIn(List<String> values) {
            addCriterion("parent_uid in", values, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidNotIn(List<String> values) {
            addCriterion("parent_uid not in", values, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidBetween(String value1, String value2) {
            addCriterion("parent_uid between", value1, value2, "parentUid");
            return (Criteria) this;
        }

        public Criteria andParentUidNotBetween(String value1, String value2) {
            addCriterion("parent_uid not between", value1, value2, "parentUid");
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