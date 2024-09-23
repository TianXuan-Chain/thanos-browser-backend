package com.netease.thanos.core.depositChain.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString

public class BcBlockChainBO {
	private Long id;
	private Integer lastBlock;
	private Long txn;
	private Integer pendingTxn;
	private Long pbftView;
	private BigDecimal avgTime;
	private Date gmtCreate;
	private Date gmtModify;
}
