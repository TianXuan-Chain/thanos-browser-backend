package com.netease.thanos.api.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author kingkong create on 2018-08-28
 * node rpc information
 *
 */

@ToString
@Getter
@Setter
public class DepositChainPeerNodeDTO implements Serializable {

	/**
	 * 主键
	 */
	private Long pkId;

	/**
	 * ip地址
	 */
	private String ip;

	/**
	 * 端口
	 */
	private Integer rpcPort;

	/**
	 * 块高
	 */
	private Integer blockHeight;

	/**
	 * 是否存活
	 */
	private Boolean active;
	
	private Integer nodeId;
	
	private String  blockChainType;
}
