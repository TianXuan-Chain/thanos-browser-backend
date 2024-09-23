package com.netease.thanos.core.depositChain.service.biz;

/**
 * 分区管理服务
 * @author hzshujun
 *
 */
public interface ChainPartitionService {
	/**
	 * 检查分区或者创建分区
	 */
	public void checkAndAddPartition();
	
}
