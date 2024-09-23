package com.netease.thanos.core.depositChain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * nv_deposit_contract_ec_define表查询条件构建对象
 * 
 * @author db-generator
 * @since 2020年12月08日11:29:36
 */ 
public class NvDepositContractEcDefineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public NvDepositContractEcDefineExample() {
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
     * nv_deposit_contract_ec_define null
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

        public Criteria andContractAddressIsNull() {
            addCriterion("contract_address is null");
            return (Criteria) this;
        }

        public Criteria andContractAddressIsNotNull() {
            addCriterion("contract_address is not null");
            return (Criteria) this;
        }

        public Criteria andContractAddressEqualTo(String value) {
            addCriterion("contract_address =", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotEqualTo(String value) {
            addCriterion("contract_address <>", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressGreaterThan(String value) {
            addCriterion("contract_address >", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressGreaterThanOrEqualTo(String value) {
            addCriterion("contract_address >=", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressLessThan(String value) {
            addCriterion("contract_address <", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressLessThanOrEqualTo(String value) {
            addCriterion("contract_address <=", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressLike(String value) {
            addCriterion("contract_address like", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotLike(String value) {
            addCriterion("contract_address not like", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressIn(List<String> values) {
            addCriterion("contract_address in", values, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotIn(List<String> values) {
            addCriterion("contract_address not in", values, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressBetween(String value1, String value2) {
            addCriterion("contract_address between", value1, value2, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotBetween(String value1, String value2) {
            addCriterion("contract_address not between", value1, value2, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListIsNull() {
            addCriterion("relate_user_func_list is null");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListIsNotNull() {
            addCriterion("relate_user_func_list is not null");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListEqualTo(String value) {
            addCriterion("relate_user_func_list =", value, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListNotEqualTo(String value) {
            addCriterion("relate_user_func_list <>", value, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListGreaterThan(String value) {
            addCriterion("relate_user_func_list >", value, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListGreaterThanOrEqualTo(String value) {
            addCriterion("relate_user_func_list >=", value, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListLessThan(String value) {
            addCriterion("relate_user_func_list <", value, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListLessThanOrEqualTo(String value) {
            addCriterion("relate_user_func_list <=", value, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListLike(String value) {
            addCriterion("relate_user_func_list like", value, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListNotLike(String value) {
            addCriterion("relate_user_func_list not like", value, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListIn(List<String> values) {
            addCriterion("relate_user_func_list in", values, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListNotIn(List<String> values) {
            addCriterion("relate_user_func_list not in", values, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListBetween(String value1, String value2) {
            addCriterion("relate_user_func_list between", value1, value2, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateUserFuncListNotBetween(String value1, String value2) {
            addCriterion("relate_user_func_list not between", value1, value2, "relateUserFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListIsNull() {
            addCriterion("relate_object_func_list is null");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListIsNotNull() {
            addCriterion("relate_object_func_list is not null");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListEqualTo(String value) {
            addCriterion("relate_object_func_list =", value, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListNotEqualTo(String value) {
            addCriterion("relate_object_func_list <>", value, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListGreaterThan(String value) {
            addCriterion("relate_object_func_list >", value, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListGreaterThanOrEqualTo(String value) {
            addCriterion("relate_object_func_list >=", value, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListLessThan(String value) {
            addCriterion("relate_object_func_list <", value, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListLessThanOrEqualTo(String value) {
            addCriterion("relate_object_func_list <=", value, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListLike(String value) {
            addCriterion("relate_object_func_list like", value, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListNotLike(String value) {
            addCriterion("relate_object_func_list not like", value, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListIn(List<String> values) {
            addCriterion("relate_object_func_list in", values, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListNotIn(List<String> values) {
            addCriterion("relate_object_func_list not in", values, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListBetween(String value1, String value2) {
            addCriterion("relate_object_func_list between", value1, value2, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateObjectFuncListNotBetween(String value1, String value2) {
            addCriterion("relate_object_func_list not between", value1, value2, "relateObjectFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListIsNull() {
            addCriterion("relate_corporation_func_list is null");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListIsNotNull() {
            addCriterion("relate_corporation_func_list is not null");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListEqualTo(String value) {
            addCriterion("relate_corporation_func_list =", value, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListNotEqualTo(String value) {
            addCriterion("relate_corporation_func_list <>", value, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListGreaterThan(String value) {
            addCriterion("relate_corporation_func_list >", value, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListGreaterThanOrEqualTo(String value) {
            addCriterion("relate_corporation_func_list >=", value, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListLessThan(String value) {
            addCriterion("relate_corporation_func_list <", value, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListLessThanOrEqualTo(String value) {
            addCriterion("relate_corporation_func_list <=", value, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListLike(String value) {
            addCriterion("relate_corporation_func_list like", value, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListNotLike(String value) {
            addCriterion("relate_corporation_func_list not like", value, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListIn(List<String> values) {
            addCriterion("relate_corporation_func_list in", values, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListNotIn(List<String> values) {
            addCriterion("relate_corporation_func_list not in", values, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListBetween(String value1, String value2) {
            addCriterion("relate_corporation_func_list between", value1, value2, "relateCorporationFuncList");
            return (Criteria) this;
        }

        public Criteria andRelateCorporationFuncListNotBetween(String value1, String value2) {
            addCriterion("relate_corporation_func_list not between", value1, value2, "relateCorporationFuncList");
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
     * nv_deposit_contract_ec_define null
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