package com.netease.thanos.core.depositChain.bo;

import lombok.Data;

import java.util.List;

@Data
public class NvFileDepositBo {

    private String uniqueNumber;

    private String jsonStr;

    private String remark;

    private List<File> fileList;

    @Data
    public static class File {

        /**
         * 文件统一证据编号
         */
        private String uniqueNumber;

        /**
         * 文件名
         */
        private String fileName;

        /**
         * 文件hash
         */
        private String fileHash;

    }

}
