package com.netease.thanos.core.depositChain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * nv_deposit_evidence_point_hashs表查询条件构建对象
 * 
 * @author db-generator
 * @since 2020年12月27日17:05:35
 */ 
public class NvDepositEvidencePointHashsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public NvDepositEvidencePointHashsExample() {
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
     * nv_deposit_evidence_point_hashs null
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

        public Criteria andEvidencePointTypeIsNull() {
            addCriterion("evidence_point_type is null");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeIsNotNull() {
            addCriterion("evidence_point_type is not null");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeEqualTo(Integer value) {
            addCriterion("evidence_point_type =", value, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeNotEqualTo(Integer value) {
            addCriterion("evidence_point_type <>", value, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeGreaterThan(Integer value) {
            addCriterion("evidence_point_type >", value, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("evidence_point_type >=", value, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeLessThan(Integer value) {
            addCriterion("evidence_point_type <", value, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeLessThanOrEqualTo(Integer value) {
            addCriterion("evidence_point_type <=", value, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeIn(List<Integer> values) {
            addCriterion("evidence_point_type in", values, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeNotIn(List<Integer> values) {
            addCriterion("evidence_point_type not in", values, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeBetween(Integer value1, Integer value2) {
            addCriterion("evidence_point_type between", value1, value2, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("evidence_point_type not between", value1, value2, "evidencePointType");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdIsNull() {
            addCriterion("evidence_point_id is null");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdIsNotNull() {
            addCriterion("evidence_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdEqualTo(Long value) {
            addCriterion("evidence_point_id =", value, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdNotEqualTo(Long value) {
            addCriterion("evidence_point_id <>", value, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdGreaterThan(Long value) {
            addCriterion("evidence_point_id >", value, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdGreaterThanOrEqualTo(Long value) {
            addCriterion("evidence_point_id >=", value, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdLessThan(Long value) {
            addCriterion("evidence_point_id <", value, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdLessThanOrEqualTo(Long value) {
            addCriterion("evidence_point_id <=", value, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdIn(List<Long> values) {
            addCriterion("evidence_point_id in", values, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdNotIn(List<Long> values) {
            addCriterion("evidence_point_id not in", values, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdBetween(Long value1, Long value2) {
            addCriterion("evidence_point_id between", value1, value2, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andEvidencePointIdNotBetween(Long value1, Long value2) {
            addCriterion("evidence_point_id not between", value1, value2, "evidencePointId");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldIsNull() {
            addCriterion("tx_data_file_field is null");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldIsNotNull() {
            addCriterion("tx_data_file_field is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldEqualTo(String value) {
            addCriterion("tx_data_file_field =", value, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldNotEqualTo(String value) {
            addCriterion("tx_data_file_field <>", value, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldGreaterThan(String value) {
            addCriterion("tx_data_file_field >", value, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_file_field >=", value, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldLessThan(String value) {
            addCriterion("tx_data_file_field <", value, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldLessThanOrEqualTo(String value) {
            addCriterion("tx_data_file_field <=", value, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldLike(String value) {
            addCriterion("tx_data_file_field like", value, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldNotLike(String value) {
            addCriterion("tx_data_file_field not like", value, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldIn(List<String> values) {
            addCriterion("tx_data_file_field in", values, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldNotIn(List<String> values) {
            addCriterion("tx_data_file_field not in", values, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldBetween(String value1, String value2) {
            addCriterion("tx_data_file_field between", value1, value2, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldNotBetween(String value1, String value2) {
            addCriterion("tx_data_file_field not between", value1, value2, "txDataFileField");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainIsNull() {
            addCriterion("tx_data_file_is_main is null");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainIsNotNull() {
            addCriterion("tx_data_file_is_main is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainEqualTo(Integer value) {
            addCriterion("tx_data_file_is_main =", value, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainNotEqualTo(Integer value) {
            addCriterion("tx_data_file_is_main <>", value, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainGreaterThan(Integer value) {
            addCriterion("tx_data_file_is_main >", value, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainGreaterThanOrEqualTo(Integer value) {
            addCriterion("tx_data_file_is_main >=", value, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainLessThan(Integer value) {
            addCriterion("tx_data_file_is_main <", value, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainLessThanOrEqualTo(Integer value) {
            addCriterion("tx_data_file_is_main <=", value, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainIn(List<Integer> values) {
            addCriterion("tx_data_file_is_main in", values, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainNotIn(List<Integer> values) {
            addCriterion("tx_data_file_is_main not in", values, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainBetween(Integer value1, Integer value2) {
            addCriterion("tx_data_file_is_main between", value1, value2, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileIsMainNotBetween(Integer value1, Integer value2) {
            addCriterion("tx_data_file_is_main not between", value1, value2, "txDataFileIsMain");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameIsNull() {
            addCriterion("tx_data_file_name is null");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameIsNotNull() {
            addCriterion("tx_data_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameEqualTo(String value) {
            addCriterion("tx_data_file_name =", value, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameNotEqualTo(String value) {
            addCriterion("tx_data_file_name <>", value, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameGreaterThan(String value) {
            addCriterion("tx_data_file_name >", value, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_file_name >=", value, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameLessThan(String value) {
            addCriterion("tx_data_file_name <", value, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameLessThanOrEqualTo(String value) {
            addCriterion("tx_data_file_name <=", value, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameLike(String value) {
            addCriterion("tx_data_file_name like", value, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameNotLike(String value) {
            addCriterion("tx_data_file_name not like", value, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameIn(List<String> values) {
            addCriterion("tx_data_file_name in", values, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameNotIn(List<String> values) {
            addCriterion("tx_data_file_name not in", values, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameBetween(String value1, String value2) {
            addCriterion("tx_data_file_name between", value1, value2, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileNameNotBetween(String value1, String value2) {
            addCriterion("tx_data_file_name not between", value1, value2, "txDataFileName");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashIsNull() {
            addCriterion("tx_data_file_field_hash is null");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashIsNotNull() {
            addCriterion("tx_data_file_field_hash is not null");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashEqualTo(String value) {
            addCriterion("tx_data_file_field_hash =", value, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashNotEqualTo(String value) {
            addCriterion("tx_data_file_field_hash <>", value, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashGreaterThan(String value) {
            addCriterion("tx_data_file_field_hash >", value, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashGreaterThanOrEqualTo(String value) {
            addCriterion("tx_data_file_field_hash >=", value, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashLessThan(String value) {
            addCriterion("tx_data_file_field_hash <", value, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashLessThanOrEqualTo(String value) {
            addCriterion("tx_data_file_field_hash <=", value, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashLike(String value) {
            addCriterion("tx_data_file_field_hash like", value, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashNotLike(String value) {
            addCriterion("tx_data_file_field_hash not like", value, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashIn(List<String> values) {
            addCriterion("tx_data_file_field_hash in", values, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashNotIn(List<String> values) {
            addCriterion("tx_data_file_field_hash not in", values, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashBetween(String value1, String value2) {
            addCriterion("tx_data_file_field_hash between", value1, value2, "txDataFileFieldHash");
            return (Criteria) this;
        }

        public Criteria andTxDataFileFieldHashNotBetween(String value1, String value2) {
            addCriterion("tx_data_file_field_hash not between", value1, value2, "txDataFileFieldHash");
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
     * nv_deposit_evidence_point_hashs null
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