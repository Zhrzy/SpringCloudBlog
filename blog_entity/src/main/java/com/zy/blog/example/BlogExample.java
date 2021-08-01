package com.zy.blog.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andTagUidIsNull() {
            addCriterion("tag_uid is null");
            return (Criteria) this;
        }

        public Criteria andTagUidIsNotNull() {
            addCriterion("tag_uid is not null");
            return (Criteria) this;
        }

        public Criteria andTagUidEqualTo(String value) {
            addCriterion("tag_uid =", value, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidNotEqualTo(String value) {
            addCriterion("tag_uid <>", value, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidGreaterThan(String value) {
            addCriterion("tag_uid >", value, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidGreaterThanOrEqualTo(String value) {
            addCriterion("tag_uid >=", value, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidLessThan(String value) {
            addCriterion("tag_uid <", value, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidLessThanOrEqualTo(String value) {
            addCriterion("tag_uid <=", value, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidLike(String value) {
            addCriterion("tag_uid like", value, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidNotLike(String value) {
            addCriterion("tag_uid not like", value, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidIn(List<String> values) {
            addCriterion("tag_uid in", values, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidNotIn(List<String> values) {
            addCriterion("tag_uid not in", values, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidBetween(String value1, String value2) {
            addCriterion("tag_uid between", value1, value2, "tagUid");
            return (Criteria) this;
        }

        public Criteria andTagUidNotBetween(String value1, String value2) {
            addCriterion("tag_uid not between", value1, value2, "tagUid");
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

        public Criteria andClickCountEqualTo(Integer value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(Integer value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(Integer value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(Integer value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<Integer> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<Integer> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(Integer value1, Integer value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNull() {
            addCriterion("collect_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNotNull() {
            addCriterion("collect_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectCountEqualTo(Integer value) {
            addCriterion("collect_count =", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotEqualTo(Integer value) {
            addCriterion("collect_count <>", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThan(Integer value) {
            addCriterion("collect_count >", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_count >=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThan(Integer value) {
            addCriterion("collect_count <", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThanOrEqualTo(Integer value) {
            addCriterion("collect_count <=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountIn(List<Integer> values) {
            addCriterion("collect_count in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotIn(List<Integer> values) {
            addCriterion("collect_count not in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountBetween(Integer value1, Integer value2) {
            addCriterion("collect_count between", value1, value2, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_count not between", value1, value2, "collectCount");
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

        public Criteria andAdminUidIsNull() {
            addCriterion("admin_uid is null");
            return (Criteria) this;
        }

        public Criteria andAdminUidIsNotNull() {
            addCriterion("admin_uid is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUidEqualTo(String value) {
            addCriterion("admin_uid =", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidNotEqualTo(String value) {
            addCriterion("admin_uid <>", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidGreaterThan(String value) {
            addCriterion("admin_uid >", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidGreaterThanOrEqualTo(String value) {
            addCriterion("admin_uid >=", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidLessThan(String value) {
            addCriterion("admin_uid <", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidLessThanOrEqualTo(String value) {
            addCriterion("admin_uid <=", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidLike(String value) {
            addCriterion("admin_uid like", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidNotLike(String value) {
            addCriterion("admin_uid not like", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidIn(List<String> values) {
            addCriterion("admin_uid in", values, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidNotIn(List<String> values) {
            addCriterion("admin_uid not in", values, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidBetween(String value1, String value2) {
            addCriterion("admin_uid between", value1, value2, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidNotBetween(String value1, String value2) {
            addCriterion("admin_uid not between", value1, value2, "adminUid");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIsNull() {
            addCriterion("is_original is null");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIsNotNull() {
            addCriterion("is_original is not null");
            return (Criteria) this;
        }

        public Criteria andIsOriginalEqualTo(String value) {
            addCriterion("is_original =", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotEqualTo(String value) {
            addCriterion("is_original <>", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalGreaterThan(String value) {
            addCriterion("is_original >", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalGreaterThanOrEqualTo(String value) {
            addCriterion("is_original >=", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalLessThan(String value) {
            addCriterion("is_original <", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalLessThanOrEqualTo(String value) {
            addCriterion("is_original <=", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalLike(String value) {
            addCriterion("is_original like", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotLike(String value) {
            addCriterion("is_original not like", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIn(List<String> values) {
            addCriterion("is_original in", values, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotIn(List<String> values) {
            addCriterion("is_original not in", values, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalBetween(String value1, String value2) {
            addCriterion("is_original between", value1, value2, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotBetween(String value1, String value2) {
            addCriterion("is_original not between", value1, value2, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andArticlesPartIsNull() {
            addCriterion("articles_part is null");
            return (Criteria) this;
        }

        public Criteria andArticlesPartIsNotNull() {
            addCriterion("articles_part is not null");
            return (Criteria) this;
        }

        public Criteria andArticlesPartEqualTo(String value) {
            addCriterion("articles_part =", value, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartNotEqualTo(String value) {
            addCriterion("articles_part <>", value, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartGreaterThan(String value) {
            addCriterion("articles_part >", value, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartGreaterThanOrEqualTo(String value) {
            addCriterion("articles_part >=", value, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartLessThan(String value) {
            addCriterion("articles_part <", value, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartLessThanOrEqualTo(String value) {
            addCriterion("articles_part <=", value, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartLike(String value) {
            addCriterion("articles_part like", value, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartNotLike(String value) {
            addCriterion("articles_part not like", value, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartIn(List<String> values) {
            addCriterion("articles_part in", values, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartNotIn(List<String> values) {
            addCriterion("articles_part not in", values, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartBetween(String value1, String value2) {
            addCriterion("articles_part between", value1, value2, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andArticlesPartNotBetween(String value1, String value2) {
            addCriterion("articles_part not between", value1, value2, "articlesPart");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidIsNull() {
            addCriterion("blog_sort_uid is null");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidIsNotNull() {
            addCriterion("blog_sort_uid is not null");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidEqualTo(String value) {
            addCriterion("blog_sort_uid =", value, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidNotEqualTo(String value) {
            addCriterion("blog_sort_uid <>", value, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidGreaterThan(String value) {
            addCriterion("blog_sort_uid >", value, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidGreaterThanOrEqualTo(String value) {
            addCriterion("blog_sort_uid >=", value, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidLessThan(String value) {
            addCriterion("blog_sort_uid <", value, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidLessThanOrEqualTo(String value) {
            addCriterion("blog_sort_uid <=", value, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidLike(String value) {
            addCriterion("blog_sort_uid like", value, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidNotLike(String value) {
            addCriterion("blog_sort_uid not like", value, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidIn(List<String> values) {
            addCriterion("blog_sort_uid in", values, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidNotIn(List<String> values) {
            addCriterion("blog_sort_uid not in", values, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidBetween(String value1, String value2) {
            addCriterion("blog_sort_uid between", value1, value2, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andBlogSortUidNotBetween(String value1, String value2) {
            addCriterion("blog_sort_uid not between", value1, value2, "blogSortUid");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Boolean value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Boolean value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Boolean value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Boolean value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Boolean value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Boolean> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Boolean> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Boolean value1, Boolean value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("level not between", value1, value2, "level");
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