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
public class BcSingleStatisticsInfoBO {
	private Long partition_key;
	private String object;
	private String attr;
	private String attrName;
	private Timestamp collectTimestamp;
	private double metricValue;
	private String hostIp;
	private String detailInfo;
}
