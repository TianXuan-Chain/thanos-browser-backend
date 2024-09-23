package com.netease.thanos.core.depositChain.constant;

/**
 * 类GlobalSearchType.java的实现描述：全局查询常量
 *
 * @author xuhao create on 2021/2/4 10:03
 */

public class GlobalSearchConstant {

    /**
     * 查询参数类型
     */
    public static class SearchKeyType {
        /**
         * 按pkHash查询
         */
        public static String TYPE_PKHASH = "pkHash";
        /**
         * 按bcAddress查询
         */
        public static String TYPE_BCADDRESS = "bcAddress";
        /**
         * 按块高查询区块
         */
        public static String TYPE_BLOCK_NUMBER = "blockNumber";

        /**
         * 按合约查询交易
         */
        public static String TYPE_CONTRACT_ADDRESS= "contractAddress";
    }

    /**
     * 查询结果类型
     */
    public static class SearchResultType {
        /**
         * 查询结果为交易
         */
        public static int TYPE_TRANSACTION = 1;

        /**
         * 查询结果为区块
         */
        public static int TYPE_BLOCK = 2;

        /**
         * 查询结果为合约
         */
        public static int TYPE_CONTRACT = 3;

    }
}
