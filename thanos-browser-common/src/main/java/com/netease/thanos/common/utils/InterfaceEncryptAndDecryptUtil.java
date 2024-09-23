package com.netease.thanos.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;

/**
 * 对外接口API加解密工具类
 *
 * @author hzwengcheng 2018-05-03 16:52
 */
public class InterfaceEncryptAndDecryptUtil {

    /**
     * 利用公钥进行加密
     *
     * @param params    需要加密的参数，不包含"sign"参数
     * @param publicKey RSA公钥
     * @return 加密后的字符串
     */
    public static String encrypt(Map<String, String> params, String publicKey) throws Exception {

        if (StringUtils.isBlank(publicKey)) {
            throw new IllegalArgumentException("String publicKey 非法参数");
        }

        if (params == null || params.size() == 0) {
            throw new IllegalArgumentException("Map<String, String> params 非法参数");
        }

        // 1. 参数名按照ASCII码表升序排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 2. 按照排序拼接参数名与参数值
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append("=").append(params.get(key) == null ? "" : params.get(key)).append("&");
        }

        // 2.1 删除最后一个 "&"
        sb.deleteCharAt(sb.length() - 1);

        /*
            3、使用RSA加密方式用分配的appSecret对第2步生成的密钥进行加密
            4、针对加密后的字符串经过Base64编码
         */
        return RSAUtil.encryptByPubKey(sb.toString(), publicKey);
    }


    /**
     * 利用私钥进行解密
     *
     * @param encryptedStr 加密后的字符串
     * @param privateKey   RSA私钥
     * @return 解密后参数的json格式
     */
    public static String decrypt(String encryptedStr, String privateKey) throws Exception {

        if (StringUtils.isBlank(encryptedStr)) {
            throw new IllegalArgumentException("String encryptedStr 非法参数");
        }

        if (StringUtils.isBlank(privateKey)) {
            throw new IllegalArgumentException("String privateKey 非法参数");
        }

        byte[] bytes = RSAUtil.decryptByPriKey(encryptedStr, privateKey);
        String decryptStr = new String(bytes);
        String[] split = decryptStr.split("&");

        JSONObject jsonObject = new JSONObject();
        for (String str : split) {
            String[] split1 = str.split("=");
            jsonObject.put(split1[0], split1[1]);
        }

        return JSONObject.toJSONString(jsonObject);
    }
}