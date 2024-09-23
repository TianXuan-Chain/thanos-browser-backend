package com.netease.thanos.api.dto.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Author kingkong create on 2018-08-28
 */

@Getter
@Setter
public class DepositChainBlockAggreRootDTO implements Serializable {

    private DepositChainBlockChainDTO depositChainBlockChainDTO;

    private DepositChainBlockDTO depositChainBlockDTO;

    private List<DepositChainTransactionDTO> depositChainTransactionDTOS;

    private List<DepositChainTransactionReceiptDTO> depositChainTransactionReceiptDTOS;

    private Long txnIncr;
}

