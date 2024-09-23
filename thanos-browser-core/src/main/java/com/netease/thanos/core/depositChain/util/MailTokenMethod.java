package com.netease.thanos.core.depositChain.util;


import com.thanos.web3j.abi.TypeReference;
import com.thanos.web3j.abi.datatypes.Function;
import com.thanos.web3j.abi.datatypes.Type;
import com.thanos.web3j.abi.datatypes.Utf8String;
import com.thanos.web3j.abi.datatypes.generated.Uint256;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 类 MailTokenMethod 的实现描述:
 * Created by wangting04 on 2020/08/03
 */
public class MailTokenMethod {

    public static Function getStoreFunc() {
        return new Function("store",
                Arrays.<Type>asList(new Utf8String("0"), new Utf8String("0"), new Utf8String("0"), new Uint256(1l), new Utf8String("0")),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                                                }, new TypeReference<Utf8String>() {
                                                }, new TypeReference<Utf8String>() {
                                                },
                        new TypeReference<Uint256>() {
                        }, new TypeReference<Utf8String>() {
                        }));
    }

    public static String getStoreSign() {
        return MethodAndParamAnalyze.buildMethodSign(getStoreFunc().getName(), getStoreFunc().getInputParameters());
    }

    public static List<Type> getTransferValTypeList(String val) {
        if (StringUtils.isEmpty(val) || val.length() < 11) {
            return Collections.EMPTY_LIST;
        }


        return MethodAndParamAnalyze.getTypeList(getStoreFunc(), val.substring(10));
    }

    public static void main(String[] args) {

        System.out.println("method sign: " + getStoreSign()); //0xee5c0df1

        List<Type> typeList = getTransferValTypeList("0xee5c0df100000000000000000000000000000000000000000000000000000000000000a000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000160000000000000000000000000000000000000000000000000000000000006320800000000000000000000000000000000000000000000000000000000000001c0000000000000000000000000000000000000000000000000000000000000003c3836343266316266353163356330383238666230643239633635656439353762366364626436343730393933393531663834373261303377717771770000000000000000000000000000000000000000000000000000000000000000000000403635326139386561656333383235613534396363303738363863353439626633646463346139666566623031353738316336626433386363376230646565636400000000000000000000000000000000000000000000000000000000000000403731336333356434653765343030653164653431386533383138363061623063313064373461326561646230383831303238646663386563626631303163613600000000000000000000000000000000000000000000000000000000000000146e697975656c696e31393930403136332e636f6d000000000000000000000000");
        //typeList.get(0).toString()为 邮件识别码
        System.out.println(typeList.get(0).toString());
        System.out.println(typeList.get(1).toString());
        System.out.println(typeList.get(2).toString());
        System.out.println(typeList.get(3).toString());
        System.out.println(typeList.get(3).toString());

    }
}
