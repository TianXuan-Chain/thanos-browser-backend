package com.netease.thanos.core.depositChain.util;

import com.thanos.web3j.abi.FunctionReturnDecoder;
import com.thanos.web3j.abi.datatypes.Function;
import com.thanos.web3j.abi.datatypes.Type;
import com.thanos.web3j.crypto.Hash;
import com.thanos.web3j.utils.Numeric;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dumaobing on 2018/6/3
 */
public class MethodAndParamAnalyze {

    /**
     * 反编译为java对象
     * @param func
     * @param val
     * @return
     */
    public static List<Type> getTypeList(Function func, String val){
        return FunctionReturnDecoder.decode(val, func.getOutputParameters());
    }

    private static String buildMethodSignature(String methodName, List<Type> parameters) {
        StringBuilder result = new StringBuilder();
        result.append(methodName);
        result.append("(");
        String params = parameters.stream()
                .map(Type::getTypeAsString)
                .collect(Collectors.joining(","));
        result.append(params);
        result.append(")");
        return result.toString();
    }

    public static String buildMethodSign(String methodName, List<Type> parameters) {
        String methodSignature = buildMethodSignature(methodName, parameters);
        byte[] input = methodSignature.getBytes();
        byte[] hash = Hash.sha3(input);
        return Numeric.toHexString(hash).substring(0, 10);
    }

}
