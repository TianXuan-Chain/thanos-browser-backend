package com.netease.thanos.core.depositChain.repository;

import com.netease.thanos.core.depositChain.entity.ThanosContractTransaction;
import com.netease.thanos.core.depositChain.entity.ThanosContractTransactionExample;
import com.netease.thanos.core.depositChain.entity.ThanosContractTransactionKey;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * thanos_contract_transaction表数据操作层
 * 
 * @author db-generator
 * @since 2023年06月15日14:45:26
 */ 
public interface ThanosContractTransactionMapper {
    /**
     * 已过滤删除的数据记录
     *
     * @param example 查询条件
     * @return 统计数量
     */
    int countByExample(ThanosContractTransactionExample example);

    /**
     * 记录删除
     *
     * @param remark 备注【自动累加】可以为空
     * @param version 【version=-1强制删除】
     * @param id 主键ID
     * @return 删除行数
     */
    int deleteByPrimaryKey(@Param("key") ThanosContractTransactionKey key, @Param("version") Long version, @Param("remark") String remark);

    /**
     * 插入 createTime为数据库时间now()
     *
     * @param record 插入数据对象
     * @return 插入行数
     */
    int insert(ThanosContractTransaction record);

    /**
     * 插入 createTime为数据库时间now()
     *
     * @param record 插入数据对象
     * @return 插入行数
     */
    int insertSelective(ThanosContractTransaction record);

    /**
     * 根据条件查询
     *
     * @param example 查询构建条件
     * @return 查询数据列表
     */
    List<ThanosContractTransaction> selectByExampleWithBLOBs(ThanosContractTransactionExample example);

    /**
     * 根据条件查询
     *
     * @param example 查询构建条件
     * @return 查询数据列表
     */
    List<ThanosContractTransaction> selectByExample(ThanosContractTransactionExample example);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 查询记录
     */
    ThanosContractTransaction selectByPrimaryKey(ThanosContractTransactionKey key);

    /**
     * 根据主键更新，version必传，id必传，不支持跟新createTime
     *
     * @param record 【version=-1强制更新】
     * @return 更新行数
     */
    int updateByPrimaryKeySelective(ThanosContractTransaction record);

    /**
     * 根据主键更新，version必传，id必传，不支持跟新createTime
     *
     * @param record 【version=-1强制更新】
     * @return 更新行数
     */
    int updateByPrimaryKeyWithBLOBs(ThanosContractTransaction record);

    /**
     * 根据主键更新，version必传，id必传，不支持跟新createTime
     *
     * @param record 【version=-1强制更新】
     * @return 更新行数
     */
    int updateByPrimaryKey(ThanosContractTransaction record);

    /**
     * 批量插入
     *
     * @param list 数据大小size>1
     * @return 插入行数
     */
    int batchInsert(@Param("list") List<ThanosContractTransaction> list);


    int deleteContractTxByIDs(@Param("contractAddress") String contractAddress, @Param("ids") List<Long> ids);
}