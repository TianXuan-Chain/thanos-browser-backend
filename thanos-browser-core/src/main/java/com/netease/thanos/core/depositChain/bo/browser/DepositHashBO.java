package com.netease.thanos.core.depositChain.bo.browser;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: TransferBO
 * @Description:
 * @Author: Ravintich
 * @Date: 2022-07-25 16:27
 */
@Data
public class DepositHashBO {
    /**
     *存证点序列好
     */
    String serialNumber;
    /**
     * 存证链id
     */
    String objectId;
    /**
     * 存证数据hash
     */
    String paramDataHash;
    /**
     * 存证文件hash
     */
    List<String> partFilesHash;
}
