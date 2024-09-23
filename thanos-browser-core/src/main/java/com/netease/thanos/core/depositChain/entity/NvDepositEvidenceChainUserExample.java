package com.netease.thanos.core.depositChain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * nv_deposit_evidence_chain_user表查询条件构建对象
 * 
 * @author db-generator
 * @since 2020年12月23日15:59:18
 */ 
public class NvDepositEvidenceChainUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public NvDepositEvidenceChainUserExample() {
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
     * nv_deposit_evidence_chain_user null
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

        public Criteria andEvidenceChainIdIsNull() {
            addCriterion("evidence_chain_id is null");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdIsNotNull() {
            addCriterion("evidence_chain_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdEqualTo(Long value) {
            addCriterion("evidence_chain_id =", value, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdNotEqualTo(Long value) {
            addCriterion("evidence_chain_id <>", value, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdGreaterThan(Long value) {
            addCriterion("evidence_chain_id >", value, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdGreaterThanOrEqualTo(Long value) {
            addCriterion("evidence_chain_id >=", value, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdLessThan(Long value) {
            addCriterion("evidence_chain_id <", value, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdLessThanOrEqualTo(Long value) {
            addCriterion("evidence_chain_id <=", value, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdIn(List<Long> values) {
            addCriterion("evidence_chain_id in", values, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdNotIn(List<Long> values) {
            addCriterion("evidence_chain_id not in", values, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdBetween(Long value1, Long value2) {
            addCriterion("evidence_chain_id between", value1, value2, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andEvidenceChainIdNotBetween(Long value1, Long value2) {
            addCriterion("evidence_chain_id not between", value1, value2, "evidenceChainId");
            return (Criteria) this;
        }

        public Criteria andRelateUserIsNull() {
            addCriterion("relate_user is null");
            return (Criteria) this;
        }

        public Criteria andRelateUserIsNotNull() {
            addCriterion("relate_user is not null");
            return (Criteria) this;
        }

        public Criteria andRelateUserEqualTo(String value) {
            addCriterion("relate_user =", value, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserNotEqualTo(String value) {
            addCriterion("relate_user <>", value, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserGreaterThan(String value) {
            addCriterion("relate_user >", value, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserGreaterThanOrEqualTo(String value) {
            addCriterion("relate_user >=", value, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserLessThan(String value) {
            addCriterion("relate_user <", value, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserLessThanOrEqualTo(String value) {
            addCriterion("relate_user <=", value, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserLike(String value) {
            addCriterion("relate_user like", value, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserNotLike(String value) {
            addCriterion("relate_user not like", value, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserIn(List<String> values) {
            addCriterion("relate_user in", values, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserNotIn(List<String> values) {
            addCriterion("relate_user not in", values, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserBetween(String value1, String value2) {
            addCriterion("relate_user between", value1, value2, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserNotBetween(String value1, String value2) {
            addCriterion("relate_user not between", value1, value2, "relateUser");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressIsNull() {
            addCriterion("relate_user_address is null");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressIsNotNull() {
            addCriterion("relate_user_address is not null");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressEqualTo(String value) {
            addCriterion("relate_user_address =", value, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressNotEqualTo(String value) {
            addCriterion("relate_user_address <>", value, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressGreaterThan(String value) {
            addCriterion("relate_user_address >", value, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("relate_user_address >=", value, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressLessThan(String value) {
            addCriterion("relate_user_address <", value, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressLessThanOrEqualTo(String value) {
            addCriterion("relate_user_address <=", value, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressLike(String value) {
            addCriterion("relate_user_address like", value, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressNotLike(String value) {
            addCriterion("relate_user_address not like", value, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressIn(List<String> values) {
            addCriterion("relate_user_address in", values, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressNotIn(List<String> values) {
            addCriterion("relate_user_address not in", values, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressBetween(String value1, String value2) {
            addCriterion("relate_user_address between", value1, value2, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserAddressNotBetween(String value1, String value2) {
            addCriterion("relate_user_address not between", value1, value2, "relateUserAddress");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationIsNull() {
            addCriterion("relate_corporation is null");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationIsNotNull() {
            addCriterion("relate_corporation is not null");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationEqualTo(String value) {
            addCriterion("relate_corporation =", value, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationNotEqualTo(String value) {
            addCriterion("relate_corporation <>", value, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationGreaterThan(String value) {
            addCriterion("relate_corporation >", value, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationGreaterThanOrEqualTo(String value) {
            addCriterion("relate_corporation >=", value, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationLessThan(String value) {
            addCriterion("relate_corporation <", value, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationLessThanOrEqualTo(String value) {
            addCriterion("relate_corporation <=", value, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationLike(String value) {
            addCriterion("relate_corporation like", value, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationNotLike(String value) {
            addCriterion("relate_corporation not like", value, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationIn(List<String> values) {
            addCriterion("relate_corporation in", values, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationNotIn(List<String> values) {
            addCriterion("relate_corporation not in", values, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationBetween(String value1, String value2) {
            addCriterion("relate_corporation between", value1, value2, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationNotBetween(String value1, String value2) {
            addCriterion("relate_corporation not between", value1, value2, "relateCorporation");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyIsNull() {
            addCriterion("partition_key is null");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyIsNotNull() {
            addCriterion("partition_key is not null");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyEqualTo(Integer value) {
            addCriterion("partition_key =", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyNotEqualTo(Integer value) {
            addCriterion("partition_key <>", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyGreaterThan(Integer value) {
            addCriterion("partition_key >", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("partition_key >=", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyLessThan(Integer value) {
            addCriterion("partition_key <", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyLessThanOrEqualTo(Integer value) {
            addCriterion("partition_key <=", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyIn(List<Integer> values) {
            addCriterion("partition_key in", values, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyNotIn(List<Integer> values) {
            addCriterion("partition_key not in", values, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyBetween(Integer value1, Integer value2) {
            addCriterion("partition_key between", value1, value2, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("partition_key not between", value1, value2, "partitionKey");
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

        public Criteria andBusinessTimeIsNull() {
            addCriterion("business_time is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIsNotNull() {
            addCriterion("business_time is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEqualTo(Date value) {
            addCriterion("business_time =", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotEqualTo(Date value) {
            addCriterion("business_time <>", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeGreaterThan(Date value) {
            addCriterion("business_time >", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("business_time >=", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLessThan(Date value) {
            addCriterion("business_time <", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLessThanOrEqualTo(Date value) {
            addCriterion("business_time <=", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIn(List<Date> values) {
            addCriterion("business_time in", values, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotIn(List<Date> values) {
            addCriterion("business_time not in", values, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeBetween(Date value1, Date value2) {
            addCriterion("business_time between", value1, value2, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotBetween(Date value1, Date value2) {
            addCriterion("business_time not between", value1, value2, "businessTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nv_deposit_evidence_chain_user null
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