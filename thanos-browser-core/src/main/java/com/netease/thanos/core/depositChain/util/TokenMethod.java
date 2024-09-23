package com.netease.thanos.core.depositChain.util;

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
 * Created by dumaobing on 2018/6/3
 */
public class TokenMethod {

    public static Function getTransferFunc() {
        return new Function("transfer",
                Arrays.<Type>asList(new Address("0"), new Uint256(1l), new Utf8String("0"), new Utf8String("0")),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {},
                        new TypeReference<Utf8String>() {}));
    }

    public static String getTransferSign(){
        return MethodAndParamAnalyze.buildMethodSign(getTransferFunc().getName(), getTransferFunc().getInputParameters());
    }

    public static List<Type> getTransferValTypeList(String val){
        if (StringUtils.isEmpty(val) || val.length() < 11) {
            return Collections.EMPTY_LIST;
        }



        return MethodAndParamAnalyze.getTypeList(getTransferFunc(), val.substring(10));
    }

    public static void main(String[] args) {

        System.out.println("method sign: " + getTransferSign());

        List<Type> typeList = getTransferValTypeList("0xe9c028150000000000000000000000003fbb475d0683de6e63f7d893d9bad1c8d3a1126f0000000000000000000000000000000000000000000000000000000077359400000000000000000000000000000000000000000000000000000000000000008000000000000000000000000000000000000000000000000000000000000000c000000000000000000000000000000000000000000000000000000000000000206439653939623863616636303431326538646339396637643031303964626662000000000000000000000000000000000000000000000000000000000000000c3230313830383138323031370000000000000000000000000000000000000000");
        System.out.println(new Address(typeList.get(0).toString()));
        System.out.println(typeList.get(1).getValue());
        System.out.println(typeList.get(2).toString());
        System.out.println(typeList.get(3).toString());
    }

}
