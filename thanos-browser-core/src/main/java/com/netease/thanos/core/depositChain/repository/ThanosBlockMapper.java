package com.netease.thanos.core.depositChain.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netease.thanos.core.depositChain.entity.ThanosBlock;
import com.netease.thanos.core.depositChain.entity.ThanosBlockExample;

/** 
 * thanos_block表数据操作层
 * 
 * @author db-generator
 * @since 2021年07月07日17:25:28
 */ 
public interface ThanosBlockMapper {
    /**
     * 已过滤删除的数据记录
     *
     * @param example 查询条件
     * @return 统计数量
     */
    int countByExample(ThanosBlockExample example);

    /**
     * 记录删除
     *
     * @param remark 备注【自动累加】可以为空
     * @param version 【version=-1强制删除】
     * @param id 主键ID
     * @return 删除行数
     */
    int deleteByPrimaryKey(@Param("id") Long id, @Param("version") Long version, @Param("remark") String remark);

    /**
     * 插入 createTime为数据库时间now()
     *
     * @param record 插入数据对象
     * @return 插入行数
     */
    int insert(ThanosBlock record);

    /**
     * 插入 createTime为数据库时间now()
     *
     * @param record 插入数据对象
     * @return 插入行数
     */
    int insertSelective(ThanosBlock record);

    /**
     * 根据条件查询
     *
     * @param example 查询构建条件
     * @return 查询数据列表
     */
    List<ThanosBlock> selectByExampleWithBLOBs(ThanosBlockExample example);

    /**
     * 根据条件查询
     *
     * @param example 查询构建条件
     * @return 查询数据列表
     */
    List<ThanosBlock> selectByExample(ThanosBlockExample example);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 查询记录
     */
    ThanosBlock selectByPrimaryKey(Long id);

    /**
     * 根据主键更新，version必传，id必传，不支持跟新createTime
     *
     * @param record 【version=-1强制更新】
     * @return 更新行数
     */
    int updateByPrimaryKeySelective(ThanosBlock record);

    /**
     * 根据主键更新，version必传，id必传，不支持跟新createTime
     *
     * @param record 【version=-1强制更新】
     * @return 更新行数
     */
    int updateByPrimaryKeyWithBLOBs(ThanosBlock record);

    /**
     * 根据主键更新，version必传，id必传，不支持跟新createTime
     *
     * @param record 【version=-1强制更新】
     * @return 更新行数
     */
    int updateByPrimaryKey(ThanosBlock record);

    /**
     * 批量插入
     *
     * @param list 数据大小size>1
     * @return 插入行数
     */
    int batchInsert(@Param("list") List<ThanosBlock> list);

    /**
     * 查询最大值
     *
     * @param example 查询条件(不能为空)
     * @return 最大值
     */
    Long maxNumber(ThanosBlockExample example);

    /**
     * 查询最小值
     *
     * @param example 查询条件
     * @return 最小值
     */
    Long minNumber(ThanosBlockExample example);
}