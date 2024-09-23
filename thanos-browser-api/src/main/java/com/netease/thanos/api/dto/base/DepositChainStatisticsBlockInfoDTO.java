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
public class DepositChainStatisticsBlockInfoDTO implements Serializable {
	private Long partition_key;
	private int height;
	private String object;
	private Timestamp collectTimestamp;
	private String hash;
	private String start;
	private String sealed;
	private String execed;
	private String signed;
	private String commited;
	private String onChain;
	private String viewchange_start;
	private String viewchanged;
	private String detailInfo;
}
