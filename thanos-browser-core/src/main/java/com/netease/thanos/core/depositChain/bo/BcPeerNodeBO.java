package com.netease.thanos.core.depositChain.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author kingkong create on 2018-08-28
 * node rpc information
 *
 */
 
@Getter
@Setter
public class BcPeerNodeBO {

	private Long pkId;

	private String ip;

	private Integer rpcPort;

	private Integer blockHeight;

	private Boolean active;
}
