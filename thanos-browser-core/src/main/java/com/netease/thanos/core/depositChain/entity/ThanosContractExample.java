package com.netease.thanos.core.depositChain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * thanos_contract表查询条件构建对象
 * 
 * @author db-generator
 * @since 2023年06月15日14:45:26
 */ 
public class ThanosContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public ThanosContractExample() {
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
     * thanos_contract null
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

        public Criteria andContractProtocolIsNull() {
            addCriterion("contract_protocol is null");
            return (Criteria) this;
        }

        public Criteria andContractProtocolIsNotNull() {
            addCriterion("contract_protocol is not null");
            return (Criteria) this;
        }

        public Criteria andContractProtocolEqualTo(Integer value) {
            addCriterion("contract_protocol =", value, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractProtocolNotEqualTo(Integer value) {
            addCriterion("contract_protocol <>", value, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractProtocolGreaterThan(Integer value) {
            addCriterion("contract_protocol >", value, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractProtocolGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_protocol >=", value, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractProtocolLessThan(Integer value) {
            addCriterion("contract_protocol <", value, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractProtocolLessThanOrEqualTo(Integer value) {
            addCriterion("contract_protocol <=", value, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractProtocolIn(List<Integer> values) {
            addCriterion("contract_protocol in", values, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractProtocolNotIn(List<Integer> values) {
            addCriterion("contract_protocol not in", values, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractProtocolBetween(Integer value1, Integer value2) {
            addCriterion("contract_protocol between", value1, value2, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractProtocolNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_protocol not between", value1, value2, "contractProtocol");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNull() {
            addCriterion("contract_name is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("contract_name =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("contract_name <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("contract_name >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("contract_name <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("contract_name <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("contract_name like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("contract_name not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("contract_name in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("contract_name not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("contract_name between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("contract_name not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressIsNull() {
            addCriterion("contract_deploy_address is null");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressIsNotNull() {
            addCriterion("contract_deploy_address is not null");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressEqualTo(String value) {
            addCriterion("contract_deploy_address =", value, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressNotEqualTo(String value) {
            addCriterion("contract_deploy_address <>", value, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressGreaterThan(String value) {
            addCriterion("contract_deploy_address >", value, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressGreaterThanOrEqualTo(String value) {
            addCriterion("contract_deploy_address >=", value, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressLessThan(String value) {
            addCriterion("contract_deploy_address <", value, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressLessThanOrEqualTo(String value) {
            addCriterion("contract_deploy_address <=", value, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressLike(String value) {
            addCriterion("contract_deploy_address like", value, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressNotLike(String value) {
            addCriterion("contract_deploy_address not like", value, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressIn(List<String> values) {
            addCriterion("contract_deploy_address in", values, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressNotIn(List<String> values) {
            addCriterion("contract_deploy_address not in", values, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressBetween(String value1, String value2) {
            addCriterion("contract_deploy_address between", value1, value2, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDeployAddressNotBetween(String value1, String value2) {
            addCriterion("contract_deploy_address not between", value1, value2, "contractDeployAddress");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionIsNull() {
            addCriterion("contract_description is null");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionIsNotNull() {
            addCriterion("contract_description is not null");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionEqualTo(String value) {
            addCriterion("contract_description =", value, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionNotEqualTo(String value) {
            addCriterion("contract_description <>", value, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionGreaterThan(String value) {
            addCriterion("contract_description >", value, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("contract_description >=", value, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionLessThan(String value) {
            addCriterion("contract_description <", value, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionLessThanOrEqualTo(String value) {
            addCriterion("contract_description <=", value, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionLike(String value) {
            addCriterion("contract_description like", value, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionNotLike(String value) {
            addCriterion("contract_description not like", value, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionIn(List<String> values) {
            addCriterion("contract_description in", values, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionNotIn(List<String> values) {
            addCriterion("contract_description not in", values, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionBetween(String value1, String value2) {
            addCriterion("contract_description between", value1, value2, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andContractDescriptionNotBetween(String value1, String value2) {
            addCriterion("contract_description not between", value1, value2, "contractDescription");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyIsNull() {
            addCriterion("total_limit_supply is null");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyIsNotNull() {
            addCriterion("total_limit_supply is not null");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyEqualTo(Integer value) {
            addCriterion("total_limit_supply =", value, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyNotEqualTo(Integer value) {
            addCriterion("total_limit_supply <>", value, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyGreaterThan(Integer value) {
            addCriterion("total_limit_supply >", value, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_limit_supply >=", value, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyLessThan(Integer value) {
            addCriterion("total_limit_supply <", value, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyLessThanOrEqualTo(Integer value) {
            addCriterion("total_limit_supply <=", value, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyIn(List<Integer> values) {
            addCriterion("total_limit_supply in", values, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyNotIn(List<Integer> values) {
            addCriterion("total_limit_supply not in", values, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyBetween(Integer value1, Integer value2) {
            addCriterion("total_limit_supply between", value1, value2, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andTotalLimitSupplyNotBetween(Integer value1, Integer value2) {
            addCriterion("total_limit_supply not between", value1, value2, "totalLimitSupply");
            return (Criteria) this;
        }

        public Criteria andExtendInfoIsNull() {
            addCriterion("extend_info is null");
            return (Criteria) this;
        }

        public Criteria andExtendInfoIsNotNull() {
            addCriterion("extend_info is not null");
            return (Criteria) this;
        }

        public Criteria andExtendInfoEqualTo(String value) {
            addCriterion("extend_info =", value, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoNotEqualTo(String value) {
            addCriterion("extend_info <>", value, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoGreaterThan(String value) {
            addCriterion("extend_info >", value, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoGreaterThanOrEqualTo(String value) {
            addCriterion("extend_info >=", value, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoLessThan(String value) {
            addCriterion("extend_info <", value, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoLessThanOrEqualTo(String value) {
            addCriterion("extend_info <=", value, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoLike(String value) {
            addCriterion("extend_info like", value, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoNotLike(String value) {
            addCriterion("extend_info not like", value, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoIn(List<String> values) {
            addCriterion("extend_info in", values, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoNotIn(List<String> values) {
            addCriterion("extend_info not in", values, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoBetween(String value1, String value2) {
            addCriterion("extend_info between", value1, value2, "extendInfo");
            return (Criteria) this;
        }

        public Criteria andExtendInfoNotBetween(String value1, String value2) {
            addCriterion("extend_info not between", value1, value2, "extendInfo");
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
     * thanos_contract null
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