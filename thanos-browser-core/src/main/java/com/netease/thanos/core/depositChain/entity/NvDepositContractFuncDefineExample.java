package com.netease.thanos.core.depositChain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * nv_deposit_contract_func_define表查询条件构建对象
 * 
 * @author db-generator
 * @since 2020年12月08日14:44:19
 */ 
public class NvDepositContractFuncDefineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public NvDepositContractFuncDefineExample() {
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
     * nv_deposit_contract_func_define null
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

        public Criteria andFuncNameIsNull() {
            addCriterion("func_name is null");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNotNull() {
            addCriterion("func_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuncNameEqualTo(String value) {
            addCriterion("func_name =", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotEqualTo(String value) {
            addCriterion("func_name <>", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThan(String value) {
            addCriterion("func_name >", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThanOrEqualTo(String value) {
            addCriterion("func_name >=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThan(String value) {
            addCriterion("func_name <", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThanOrEqualTo(String value) {
            addCriterion("func_name <=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLike(String value) {
            addCriterion("func_name like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotLike(String value) {
            addCriterion("func_name not like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameIn(List<String> values) {
            addCriterion("func_name in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotIn(List<String> values) {
            addCriterion("func_name not in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameBetween(String value1, String value2) {
            addCriterion("func_name between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotBetween(String value1, String value2) {
            addCriterion("func_name not between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncParamsIsNull() {
            addCriterion("func_params is null");
            return (Criteria) this;
        }

        public Criteria andFuncParamsIsNotNull() {
            addCriterion("func_params is not null");
            return (Criteria) this;
        }

        public Criteria andFuncParamsEqualTo(String value) {
            addCriterion("func_params =", value, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsNotEqualTo(String value) {
            addCriterion("func_params <>", value, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsGreaterThan(String value) {
            addCriterion("func_params >", value, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsGreaterThanOrEqualTo(String value) {
            addCriterion("func_params >=", value, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsLessThan(String value) {
            addCriterion("func_params <", value, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsLessThanOrEqualTo(String value) {
            addCriterion("func_params <=", value, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsLike(String value) {
            addCriterion("func_params like", value, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsNotLike(String value) {
            addCriterion("func_params not like", value, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsIn(List<String> values) {
            addCriterion("func_params in", values, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsNotIn(List<String> values) {
            addCriterion("func_params not in", values, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsBetween(String value1, String value2) {
            addCriterion("func_params between", value1, value2, "funcParams");
            return (Criteria) this;
        }

        public Criteria andFuncParamsNotBetween(String value1, String value2) {
            addCriterion("func_params not between", value1, value2, "funcParams");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignIsNull() {
            addCriterion("contract_func_sign is null");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignIsNotNull() {
            addCriterion("contract_func_sign is not null");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignEqualTo(String value) {
            addCriterion("contract_func_sign =", value, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignNotEqualTo(String value) {
            addCriterion("contract_func_sign <>", value, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignGreaterThan(String value) {
            addCriterion("contract_func_sign >", value, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignGreaterThanOrEqualTo(String value) {
            addCriterion("contract_func_sign >=", value, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignLessThan(String value) {
            addCriterion("contract_func_sign <", value, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignLessThanOrEqualTo(String value) {
            addCriterion("contract_func_sign <=", value, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignLike(String value) {
            addCriterion("contract_func_sign like", value, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignNotLike(String value) {
            addCriterion("contract_func_sign not like", value, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignIn(List<String> values) {
            addCriterion("contract_func_sign in", values, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignNotIn(List<String> values) {
            addCriterion("contract_func_sign not in", values, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignBetween(String value1, String value2) {
            addCriterion("contract_func_sign between", value1, value2, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncSignNotBetween(String value1, String value2) {
            addCriterion("contract_func_sign not between", value1, value2, "contractFuncSign");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthIsNull() {
            addCriterion("contract_func_params_length is null");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthIsNotNull() {
            addCriterion("contract_func_params_length is not null");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthEqualTo(Integer value) {
            addCriterion("contract_func_params_length =", value, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthNotEqualTo(Integer value) {
            addCriterion("contract_func_params_length <>", value, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthGreaterThan(Integer value) {
            addCriterion("contract_func_params_length >", value, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_func_params_length >=", value, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthLessThan(Integer value) {
            addCriterion("contract_func_params_length <", value, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthLessThanOrEqualTo(Integer value) {
            addCriterion("contract_func_params_length <=", value, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthIn(List<Integer> values) {
            addCriterion("contract_func_params_length in", values, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthNotIn(List<Integer> values) {
            addCriterion("contract_func_params_length not in", values, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthBetween(Integer value1, Integer value2) {
            addCriterion("contract_func_params_length between", value1, value2, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andContractFuncParamsLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_func_params_length not between", value1, value2, "contractFuncParamsLength");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineIsNull() {
            addCriterion("main_evidence_define is null");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineIsNotNull() {
            addCriterion("main_evidence_define is not null");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineEqualTo(Integer value) {
            addCriterion("main_evidence_define =", value, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineNotEqualTo(Integer value) {
            addCriterion("main_evidence_define <>", value, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineGreaterThan(Integer value) {
            addCriterion("main_evidence_define >", value, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineGreaterThanOrEqualTo(Integer value) {
            addCriterion("main_evidence_define >=", value, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineLessThan(Integer value) {
            addCriterion("main_evidence_define <", value, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineLessThanOrEqualTo(Integer value) {
            addCriterion("main_evidence_define <=", value, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineIn(List<Integer> values) {
            addCriterion("main_evidence_define in", values, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineNotIn(List<Integer> values) {
            addCriterion("main_evidence_define not in", values, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineBetween(Integer value1, Integer value2) {
            addCriterion("main_evidence_define between", value1, value2, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andMainEvidenceDefineNotBetween(Integer value1, Integer value2) {
            addCriterion("main_evidence_define not between", value1, value2, "mainEvidenceDefine");
            return (Criteria) this;
        }

        public Criteria andEndFuncIsNull() {
            addCriterion("end_func is null");
            return (Criteria) this;
        }

        public Criteria andEndFuncIsNotNull() {
            addCriterion("end_func is not null");
            return (Criteria) this;
        }

        public Criteria andEndFuncEqualTo(Integer value) {
            addCriterion("end_func =", value, "endFunc");
            return (Criteria) this;
        }

        public Criteria andEndFuncNotEqualTo(Integer value) {
            addCriterion("end_func <>", value, "endFunc");
            return (Criteria) this;
        }

        public Criteria andEndFuncGreaterThan(Integer value) {
            addCriterion("end_func >", value, "endFunc");
            return (Criteria) this;
        }

        public Criteria andEndFuncGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_func >=", value, "endFunc");
            return (Criteria) this;
        }

        public Criteria andEndFuncLessThan(Integer value) {
            addCriterion("end_func <", value, "endFunc");
            return (Criteria) this;
        }

        public Criteria andEndFuncLessThanOrEqualTo(Integer value) {
            addCriterion("end_func <=", value, "endFunc");
            return (Criteria) this;
        }

        public Criteria andEndFuncIn(List<Integer> values) {
            addCriterion("end_func in", values, "endFunc");
            return (Criteria) this;
        }

        public Criteria andEndFuncNotIn(List<Integer> values) {
            addCriterion("end_func not in", values, "endFunc");
            return (Criteria) this;
        }

        public Criteria andEndFuncBetween(Integer value1, Integer value2) {
            addCriterion("end_func between", value1, value2, "endFunc");
            return (Criteria) this;
        }

        public Criteria andEndFuncNotBetween(Integer value1, Integer value2) {
            addCriterion("end_func not between", value1, value2, "endFunc");
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
     * nv_deposit_contract_func_define null
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