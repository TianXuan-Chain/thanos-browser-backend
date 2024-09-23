package com.netease.thanos.core.depositChain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * nv_deposit_evidence_point_object表查询条件构建对象
 * 
 * @author db-generator
 * @since 2021年06月17日16:10:34
 */ 
public class NvDepositEvidencePointObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public NvDepositEvidencePointObjectExample() {
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
     * nv_deposit_evidence_point_object null
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

        public Criteria andTxIdIsNull() {
            addCriterion("tx_id is null");
            return (Criteria) this;
        }

        public Criteria andTxIdIsNotNull() {
            addCriterion("tx_id is not null");
            return (Criteria) this;
        }

        public Criteria andTxIdEqualTo(Long value) {
            addCriterion("tx_id =", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdNotEqualTo(Long value) {
            addCriterion("tx_id <>", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdGreaterThan(Long value) {
            addCriterion("tx_id >", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tx_id >=", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdLessThan(Long value) {
            addCriterion("tx_id <", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdLessThanOrEqualTo(Long value) {
            addCriterion("tx_id <=", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdIn(List<Long> values) {
            addCriterion("tx_id in", values, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdNotIn(List<Long> values) {
            addCriterion("tx_id not in", values, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdBetween(Long value1, Long value2) {
            addCriterion("tx_id between", value1, value2, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdNotBetween(Long value1, Long value2) {
            addCriterion("tx_id not between", value1, value2, "txId");
            return (Criteria) this;
        }

        public Criteria andTxHashIsNull() {
            addCriterion("tx_hash is null");
            return (Criteria) this;
        }

        public Criteria andTxHashIsNotNull() {
            addCriterion("tx_hash is not null");
            return (Criteria) this;
        }

        public Criteria andTxHashEqualTo(String value) {
            addCriterion("tx_hash =", value, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashNotEqualTo(String value) {
            addCriterion("tx_hash <>", value, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashGreaterThan(String value) {
            addCriterion("tx_hash >", value, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashGreaterThanOrEqualTo(String value) {
            addCriterion("tx_hash >=", value, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashLessThan(String value) {
            addCriterion("tx_hash <", value, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashLessThanOrEqualTo(String value) {
            addCriterion("tx_hash <=", value, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashLike(String value) {
            addCriterion("tx_hash like", value, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashNotLike(String value) {
            addCriterion("tx_hash not like", value, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashIn(List<String> values) {
            addCriterion("tx_hash in", values, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashNotIn(List<String> values) {
            addCriterion("tx_hash not in", values, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashBetween(String value1, String value2) {
            addCriterion("tx_hash between", value1, value2, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxHashNotBetween(String value1, String value2) {
            addCriterion("tx_hash not between", value1, value2, "txHash");
            return (Criteria) this;
        }

        public Criteria andTxTimeIsNull() {
            addCriterion("tx_time is null");
            return (Criteria) this;
        }

        public Criteria andTxTimeIsNotNull() {
            addCriterion("tx_time is not null");
            return (Criteria) this;
        }

        public Criteria andTxTimeEqualTo(Date value) {
            addCriterion("tx_time =", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeNotEqualTo(Date value) {
            addCriterion("tx_time <>", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeGreaterThan(Date value) {
            addCriterion("tx_time >", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tx_time >=", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeLessThan(Date value) {
            addCriterion("tx_time <", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeLessThanOrEqualTo(Date value) {
            addCriterion("tx_time <=", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeIn(List<Date> values) {
            addCriterion("tx_time in", values, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeNotIn(List<Date> values) {
            addCriterion("tx_time not in", values, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeBetween(Date value1, Date value2) {
            addCriterion("tx_time between", value1, value2, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeNotBetween(Date value1, Date value2) {
            addCriterion("tx_time not between", value1, value2, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxDataIsNull() {
            addCriterion("tx_data is null");
            return (Criteria) this;
        }

        public Criteria andTxDataIsNotNull() {
            addCriterion("tx_data is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataEqualTo(String value) {
            addCriterion("tx_data =", value, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataNotEqualTo(String value) {
            addCriterion("tx_data <>", value, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataGreaterThan(String value) {
            addCriterion("tx_data >", value, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data >=", value, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataLessThan(String value) {
            addCriterion("tx_data <", value, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataLessThanOrEqualTo(String value) {
            addCriterion("tx_data <=", value, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataLike(String value) {
            addCriterion("tx_data like", value, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataNotLike(String value) {
            addCriterion("tx_data not like", value, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataIn(List<String> values) {
            addCriterion("tx_data in", values, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataNotIn(List<String> values) {
            addCriterion("tx_data not in", values, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataBetween(String value1, String value2) {
            addCriterion("tx_data between", value1, value2, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataNotBetween(String value1, String value2) {
            addCriterion("tx_data not between", value1, value2, "txData");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberIsNull() {
            addCriterion("tx_data_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberIsNotNull() {
            addCriterion("tx_data_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberEqualTo(String value) {
            addCriterion("tx_data_serial_number =", value, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberNotEqualTo(String value) {
            addCriterion("tx_data_serial_number <>", value, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberGreaterThan(String value) {
            addCriterion("tx_data_serial_number >", value, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_serial_number >=", value, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberLessThan(String value) {
            addCriterion("tx_data_serial_number <", value, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("tx_data_serial_number <=", value, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberLike(String value) {
            addCriterion("tx_data_serial_number like", value, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberNotLike(String value) {
            addCriterion("tx_data_serial_number not like", value, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberIn(List<String> values) {
            addCriterion("tx_data_serial_number in", values, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberNotIn(List<String> values) {
            addCriterion("tx_data_serial_number not in", values, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberBetween(String value1, String value2) {
            addCriterion("tx_data_serial_number between", value1, value2, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataSerialNumberNotBetween(String value1, String value2) {
            addCriterion("tx_data_serial_number not between", value1, value2, "txDataSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameIsNull() {
            addCriterion("tx_data_func_name is null");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameIsNotNull() {
            addCriterion("tx_data_func_name is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameEqualTo(String value) {
            addCriterion("tx_data_func_name =", value, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameNotEqualTo(String value) {
            addCriterion("tx_data_func_name <>", value, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameGreaterThan(String value) {
            addCriterion("tx_data_func_name >", value, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_func_name >=", value, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameLessThan(String value) {
            addCriterion("tx_data_func_name <", value, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameLessThanOrEqualTo(String value) {
            addCriterion("tx_data_func_name <=", value, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameLike(String value) {
            addCriterion("tx_data_func_name like", value, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameNotLike(String value) {
            addCriterion("tx_data_func_name not like", value, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameIn(List<String> values) {
            addCriterion("tx_data_func_name in", values, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameNotIn(List<String> values) {
            addCriterion("tx_data_func_name not in", values, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameBetween(String value1, String value2) {
            addCriterion("tx_data_func_name between", value1, value2, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataFuncNameNotBetween(String value1, String value2) {
            addCriterion("tx_data_func_name not between", value1, value2, "txDataFuncName");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectIsNull() {
            addCriterion("tx_data_relate_object is null");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectIsNotNull() {
            addCriterion("tx_data_relate_object is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectEqualTo(String value) {
            addCriterion("tx_data_relate_object =", value, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectNotEqualTo(String value) {
            addCriterion("tx_data_relate_object <>", value, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectGreaterThan(String value) {
            addCriterion("tx_data_relate_object >", value, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_relate_object >=", value, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectLessThan(String value) {
            addCriterion("tx_data_relate_object <", value, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectLessThanOrEqualTo(String value) {
            addCriterion("tx_data_relate_object <=", value, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectLike(String value) {
            addCriterion("tx_data_relate_object like", value, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectNotLike(String value) {
            addCriterion("tx_data_relate_object not like", value, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectIn(List<String> values) {
            addCriterion("tx_data_relate_object in", values, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectNotIn(List<String> values) {
            addCriterion("tx_data_relate_object not in", values, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectBetween(String value1, String value2) {
            addCriterion("tx_data_relate_object between", value1, value2, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateObjectNotBetween(String value1, String value2) {
            addCriterion("tx_data_relate_object not between", value1, value2, "txDataRelateObject");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationIsNull() {
            addCriterion("tx_data_relate_corporation is null");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationIsNotNull() {
            addCriterion("tx_data_relate_corporation is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationEqualTo(String value) {
            addCriterion("tx_data_relate_corporation =", value, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationNotEqualTo(String value) {
            addCriterion("tx_data_relate_corporation <>", value, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationGreaterThan(String value) {
            addCriterion("tx_data_relate_corporation >", value, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_relate_corporation >=", value, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationLessThan(String value) {
            addCriterion("tx_data_relate_corporation <", value, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationLessThanOrEqualTo(String value) {
            addCriterion("tx_data_relate_corporation <=", value, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationLike(String value) {
            addCriterion("tx_data_relate_corporation like", value, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationNotLike(String value) {
            addCriterion("tx_data_relate_corporation not like", value, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationIn(List<String> values) {
            addCriterion("tx_data_relate_corporation in", values, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationNotIn(List<String> values) {
            addCriterion("tx_data_relate_corporation not in", values, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationBetween(String value1, String value2) {
            addCriterion("tx_data_relate_corporation between", value1, value2, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateCorporationNotBetween(String value1, String value2) {
            addCriterion("tx_data_relate_corporation not between", value1, value2, "txDataRelateCorporation");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserIsNull() {
            addCriterion("tx_data_relate_user is null");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserIsNotNull() {
            addCriterion("tx_data_relate_user is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserEqualTo(String value) {
            addCriterion("tx_data_relate_user =", value, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserNotEqualTo(String value) {
            addCriterion("tx_data_relate_user <>", value, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserGreaterThan(String value) {
            addCriterion("tx_data_relate_user >", value, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_relate_user >=", value, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserLessThan(String value) {
            addCriterion("tx_data_relate_user <", value, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserLessThanOrEqualTo(String value) {
            addCriterion("tx_data_relate_user <=", value, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserLike(String value) {
            addCriterion("tx_data_relate_user like", value, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserNotLike(String value) {
            addCriterion("tx_data_relate_user not like", value, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserIn(List<String> values) {
            addCriterion("tx_data_relate_user in", values, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserNotIn(List<String> values) {
            addCriterion("tx_data_relate_user not in", values, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserBetween(String value1, String value2) {
            addCriterion("tx_data_relate_user between", value1, value2, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataRelateUserNotBetween(String value1, String value2) {
            addCriterion("tx_data_relate_user not between", value1, value2, "txDataRelateUser");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashIsNull() {
            addCriterion("tx_data_allparams_hash is null");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashIsNotNull() {
            addCriterion("tx_data_allparams_hash is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashEqualTo(String value) {
            addCriterion("tx_data_allparams_hash =", value, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashNotEqualTo(String value) {
            addCriterion("tx_data_allparams_hash <>", value, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashGreaterThan(String value) {
            addCriterion("tx_data_allparams_hash >", value, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_allparams_hash >=", value, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashLessThan(String value) {
            addCriterion("tx_data_allparams_hash <", value, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashLessThanOrEqualTo(String value) {
            addCriterion("tx_data_allparams_hash <=", value, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashLike(String value) {
            addCriterion("tx_data_allparams_hash like", value, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashNotLike(String value) {
            addCriterion("tx_data_allparams_hash not like", value, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashIn(List<String> values) {
            addCriterion("tx_data_allparams_hash in", values, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashNotIn(List<String> values) {
            addCriterion("tx_data_allparams_hash not in", values, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashBetween(String value1, String value2) {
            addCriterion("tx_data_allparams_hash between", value1, value2, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataAllparamsHashNotBetween(String value1, String value2) {
            addCriterion("tx_data_allparams_hash not between", value1, value2, "txDataAllparamsHash");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonIsNull() {
            addCriterion("tx_data_partparams_hashjson is null");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonIsNotNull() {
            addCriterion("tx_data_partparams_hashjson is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonEqualTo(String value) {
            addCriterion("tx_data_partparams_hashjson =", value, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonNotEqualTo(String value) {
            addCriterion("tx_data_partparams_hashjson <>", value, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonGreaterThan(String value) {
            addCriterion("tx_data_partparams_hashjson >", value, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_partparams_hashjson >=", value, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonLessThan(String value) {
            addCriterion("tx_data_partparams_hashjson <", value, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonLessThanOrEqualTo(String value) {
            addCriterion("tx_data_partparams_hashjson <=", value, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonLike(String value) {
            addCriterion("tx_data_partparams_hashjson like", value, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonNotLike(String value) {
            addCriterion("tx_data_partparams_hashjson not like", value, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonIn(List<String> values) {
            addCriterion("tx_data_partparams_hashjson in", values, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonNotIn(List<String> values) {
            addCriterion("tx_data_partparams_hashjson not in", values, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonBetween(String value1, String value2) {
            addCriterion("tx_data_partparams_hashjson between", value1, value2, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataPartparamsHashjsonNotBetween(String value1, String value2) {
            addCriterion("tx_data_partparams_hashjson not between", value1, value2, "txDataPartparamsHashjson");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkIsNull() {
            addCriterion("tx_data_remark is null");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkIsNotNull() {
            addCriterion("tx_data_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkEqualTo(String value) {
            addCriterion("tx_data_remark =", value, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkNotEqualTo(String value) {
            addCriterion("tx_data_remark <>", value, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkGreaterThan(String value) {
            addCriterion("tx_data_remark >", value, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_remark >=", value, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkLessThan(String value) {
            addCriterion("tx_data_remark <", value, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkLessThanOrEqualTo(String value) {
            addCriterion("tx_data_remark <=", value, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkLike(String value) {
            addCriterion("tx_data_remark like", value, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkNotLike(String value) {
            addCriterion("tx_data_remark not like", value, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkIn(List<String> values) {
            addCriterion("tx_data_remark in", values, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkNotIn(List<String> values) {
            addCriterion("tx_data_remark not in", values, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkBetween(String value1, String value2) {
            addCriterion("tx_data_remark between", value1, value2, "txDataRemark");
            return (Criteria) this;
        }

        public Criteria andTxDataRemarkNotBetween(String value1, String value2) {
            addCriterion("tx_data_remark not between", value1, value2, "txDataRemark");
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
     * nv_deposit_evidence_point_object null
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