package com.netease.thanos.core.depositChain.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class BcStatisticsTransactionInfoBO {
	private String hash;
	private Long partition_key;
	private String object;
	private Timestamp collectTimestamp;
	private String startMsg;
	private String startTime;
	private String onChainMsg;
	private String onChainTime;
	private String detailInfo;
}
