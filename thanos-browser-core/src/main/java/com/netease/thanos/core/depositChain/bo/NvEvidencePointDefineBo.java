package com.netease.thanos.core.depositChain.bo;

import lombok.Data;

import java.util.List;

@Data
public class NvEvidencePointDefineBo {

    /**
     * 序列码
     */
    private String txDataSerialNumber;

    /**
     * 关联对象
     */
    private String txDataRelateObject;

    /**
     * 关联企业
     */
    private String txDataRelateCorporation;

    /**
     * 关联用户
     */
    private String txDataRelateUser;

    /**
     * 方法名
     */
    private String txDataFuncName;

    /**
     * 交易数据
     */
    private String txDataAllparamsHash;


    /**
     * 数据hash
     */
    private String  txDataFieldHashJsonStr;

    /**
     * 数据hash
     */
    private List<fileHash> txDataFieldHashJson;

    /**
     * 备注
     */
    private String txDataRemark;

    @Data
    public static class fileHash {

        /**
         * 文件hash字段
         */
        private String fileField;

        /**
         * 文件名
         */
        private String fileName;

        /**
         * 字段hash值
         */
        private String fileHash;

        /**
         * 是否主体文件
         */
        private Boolean mainFile;

    }

}
