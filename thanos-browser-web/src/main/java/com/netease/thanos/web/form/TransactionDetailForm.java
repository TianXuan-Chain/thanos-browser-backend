package com.netease.thanos.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailForm {
    /**
     * 交易hash
     */
    String pkHash;

    /**
     * 交易所属区块的时间戳
     */
    Date blockTimestamp;
}
