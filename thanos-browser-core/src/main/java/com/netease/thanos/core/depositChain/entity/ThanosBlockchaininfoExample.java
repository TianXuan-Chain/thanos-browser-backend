package com.netease.thanos.core.depositChain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * thanos_blockChainInfo表查询条件构建对象
 * 
 * @author db-generator
 * @since 2021年07月07日17:25:28
 */ 
public class ThanosBlockchaininfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public ThanosBlockchaininfoExample() {
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
     * thanos_blockChainInfo null
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

        public Criteria andLastBlockNumIsNull() {
            addCriterion("last_block_num is null");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumIsNotNull() {
            addCriterion("last_block_num is not null");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumEqualTo(Long value) {
            addCriterion("last_block_num =", value, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumNotEqualTo(Long value) {
            addCriterion("last_block_num <>", value, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumGreaterThan(Long value) {
            addCriterion("last_block_num >", value, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumGreaterThanOrEqualTo(Long value) {
            addCriterion("last_block_num >=", value, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumLessThan(Long value) {
            addCriterion("last_block_num <", value, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumLessThanOrEqualTo(Long value) {
            addCriterion("last_block_num <=", value, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumIn(List<Long> values) {
            addCriterion("last_block_num in", values, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumNotIn(List<Long> values) {
            addCriterion("last_block_num not in", values, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumBetween(Long value1, Long value2) {
            addCriterion("last_block_num between", value1, value2, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andLastBlockNumNotBetween(Long value1, Long value2) {
            addCriterion("last_block_num not between", value1, value2, "lastBlockNum");
            return (Criteria) this;
        }

        public Criteria andTxnCountIsNull() {
            addCriterion("txn_count is null");
            return (Criteria) this;
        }

        public Criteria andTxnCountIsNotNull() {
            addCriterion("txn_count is not null");
            return (Criteria) this;
        }

        public Criteria andTxnCountEqualTo(Long value) {
            addCriterion("txn_count =", value, "txnCount");
            return (Criteria) this;
        }

        public Criteria andTxnCountNotEqualTo(Long value) {
            addCriterion("txn_count <>", value, "txnCount");
            return (Criteria) this;
        }

        public Criteria andTxnCountGreaterThan(Long value) {
            addCriterion("txn_count >", value, "txnCount");
            return (Criteria) this;
        }

        public Criteria andTxnCountGreaterThanOrEqualTo(Long value) {
            addCriterion("txn_count >=", value, "txnCount");
            return (Criteria) this;
        }

        public Criteria andTxnCountLessThan(Long value) {
            addCriterion("txn_count <", value, "txnCount");
            return (Criteria) this;
        }

        public Criteria andTxnCountLessThanOrEqualTo(Long value) {
            addCriterion("txn_count <=", value, "txnCount");
            return (Criteria) this;
        }

        public Criteria andTxnCountIn(List<Long> values) {
            addCriterion("txn_count in", values, "txnCount");
            return (Criteria) this;
        }

        public Criteria andTxnCountNotIn(List<Long> values) {
            addCriterion("txn_count not in", values, "txnCount");
            return (Criteria) this;
        }

        public Criteria andTxnCountBetween(Long value1, Long value2) {
            addCriterion("txn_count between", value1, value2, "txnCount");
            return (Criteria) this;
        }

        public Criteria andTxnCountNotBetween(Long value1, Long value2) {
            addCriterion("txn_count not between", value1, value2, "txnCount");
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

        public Criteria andRoundIsNull() {
            addCriterion("round is null");
            return (Criteria) this;
        }

        public Criteria andRoundIsNotNull() {
            addCriterion("round is not null");
            return (Criteria) this;
        }

        public Criteria andRoundEqualTo(Long value) {
            addCriterion("round =", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotEqualTo(Long value) {
            addCriterion("round <>", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThan(Long value) {
            addCriterion("round >", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThanOrEqualTo(Long value) {
            addCriterion("round >=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThan(Long value) {
            addCriterion("round <", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThanOrEqualTo(Long value) {
            addCriterion("round <=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundIn(List<Long> values) {
            addCriterion("round in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotIn(List<Long> values) {
            addCriterion("round not in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundBetween(Long value1, Long value2) {
            addCriterion("round between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotBetween(Long value1, Long value2) {
            addCriterion("round not between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andAvgTimeIsNull() {
            addCriterion("avg_time is null");
            return (Criteria) this;
        }

        public Criteria andAvgTimeIsNotNull() {
            addCriterion("avg_time is not null");
            return (Criteria) this;
        }

        public Criteria andAvgTimeEqualTo(BigDecimal value) {
            addCriterion("avg_time =", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeNotEqualTo(BigDecimal value) {
            addCriterion("avg_time <>", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeGreaterThan(BigDecimal value) {
            addCriterion("avg_time >", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_time >=", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeLessThan(BigDecimal value) {
            addCriterion("avg_time <", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_time <=", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeIn(List<BigDecimal> values) {
            addCriterion("avg_time in", values, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeNotIn(List<BigDecimal> values) {
            addCriterion("avg_time not in", values, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_time between", value1, value2, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_time not between", value1, value2, "avgTime");
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
     * thanos_blockChainInfo null
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