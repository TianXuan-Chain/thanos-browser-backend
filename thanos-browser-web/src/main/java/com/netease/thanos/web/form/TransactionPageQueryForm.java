package com.netease.thanos.web.form;

import lombok.Data;

/**
 * 类TransactionPageQueryForm.java的实现描述：
 *
 * @author xuhao create on 2021/2/2 16:56
 */

@Data
public class TransactionPageQueryForm extends PageQueryForm{
    /**
     * 交易所属区块号
     */
    private Long blockNumber;

    /**
     * 通过合约查询
     */
    private String contractAddress;
}
