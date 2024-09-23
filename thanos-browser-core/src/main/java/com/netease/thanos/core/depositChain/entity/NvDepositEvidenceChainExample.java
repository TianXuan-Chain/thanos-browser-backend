package com.netease.thanos.core.depositChain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * nv_deposit_evidence_chain表查询条件构建对象
 * 
 * @author db-generator
 * @since 2020年12月17日17:53:37
 */ 
public class NvDepositEvidenceChainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public NvDepositEvidenceChainExample() {
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
     * nv_deposit_evidence_chain null
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

        public Criteria andRelateObjectIsNull() {
            addCriterion("relate_object is null");
            return (Criteria) this;
        }

        public Criteria andRelateObjectIsNotNull() {
            addCriterion("relate_object is not null");
            return (Criteria) this;
        }

        public Criteria andRelateObjectEqualTo(String value) {
            addCriterion("relate_object =", value, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectNotEqualTo(String value) {
            addCriterion("relate_object <>", value, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectGreaterThan(String value) {
            addCriterion("relate_object >", value, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectGreaterThanOrEqualTo(String value) {
            addCriterion("relate_object >=", value, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectLessThan(String value) {
            addCriterion("relate_object <", value, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectLessThanOrEqualTo(String value) {
            addCriterion("relate_object <=", value, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectLike(String value) {
            addCriterion("relate_object like", value, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectNotLike(String value) {
            addCriterion("relate_object not like", value, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectIn(List<String> values) {
            addCriterion("relate_object in", values, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectNotIn(List<String> values) {
            addCriterion("relate_object not in", values, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectBetween(String value1, String value2) {
            addCriterion("relate_object between", value1, value2, "relateObject");
            return (Criteria) this;
        }

        public Criteria andRelateObjectNotBetween(String value1, String value2) {
            addCriterion("relate_object not between", value1, value2, "relateObject");
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

        public Criteria andTxStartTimeIsNull() {
            addCriterion("tx_start_time is null");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeIsNotNull() {
            addCriterion("tx_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeEqualTo(Date value) {
            addCriterion("tx_start_time =", value, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeNotEqualTo(Date value) {
            addCriterion("tx_start_time <>", value, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeGreaterThan(Date value) {
            addCriterion("tx_start_time >", value, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tx_start_time >=", value, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeLessThan(Date value) {
            addCriterion("tx_start_time <", value, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("tx_start_time <=", value, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeIn(List<Date> values) {
            addCriterion("tx_start_time in", values, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeNotIn(List<Date> values) {
            addCriterion("tx_start_time not in", values, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeBetween(Date value1, Date value2) {
            addCriterion("tx_start_time between", value1, value2, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("tx_start_time not between", value1, value2, "txStartTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeIsNull() {
            addCriterion("tx_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeIsNotNull() {
            addCriterion("tx_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeEqualTo(Date value) {
            addCriterion("tx_end_time =", value, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeNotEqualTo(Date value) {
            addCriterion("tx_end_time <>", value, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeGreaterThan(Date value) {
            addCriterion("tx_end_time >", value, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tx_end_time >=", value, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeLessThan(Date value) {
            addCriterion("tx_end_time <", value, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("tx_end_time <=", value, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeIn(List<Date> values) {
            addCriterion("tx_end_time in", values, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeNotIn(List<Date> values) {
            addCriterion("tx_end_time not in", values, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeBetween(Date value1, Date value2) {
            addCriterion("tx_end_time between", value1, value2, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("tx_end_time not between", value1, value2, "txEndTime");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightIsNull() {
            addCriterion("txs_blockheight is null");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightIsNotNull() {
            addCriterion("txs_blockheight is not null");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightEqualTo(String value) {
            addCriterion("txs_blockheight =", value, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightNotEqualTo(String value) {
            addCriterion("txs_blockheight <>", value, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightGreaterThan(String value) {
            addCriterion("txs_blockheight >", value, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightGreaterThanOrEqualTo(String value) {
            addCriterion("txs_blockheight >=", value, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightLessThan(String value) {
            addCriterion("txs_blockheight <", value, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightLessThanOrEqualTo(String value) {
            addCriterion("txs_blockheight <=", value, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightLike(String value) {
            addCriterion("txs_blockheight like", value, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightNotLike(String value) {
            addCriterion("txs_blockheight not like", value, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightIn(List<String> values) {
            addCriterion("txs_blockheight in", values, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightNotIn(List<String> values) {
            addCriterion("txs_blockheight not in", values, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightBetween(String value1, String value2) {
            addCriterion("txs_blockheight between", value1, value2, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andTxsBlockheightNotBetween(String value1, String value2) {
            addCriterion("txs_blockheight not between", value1, value2, "txsBlockheight");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberIsNull() {
            addCriterion("unique_number is null");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberIsNotNull() {
            addCriterion("unique_number is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberEqualTo(String value) {
            addCriterion("unique_number =", value, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberNotEqualTo(String value) {
            addCriterion("unique_number <>", value, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberGreaterThan(String value) {
            addCriterion("unique_number >", value, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberGreaterThanOrEqualTo(String value) {
            addCriterion("unique_number >=", value, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberLessThan(String value) {
            addCriterion("unique_number <", value, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberLessThanOrEqualTo(String value) {
            addCriterion("unique_number <=", value, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberLike(String value) {
            addCriterion("unique_number like", value, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberNotLike(String value) {
            addCriterion("unique_number not like", value, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberIn(List<String> values) {
            addCriterion("unique_number in", values, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberNotIn(List<String> values) {
            addCriterion("unique_number not in", values, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberBetween(String value1, String value2) {
            addCriterion("unique_number between", value1, value2, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andUniqueNumberNotBetween(String value1, String value2) {
            addCriterion("unique_number not between", value1, value2, "uniqueNumber");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusIsNull() {
            addCriterion("onchain_status is null");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusIsNotNull() {
            addCriterion("onchain_status is not null");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusEqualTo(Integer value) {
            addCriterion("onchain_status =", value, "onchainStatus");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusNotEqualTo(Integer value) {
            addCriterion("onchain_status <>", value, "onchainStatus");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusGreaterThan(Integer value) {
            addCriterion("onchain_status >", value, "onchainStatus");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("onchain_status >=", value, "onchainStatus");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusLessThan(Integer value) {
            addCriterion("onchain_status <", value, "onchainStatus");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusLessThanOrEqualTo(Integer value) {
            addCriterion("onchain_status <=", value, "onchainStatus");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusIn(List<Integer> values) {
            addCriterion("onchain_status in", values, "onchainStatus");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusNotIn(List<Integer> values) {
            addCriterion("onchain_status not in", values, "onchainStatus");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusBetween(Integer value1, Integer value2) {
            addCriterion("onchain_status between", value1, value2, "onchainStatus");
            return (Criteria) this;
        }

        public Criteria andOnchainStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("onchain_status not between", value1, value2, "onchainStatus");
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
     * nv_deposit_evidence_chain null
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