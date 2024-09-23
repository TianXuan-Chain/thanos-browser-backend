package com.netease.thanos.api.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class DepositChainBlockChainDTO implements Serializable {
	private Long id;
	//快高
	private Integer lastBlock;
	//交易数
	private Long txn;
	//正在交易数
	private Integer pendingTxn;
	//pbft视图
	private Long pbftView;
	//平均时间
	private BigDecimal avgTime;
}
