package com.netease.thanos.api.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author kingkong create on 2018-08-28
 */
@Getter
@Setter
@ToString
public class DepositChainStatisticsTransactionInfoDTO implements Serializable {
	private Long partition_key;
	private String hash;
	private String object;
	private Timestamp collectTimestamp;
	private String startMsg;
	private String startTime;
	private String onChainMsg;
	private String onChainTime;
	private String detailInfo;
}
