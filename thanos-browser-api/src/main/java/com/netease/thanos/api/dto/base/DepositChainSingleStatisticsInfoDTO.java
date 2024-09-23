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
public class DepositChainSingleStatisticsInfoDTO implements Serializable {
	private Long partition_key;
	private String object;
	private String attr;
	private String attrName;
	private Timestamp collectTimestamp;
	private double metricValue;
	private String hostIp;
	private String detailInfo;
}
