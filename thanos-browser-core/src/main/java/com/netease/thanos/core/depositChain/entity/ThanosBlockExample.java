package com.netease.thanos.core.depositChain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * thanos_block表查询条件构建对象
 * 
 * @author db-generator
 * @since 2021年07月07日17:25:28
 */ 
public class ThanosBlockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public ThanosBlockExample() {
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
        rows = null;
        offset = null;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getRows() {
        return rows;
    }

    public void withLimit(int offset, int rows) {
        this.offset = offset;
        this.rows = rows;
    }

    public void withLimit(int rows) {
        this.rows = rows;
    }

    /**
     * thanos_block null
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPkHashIsNull() {
            addCriterion("pk_hash is null");
            return (Criteria) this;
        }

        public Criteria andPkHashIsNotNull() {
            addCriterion("pk_hash is not null");
            return (Criteria) this;
        }

        public Criteria andPkHashEqualTo(String value) {
            addCriterion("pk_hash =", value, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashNotEqualTo(String value) {
            addCriterion("pk_hash <>", value, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashGreaterThan(String value) {
            addCriterion("pk_hash >", value, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashGreaterThanOrEqualTo(String value) {
            addCriterion("pk_hash >=", value, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashLessThan(String value) {
            addCriterion("pk_hash <", value, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashLessThanOrEqualTo(String value) {
            addCriterion("pk_hash <=", value, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashLike(String value) {
            addCriterion("pk_hash like", value, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashNotLike(String value) {
            addCriterion("pk_hash not like", value, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashIn(List<String> values) {
            addCriterion("pk_hash in", values, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashNotIn(List<String> values) {
            addCriterion("pk_hash not in", values, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashBetween(String value1, String value2) {
            addCriterion("pk_hash between", value1, value2, "pkHash");
            return (Criteria) this;
        }

        public Criteria andPkHashNotBetween(String value1, String value2) {
            addCriterion("pk_hash not between", value1, value2, "pkHash");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Long value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Long value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Long value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Long value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Long value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Long> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Long> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Long value1, Long value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Long value1, Long value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNull() {
            addCriterion("event_id is null");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNotNull() {
            addCriterion("event_id is not null");
            return (Criteria) this;
        }

        public Criteria andEventIdEqualTo(String value) {
            addCriterion("event_id =", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotEqualTo(String value) {
            addCriterion("event_id <>", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThan(String value) {
            addCriterion("event_id >", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThanOrEqualTo(String value) {
            addCriterion("event_id >=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThan(String value) {
            addCriterion("event_id <", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThanOrEqualTo(String value) {
            addCriterion("event_id <=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLike(String value) {
            addCriterion("event_id like", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotLike(String value) {
            addCriterion("event_id not like", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdIn(List<String> values) {
            addCriterion("event_id in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotIn(List<String> values) {
            addCriterion("event_id not in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdBetween(String value1, String value2) {
            addCriterion("event_id between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotBetween(String value1, String value2) {
            addCriterion("event_id not between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdIsNull() {
            addCriterion("pre_event_id is null");
            return (Criteria) this;
        }

        public Criteria andPreEventIdIsNotNull() {
            addCriterion("pre_event_id is not null");
            return (Criteria) this;
        }

        public Criteria andPreEventIdEqualTo(String value) {
            addCriterion("pre_event_id =", value, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdNotEqualTo(String value) {
            addCriterion("pre_event_id <>", value, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdGreaterThan(String value) {
            addCriterion("pre_event_id >", value, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdGreaterThanOrEqualTo(String value) {
            addCriterion("pre_event_id >=", value, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdLessThan(String value) {
            addCriterion("pre_event_id <", value, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdLessThanOrEqualTo(String value) {
            addCriterion("pre_event_id <=", value, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdLike(String value) {
            addCriterion("pre_event_id like", value, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdNotLike(String value) {
            addCriterion("pre_event_id not like", value, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdIn(List<String> values) {
            addCriterion("pre_event_id in", values, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdNotIn(List<String> values) {
            addCriterion("pre_event_id not in", values, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdBetween(String value1, String value2) {
            addCriterion("pre_event_id between", value1, value2, "preEventId");
            return (Criteria) this;
        }

        public Criteria andPreEventIdNotBetween(String value1, String value2) {
            addCriterion("pre_event_id not between", value1, value2, "preEventId");
            return (Criteria) this;
        }

        public Criteria andEpochIsNull() {
            addCriterion("epoch is null");
            return (Criteria) this;
        }

        public Criteria andEpochIsNotNull() {
            addCriterion("epoch is not null");
            return (Criteria) this;
        }

        public Criteria andEpochEqualTo(Long value) {
            addCriterion("epoch =", value, "epoch");
            return (Criteria) this;
        }

        public Criteria andEpochNotEqualTo(Long value) {
            addCriterion("epoch <>", value, "epoch");
            return (Criteria) this;
        }

        public Criteria andEpochGreaterThan(Long value) {
            addCriterion("epoch >", value, "epoch");
            return (Criteria) this;
        }

        public Criteria andEpochGreaterThanOrEqualTo(Long value) {
            addCriterion("epoch >=", value, "epoch");
            return (Criteria) this;
        }

        public Criteria andEpochLessThan(Long value) {
            addCriterion("epoch <", value, "epoch");
            return (Criteria) this;
        }

        public Criteria andEpochLessThanOrEqualTo(Long value) {
            addCriterion("epoch <=", value, "epoch");
            return (Criteria) this;
        }

        public Criteria andEpochIn(List<Long> values) {
            addCriterion("epoch in", values, "epoch");
            return (Criteria) this;
        }

        public Criteria andEpochNotIn(List<Long> values) {
            addCriterion("epoch not in", values, "epoch");
            return (Criteria) this;
        }

        public Criteria andEpochBetween(Long value1, Long value2) {
            addCriterion("epoch between", value1, value2, "epoch");
            return (Criteria) this;
        }

        public Criteria andEpochNotBetween(Long value1, Long value2) {
            addCriterion("epoch not between", value1, value2, "epoch");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Date value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Date value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Date value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Date value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Date value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Date> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Date> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Date value1, Date value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Date value1, Date value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumIsNull() {
            addCriterion("evm_tnx_num is null");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumIsNotNull() {
            addCriterion("evm_tnx_num is not null");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumEqualTo(Long value) {
            addCriterion("evm_tnx_num =", value, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumNotEqualTo(Long value) {
            addCriterion("evm_tnx_num <>", value, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumGreaterThan(Long value) {
            addCriterion("evm_tnx_num >", value, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumGreaterThanOrEqualTo(Long value) {
            addCriterion("evm_tnx_num >=", value, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumLessThan(Long value) {
            addCriterion("evm_tnx_num <", value, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumLessThanOrEqualTo(Long value) {
            addCriterion("evm_tnx_num <=", value, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumIn(List<Long> values) {
            addCriterion("evm_tnx_num in", values, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumNotIn(List<Long> values) {
            addCriterion("evm_tnx_num not in", values, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumBetween(Long value1, Long value2) {
            addCriterion("evm_tnx_num between", value1, value2, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andEvmTnxNumNotBetween(Long value1, Long value2) {
            addCriterion("evm_tnx_num not between", value1, value2, "evmTnxNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumIsNull() {
            addCriterion("global_event_num is null");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumIsNotNull() {
            addCriterion("global_event_num is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumEqualTo(Long value) {
            addCriterion("global_event_num =", value, "globalEventNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumNotEqualTo(Long value) {
            addCriterion("global_event_num <>", value, "globalEventNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumGreaterThan(Long value) {
            addCriterion("global_event_num >", value, "globalEventNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumGreaterThanOrEqualTo(Long value) {
            addCriterion("global_event_num >=", value, "globalEventNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumLessThan(Long value) {
            addCriterion("global_event_num <", value, "globalEventNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumLessThanOrEqualTo(Long value) {
            addCriterion("global_event_num <=", value, "globalEventNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumIn(List<Long> values) {
            addCriterion("global_event_num in", values, "globalEventNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumNotIn(List<Long> values) {
            addCriterion("global_event_num not in", values, "globalEventNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumBetween(Long value1, Long value2) {
            addCriterion("global_event_num between", value1, value2, "globalEventNum");
            return (Criteria) this;
        }

        public Criteria andGlobalEventNumNotBetween(Long value1, Long value2) {
            addCriterion("global_event_num not between", value1, value2, "globalEventNum");
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * thanos_block null
     */
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