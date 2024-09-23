package com.netease.thanos.core.depositChain.crypto;

import org.bouncycastle.util.encoders.Hex;

import com.netease.thanos.core.depositChain.crypto.jre.SpongyCastleProvider;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * 类HashUtil.java 的实现描述:
 * Created by wangting04 on 2018/09/25
 */
public class HashUtil {
    //SHA3 系列
    private static final String KEY_ETH_KECCAK_256 = "ETH-KECCAK-256";
    private static final String KEY_ETH_KECCAK_512 = "ETH-KECCAK-512";

    static {
        Security.addProvider(SpongyCastleProvider.getInstance());
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    public static String eccSha256(String strSrc) {
        MessageDigest md;
        String strDes;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance(KEY_ETH_KECCAK_256);
            md.update(bt);
            strDes = Hex.toHexString(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            System.out.println("摘要加密失败！" + e.toString());
            return null;
        }
        return strDes;
    }

    public static String eccSha256With0x(String strSrc) {
        return "0x" + eccSha256(strSrc);
    }

    public static String eccSha256Block(String pkHash, String inputStr, int batchNum) {
        String strSrc = pkHash + inputStr + batchNum;
        return "0x" + eccSha256(strSrc);
    }


    public static void main(String[] args) {
        String inputStr = "H13565";
        String ss = eccSha256(inputStr);
        System.out.println(ss);
        BigInteger bigInteger = new BigInteger(ss,16);
        System.out.println(bigInteger);
    }
}
