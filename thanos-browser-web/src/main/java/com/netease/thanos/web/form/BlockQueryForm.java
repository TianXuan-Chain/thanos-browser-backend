package com.netease.thanos.web.form;

import lombok.Data;

/**
 * 查询区块信息
 * 
 * @author hzshujun
 *
 */

@Data
public class BlockQueryForm {
	/**
	 * 查询的区块 该参数不过空，优先查指定的区块
	 * 
	 */
	private Long blockNumber;
	/**
	 * 查询的区块数量
	 */
	private Integer limitNum;

}
