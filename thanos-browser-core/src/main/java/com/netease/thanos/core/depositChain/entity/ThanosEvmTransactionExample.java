package com.netease.thanos.core.depositChain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * thanos_evm_transaction表查询条件构建对象
 * 
 * @author db-generator
 * @since 2021年08月26日10:47:24
 */ 
public class ThanosEvmTransactionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public ThanosEvmTransactionExample() {
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
     * thanos_evm_transaction null
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

        public Criteria andPartitionKeyEqualTo(Long value) {
            addCriterion("partition_key =", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyNotEqualTo(Long value) {
            addCriterion("partition_key <>", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyGreaterThan(Long value) {
            addCriterion("partition_key >", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyGreaterThanOrEqualTo(Long value) {
            addCriterion("partition_key >=", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyLessThan(Long value) {
            addCriterion("partition_key <", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyLessThanOrEqualTo(Long value) {
            addCriterion("partition_key <=", value, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyIn(List<Long> values) {
            addCriterion("partition_key in", values, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyNotIn(List<Long> values) {
            addCriterion("partition_key not in", values, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyBetween(Long value1, Long value2) {
            addCriterion("partition_key between", value1, value2, "partitionKey");
            return (Criteria) this;
        }

        public Criteria andPartitionKeyNotBetween(Long value1, Long value2) {
            addCriterion("partition_key not between", value1, value2, "partitionKey");
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

        public Criteria andBlockHashIsNull() {
            addCriterion("block_hash is null");
            return (Criteria) this;
        }

        public Criteria andBlockHashIsNotNull() {
            addCriterion("block_hash is not null");
            return (Criteria) this;
        }

        public Criteria andBlockHashEqualTo(String value) {
            addCriterion("block_hash =", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashNotEqualTo(String value) {
            addCriterion("block_hash <>", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashGreaterThan(String value) {
            addCriterion("block_hash >", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashGreaterThanOrEqualTo(String value) {
            addCriterion("block_hash >=", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashLessThan(String value) {
            addCriterion("block_hash <", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashLessThanOrEqualTo(String value) {
            addCriterion("block_hash <=", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashLike(String value) {
            addCriterion("block_hash like", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashNotLike(String value) {
            addCriterion("block_hash not like", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashIn(List<String> values) {
            addCriterion("block_hash in", values, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashNotIn(List<String> values) {
            addCriterion("block_hash not in", values, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashBetween(String value1, String value2) {
            addCriterion("block_hash between", value1, value2, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashNotBetween(String value1, String value2) {
            addCriterion("block_hash not between", value1, value2, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockNumberIsNull() {
            addCriterion("block_number is null");
            return (Criteria) this;
        }

        public Criteria andBlockNumberIsNotNull() {
            addCriterion("block_number is not null");
            return (Criteria) this;
        }

        public Criteria andBlockNumberEqualTo(Long value) {
            addCriterion("block_number =", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberNotEqualTo(Long value) {
            addCriterion("block_number <>", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberGreaterThan(Long value) {
            addCriterion("block_number >", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("block_number >=", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberLessThan(Long value) {
            addCriterion("block_number <", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberLessThanOrEqualTo(Long value) {
            addCriterion("block_number <=", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberIn(List<Long> values) {
            addCriterion("block_number in", values, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberNotIn(List<Long> values) {
            addCriterion("block_number not in", values, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberBetween(Long value1, Long value2) {
            addCriterion("block_number between", value1, value2, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberNotBetween(Long value1, Long value2) {
            addCriterion("block_number not between", value1, value2, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampIsNull() {
            addCriterion("block_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampIsNotNull() {
            addCriterion("block_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampEqualTo(Date value) {
            addCriterion("block_timestamp =", value, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampNotEqualTo(Date value) {
            addCriterion("block_timestamp <>", value, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampGreaterThan(Date value) {
            addCriterion("block_timestamp >", value, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("block_timestamp >=", value, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampLessThan(Date value) {
            addCriterion("block_timestamp <", value, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampLessThanOrEqualTo(Date value) {
            addCriterion("block_timestamp <=", value, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampIn(List<Date> values) {
            addCriterion("block_timestamp in", values, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampNotIn(List<Date> values) {
            addCriterion("block_timestamp not in", values, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampBetween(Date value1, Date value2) {
            addCriterion("block_timestamp between", value1, value2, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andBlockTimestampNotBetween(Date value1, Date value2) {
            addCriterion("block_timestamp not between", value1, value2, "blockTimestamp");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexIsNull() {
            addCriterion("transaction_index is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexIsNotNull() {
            addCriterion("transaction_index is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexEqualTo(Long value) {
            addCriterion("transaction_index =", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexNotEqualTo(Long value) {
            addCriterion("transaction_index <>", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexGreaterThan(Long value) {
            addCriterion("transaction_index >", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("transaction_index >=", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexLessThan(Long value) {
            addCriterion("transaction_index <", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexLessThanOrEqualTo(Long value) {
            addCriterion("transaction_index <=", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexIn(List<Long> values) {
            addCriterion("transaction_index in", values, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexNotIn(List<Long> values) {
            addCriterion("transaction_index not in", values, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexBetween(Long value1, Long value2) {
            addCriterion("transaction_index between", value1, value2, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexNotBetween(Long value1, Long value2) {
            addCriterion("transaction_index not between", value1, value2, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIsNull() {
            addCriterion("transaction_type is null");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIsNotNull() {
            addCriterion("transaction_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeEqualTo(Integer value) {
            addCriterion("transaction_type =", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotEqualTo(Integer value) {
            addCriterion("transaction_type <>", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeGreaterThan(Integer value) {
            addCriterion("transaction_type >", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_type >=", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLessThan(Integer value) {
            addCriterion("transaction_type <", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_type <=", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIn(List<Integer> values) {
            addCriterion("transaction_type in", values, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotIn(List<Integer> values) {
            addCriterion("transaction_type not in", values, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeBetween(Integer value1, Integer value2) {
            addCriterion("transaction_type between", value1, value2, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_type not between", value1, value2, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionFromIsNull() {
            addCriterion("transaction_from is null");
            return (Criteria) this;
        }

        public Criteria andTransactionFromIsNotNull() {
            addCriterion("transaction_from is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionFromEqualTo(String value) {
            addCriterion("transaction_from =", value, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromNotEqualTo(String value) {
            addCriterion("transaction_from <>", value, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromGreaterThan(String value) {
            addCriterion("transaction_from >", value, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_from >=", value, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromLessThan(String value) {
            addCriterion("transaction_from <", value, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromLessThanOrEqualTo(String value) {
            addCriterion("transaction_from <=", value, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromLike(String value) {
            addCriterion("transaction_from like", value, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromNotLike(String value) {
            addCriterion("transaction_from not like", value, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromIn(List<String> values) {
            addCriterion("transaction_from in", values, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromNotIn(List<String> values) {
            addCriterion("transaction_from not in", values, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromBetween(String value1, String value2) {
            addCriterion("transaction_from between", value1, value2, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionFromNotBetween(String value1, String value2) {
            addCriterion("transaction_from not between", value1, value2, "transactionFrom");
            return (Criteria) this;
        }

        public Criteria andTransactionToIsNull() {
            addCriterion("transaction_to is null");
            return (Criteria) this;
        }

        public Criteria andTransactionToIsNotNull() {
            addCriterion("transaction_to is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionToEqualTo(String value) {
            addCriterion("transaction_to =", value, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToNotEqualTo(String value) {
            addCriterion("transaction_to <>", value, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToGreaterThan(String value) {
            addCriterion("transaction_to >", value, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_to >=", value, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToLessThan(String value) {
            addCriterion("transaction_to <", value, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToLessThanOrEqualTo(String value) {
            addCriterion("transaction_to <=", value, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToLike(String value) {
            addCriterion("transaction_to like", value, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToNotLike(String value) {
            addCriterion("transaction_to not like", value, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToIn(List<String> values) {
            addCriterion("transaction_to in", values, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToNotIn(List<String> values) {
            addCriterion("transaction_to not in", values, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToBetween(String value1, String value2) {
            addCriterion("transaction_to between", value1, value2, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andTransactionToNotBetween(String value1, String value2) {
            addCriterion("transaction_to not between", value1, value2, "transactionTo");
            return (Criteria) this;
        }

        public Criteria andGasLimitIsNull() {
            addCriterion("gas_limit is null");
            return (Criteria) this;
        }

        public Criteria andGasLimitIsNotNull() {
            addCriterion("gas_limit is not null");
            return (Criteria) this;
        }

        public Criteria andGasLimitEqualTo(Long value) {
            addCriterion("gas_limit =", value, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasLimitNotEqualTo(Long value) {
            addCriterion("gas_limit <>", value, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasLimitGreaterThan(Long value) {
            addCriterion("gas_limit >", value, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasLimitGreaterThanOrEqualTo(Long value) {
            addCriterion("gas_limit >=", value, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasLimitLessThan(Long value) {
            addCriterion("gas_limit <", value, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasLimitLessThanOrEqualTo(Long value) {
            addCriterion("gas_limit <=", value, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasLimitIn(List<Long> values) {
            addCriterion("gas_limit in", values, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasLimitNotIn(List<Long> values) {
            addCriterion("gas_limit not in", values, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasLimitBetween(Long value1, Long value2) {
            addCriterion("gas_limit between", value1, value2, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasLimitNotBetween(Long value1, Long value2) {
            addCriterion("gas_limit not between", value1, value2, "gasLimit");
            return (Criteria) this;
        }

        public Criteria andGasPriceIsNull() {
            addCriterion("gas_price is null");
            return (Criteria) this;
        }

        public Criteria andGasPriceIsNotNull() {
            addCriterion("gas_price is not null");
            return (Criteria) this;
        }

        public Criteria andGasPriceEqualTo(BigDecimal value) {
            addCriterion("gas_price =", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceNotEqualTo(BigDecimal value) {
            addCriterion("gas_price <>", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceGreaterThan(BigDecimal value) {
            addCriterion("gas_price >", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gas_price >=", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceLessThan(BigDecimal value) {
            addCriterion("gas_price <", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gas_price <=", value, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceIn(List<BigDecimal> values) {
            addCriterion("gas_price in", values, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceNotIn(List<BigDecimal> values) {
            addCriterion("gas_price not in", values, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gas_price between", value1, value2, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andGasPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gas_price not between", value1, value2, "gasPrice");
            return (Criteria) this;
        }

        public Criteria andRandomIdIsNull() {
            addCriterion("random_id is null");
            return (Criteria) this;
        }

        public Criteria andRandomIdIsNotNull() {
            addCriterion("random_id is not null");
            return (Criteria) this;
        }

        public Criteria andRandomIdEqualTo(String value) {
            addCriterion("random_id =", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdNotEqualTo(String value) {
            addCriterion("random_id <>", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdGreaterThan(String value) {
            addCriterion("random_id >", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdGreaterThanOrEqualTo(String value) {
            addCriterion("random_id >=", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdLessThan(String value) {
            addCriterion("random_id <", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdLessThanOrEqualTo(String value) {
            addCriterion("random_id <=", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdLike(String value) {
            addCriterion("random_id like", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdNotLike(String value) {
            addCriterion("random_id not like", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdIn(List<String> values) {
            addCriterion("random_id in", values, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdNotIn(List<String> values) {
            addCriterion("random_id not in", values, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdBetween(String value1, String value2) {
            addCriterion("random_id between", value1, value2, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdNotBetween(String value1, String value2) {
            addCriterion("random_id not between", value1, value2, "randomId");
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

        public Criteria andContractVersionIsNull() {
            addCriterion("contract_version is null");
            return (Criteria) this;
        }

        public Criteria andContractVersionIsNotNull() {
            addCriterion("contract_version is not null");
            return (Criteria) this;
        }

        public Criteria andContractVersionEqualTo(String value) {
            addCriterion("contract_version =", value, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionNotEqualTo(String value) {
            addCriterion("contract_version <>", value, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionGreaterThan(String value) {
            addCriterion("contract_version >", value, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionGreaterThanOrEqualTo(String value) {
            addCriterion("contract_version >=", value, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionLessThan(String value) {
            addCriterion("contract_version <", value, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionLessThanOrEqualTo(String value) {
            addCriterion("contract_version <=", value, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionLike(String value) {
            addCriterion("contract_version like", value, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionNotLike(String value) {
            addCriterion("contract_version not like", value, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionIn(List<String> values) {
            addCriterion("contract_version in", values, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionNotIn(List<String> values) {
            addCriterion("contract_version not in", values, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionBetween(String value1, String value2) {
            addCriterion("contract_version between", value1, value2, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andContractVersionNotBetween(String value1, String value2) {
            addCriterion("contract_version not between", value1, value2, "contractVersion");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andBizDataIsNull() {
            addCriterion("biz_data is null");
            return (Criteria) this;
        }

        public Criteria andBizDataIsNotNull() {
            addCriterion("biz_data is not null");
            return (Criteria) this;
        }

        public Criteria andBizDataEqualTo(String value) {
            addCriterion("biz_data =", value, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataNotEqualTo(String value) {
            addCriterion("biz_data <>", value, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataGreaterThan(String value) {
            addCriterion("biz_data >", value, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataGreaterThanOrEqualTo(String value) {
            addCriterion("biz_data >=", value, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataLessThan(String value) {
            addCriterion("biz_data <", value, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataLessThanOrEqualTo(String value) {
            addCriterion("biz_data <=", value, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataLike(String value) {
            addCriterion("biz_data like", value, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataNotLike(String value) {
            addCriterion("biz_data not like", value, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataIn(List<String> values) {
            addCriterion("biz_data in", values, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataNotIn(List<String> values) {
            addCriterion("biz_data not in", values, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataBetween(String value1, String value2) {
            addCriterion("biz_data between", value1, value2, "bizData");
            return (Criteria) this;
        }

        public Criteria andBizDataNotBetween(String value1, String value2) {
            addCriterion("biz_data not between", value1, value2, "bizData");
            return (Criteria) this;
        }

        public Criteria andTradeStatIsNull() {
            addCriterion("trade_stat is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatIsNotNull() {
            addCriterion("trade_stat is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatEqualTo(Integer value) {
            addCriterion("trade_stat =", value, "tradeStat");
            return (Criteria) this;
        }

        public Criteria andTradeStatNotEqualTo(Integer value) {
            addCriterion("trade_stat <>", value, "tradeStat");
            return (Criteria) this;
        }

        public Criteria andTradeStatGreaterThan(Integer value) {
            addCriterion("trade_stat >", value, "tradeStat");
            return (Criteria) this;
        }

        public Criteria andTradeStatGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_stat >=", value, "tradeStat");
            return (Criteria) this;
        }

        public Criteria andTradeStatLessThan(Integer value) {
            addCriterion("trade_stat <", value, "tradeStat");
            return (Criteria) this;
        }

        public Criteria andTradeStatLessThanOrEqualTo(Integer value) {
            addCriterion("trade_stat <=", value, "tradeStat");
            return (Criteria) this;
        }

        public Criteria andTradeStatIn(List<Integer> values) {
            addCriterion("trade_stat in", values, "tradeStat");
            return (Criteria) this;
        }

        public Criteria andTradeStatNotIn(List<Integer> values) {
            addCriterion("trade_stat not in", values, "tradeStat");
            return (Criteria) this;
        }

        public Criteria andTradeStatBetween(Integer value1, Integer value2) {
            addCriterion("trade_stat between", value1, value2, "tradeStat");
            return (Criteria) this;
        }

        public Criteria andTradeStatNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_stat not between", value1, value2, "tradeStat");
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
     * thanos_evm_transaction null
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