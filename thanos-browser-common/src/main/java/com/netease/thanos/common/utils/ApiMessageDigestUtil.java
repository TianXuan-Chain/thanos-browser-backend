package com.netease.thanos.common.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.bouncycastle.util.encoders.Hex;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by wangting04 on 2018/07/17
 */
public class ApiMessageDigestUtil {


    /**
     * 生成appSign规则
     *
     * @param parmArr   第一层级参数数组,即map内所有参数的集合
     * @param appKey    key
     * @param appSecret secret
     * @return
     */
    public static String shaHex(String[] parmArr, String appKey, String appSecret) {

        String[] arr = ArrayUtils.addAll(parmArr, appKey, appSecret);

        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        try {
            return Hex.toHexString(AppSecretUtil.encryptSH1(sb.toString().getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * appSign 校验
     *
     * @param parmArr   第一场级参数数组,即map内所有参数的集合
     * @param appKey    key
     * @param appSecret secret
     * @param appSign   appSign
     * @returncontract_game_001
     */
    public static boolean validate(String[] parmArr, String appKey, String appSecret, String appSign) {
        String expectedSignature = shaHex(parmArr, appKey, appSecret);
        if (expectedSignature.equals(appSign.toLowerCase())) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
//        String[] parmArr = {"aqw", "1531569639"};
//        String[] parmArr = {"aasassss", "2", "1531569639"};
//        String[] parmArr = {"[{\"userBIzID\": \"as\"}, {\"userBIzID\": \"adew\"}]","1531569639"};
//        String[] parmArr = {"nb001", "20180720", "1531569639"};
        String[] parmArr = {"[{\"tnxSerialNum\": \"0000000000000110000200003EC7515B\"}]", "1531569639"};
        String appKey = "b5f1ecdd16e04fd1cba11740e8d7c0d9";
        String appSecret = "d2f18f883773fab47734e87f7be714f116a6e63e";
        String expectedSignature = shaHex(parmArr, appKey, appSecret);
        System.out.println(expectedSignature);
        System.out.println(expectedSignature.length());
        System.out.println(validate(parmArr, appKey, appSecret, expectedSignature.toUpperCase()));
    }
}
