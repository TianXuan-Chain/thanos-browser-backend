package com.netease.thanos.report.job.thanos;

import com.alibaba.fastjson.JSON;
import com.thanos.web3j.abi.FunctionEncoder;
import com.thanos.web3j.abi.FunctionReturnDecoder;
import com.thanos.web3j.abi.TypeReference;
import com.thanos.web3j.abi.datatypes.Address;
import com.thanos.web3j.abi.datatypes.Function;
import com.thanos.web3j.abi.datatypes.Type;
import com.thanos.web3j.abi.datatypes.Utf8String;
import com.thanos.web3j.abi.datatypes.generated.Uint256;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 类MethodAnalyzer.java的实现描述：合约方法调用分析
 *
 * @author xuhao create on 2021/2/3 10:48
 */

public class MethodAnalyzer {

    //转账方法签名hash
    public static final String TRANSFER_SIGN = "0xe9c02815";

    //邮件存储方法签名hash
    public static final String MAIL_STORE_SIGN = "0x38278cda";

    /**
     * 根据合约方法和返回值字符串，恢复返回值
     *
     * @param func
     * @param val
     * @return
     */
    public static List<Type> getTypeList(Function func, String val) {
        return FunctionReturnDecoder.decode(val, func.getOutputParameters());
    }

    public static class Token {
        /**
         * 生成标准转账方法
         *
         * @return
         */
        public static Function getTransferFunc() {
            return new Function("transfer",
                    Arrays.<Type>asList(new Address("0"), new Uint256(1l), new Utf8String("0"), new Utf8String("0")),
                    Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {},new TypeReference<Utf8String>() {})
//                    Collections.<TypeReference<?>>emptyList()
            );
        }

        /**
         * 生成标准转账方法签名
         *
         * @return
         */
        public static String getTransferSign() {
            return FunctionEncoder.buildMethodSignature(getTransferFunc().getName(), getTransferFunc().getInputParameters());
        }

        /**
         * 生成标准转账方法签名的哈希
         *
         * @return
         */
        public static String getTransferSignHash() {
            return FunctionEncoder.buildMethodId(getTransferSign());
        }

        public static List<Type> getTransferTypeList(String val) {
            if (StringUtils.isEmpty(val) || val.length() < 11) {
                return Collections.EMPTY_LIST;
            }
            return getTypeList(getTransferFunc(), val.substring(10));
        }
    }

    public static class Mail {
        /**
         * 生成标准转账方法
         *
         * @return
         */
        public static Function getStoreFunc() {
            return new Function(
                    "store", Arrays.<Type>asList(new Utf8String("0"), new Utf8String("0"), new Utf8String("0"), new Utf8String("0")),
//                    Collections.<TypeReference<?>>emptyList()
                    Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {},new TypeReference<Utf8String>() {})

            );
        }

        /**
         * 生成标准转账方法签名
         *
         * @return
         */
        public static String getStoreSign() {
            return FunctionEncoder.buildMethodSignature(getStoreFunc().getName(), getStoreFunc().getInputParameters());
        }

        /**
         * 生成标准转账方法签名的哈希
         *
         * @return
         */
        public static String getStoreSignHash() {
            return FunctionEncoder.buildMethodId(getStoreSign());
        }

        public static List<Type> getStoreTypeList(String val) {
            if (StringUtils.isEmpty(val) || val.length() < 11) {
                return Collections.EMPTY_LIST;
            }
            return getTypeList(getStoreFunc(), val.substring(10));
        }
    }

    public static void main(String[] args) {

        System.out.println("transfer method sign: " + Token.getTransferSign());
        System.out.println("transfer method signHash: " + Token.getTransferSignHash());
        List<Type> typeList = Token.getTransferTypeList("0xe9c028150000000000000000000000009debae1ad8355cac36a093cf9a0a329d879d9205000000000000000000000000000000000000000000000000000000012a05f200000000000000000000000000000000000000000000000000000000000000008000000000000000000000000000000000000000000000000000000000000000c0000000000000000000000000000000000000000000000000000000000000000a45544637634e4a7668790000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000083230323031323136000000000000000000000000000000000000000000000000");
        System.out.println("transfer method param[to]: " + new Address(typeList.get(0).toString()));
        System.out.println("transfer method param[coin]: " + typeList.get(1).getValue());
        System.out.println("transfer method param[traceId]: " + typeList.get(2).toString());
        System.out.println("transfer method param[realtime]:" + typeList.get(3).toString());
        System.out.println(JSON.toJSONString(typeList));

        System.out.println("store method sign: " + Mail.getStoreSign());
        System.out.println("store method signHash: " + Mail.getStoreSignHash());
        List<Type> typeList2 = Mail.getStoreTypeList("0x38278cda000000000000000000000000000000000000000000000000000000000000008000000000000000000000000000000000000000000000000000000000000000c00000000000000000000000000000000000000000000000000000000000000120000000000000000000000000000000000000000000000000000000000000018000000000000000000000000000000000000000000000000000000000000000023834000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002b46696e6765727072696e747a514d4755794435584864384c6e533957486c5a6d63717252337271714333460000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000024486173687a514d4755794435584864384c6e533957486c5a6d637172523372717143334600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002736342c757365727a514d4755794435584864384c6e533957486c5a6d637172523372717143334600000000000000000000000000000000000000000000000000");
        System.out.println("store method param[_emailNumber]: " + new Address(typeList2.get(0).toString()));
        System.out.println("store method param[_emailFingerprint]: " + typeList2.get(1).getValue());
        System.out.println("store method param[_emailHash]: " + typeList2.get(2).toString());
        System.out.println("store method param[_extendInfo]:" + typeList2.get(3).toString());
        System.out.println(JSON.toJSONString(typeList2));
    }
}
