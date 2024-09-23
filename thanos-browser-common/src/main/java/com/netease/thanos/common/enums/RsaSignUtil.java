package com.netease.thanos.common.enums;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.netease.thanos.common.utils.CommonUtil;

import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RsaSignUtil {

    private static final Log log = LogFactory.getLog(RsaSignUtil.class);

    /**
     * 本方法使用SHA1withRSA签名算法产生签名
     *
     * @param priKey 签名时使用的私钥(16进制编码)
     * @param src    签名的原字符串
     * @return String 签名的返回结果(16进制编码)。当产生签名出错的时候，返回null。
     */
    public static String generateSHA1withRSASigature(String priKey, String src) {
        try {

            Signature sigEng = Signature.getInstance("SHA1withRSA");

            byte[] pribyte = CommonUtil.hexStrToBytes(priKey.trim());

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
            KeyFactory fac = KeyFactory.getInstance("RSA");

            RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
            sigEng.initSign(privateKey);
            sigEng.update(src.getBytes());

            byte[] signature = sigEng.sign();
            return CommonUtil.bytesToHexStr(signature);
        } catch (Exception e) {
            log.error("###NetEaseSignUtil:generateSHA1withRSASigature", e);
            return null;
        }
    }

    /**
     * 本方法使用SHA1withRSA签名算法产生签名（适用于支付网关）
     *
     * @param priKey 签名时使用的私钥(16进制编码)
     * @param src    签名的原字符串
     * @return String 签名的返回结果(16进制编码)。当产生签名出错的时候，返回null。
     */
    public static String generateSHA1withRSASigatureForPayGate(String priKey, String src) {
        try {

            Signature sigEng = Signature.getInstance("SHA1withRSA");

            byte[] pribyte = CommonUtil.hexStrToBytes(priKey.trim());

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
            KeyFactory fac = KeyFactory.getInstance("RSA");

            RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
            sigEng.initSign(privateKey);
            sigEng.update(src.getBytes());

            byte[] signature = sigEng.sign();
            return Base64.encodeBase64String(signature);
        } catch (Exception e) {
            log.error("###NetEaseSignUtil:generateSHA1withRSASigature", e);
            return null;
        }
    }

    /**
     * 本方法使用SHA1withRSA签名算法验证签名
     *
     * @param pubKey 验证签名时使用的公钥(16进制编码)
     * @param sign   签名结果(16进制编码)
     * @param src    签名的原字符串
     * @return String 签名的返回结果(16进制编码)
     */
    public static boolean verifySHA1withRSASigature(String pubKey, String sign, String src, String encoding) {
        try {
            Signature sigEng = Signature.getInstance("SHA1withRSA");

            byte[] pubbyte = CommonUtil.hexStrToBytes(pubKey.trim());

            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubbyte);
            KeyFactory fac = KeyFactory.getInstance("RSA");
            RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);

            sigEng.initVerify(rsaPubKey);
            sigEng.update(src.getBytes(encoding));

            byte[] sign1 = CommonUtil.hexStrToBytes(sign);
            return sigEng.verify(sign1);

        } catch (Exception e) {
            log.error("###NetEaseSignUtil:verifySHA1withRSASigature", e);
            return false;
        }
    }

    /**
     * RSA签名
     *
     * @param priKey
     * @param src
     * @return
     */
    public static String rsaSign(String priKey, String src) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(priKey));
            KeyFactory fac = KeyFactory.getInstance("RSA");
            RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
            Signature sigEng = Signature.getInstance("SHA1withRSA");
            sigEng.initSign(privateKey);
            sigEng.update(src.getBytes("UTF-8"));
            byte[] signature = sigEng.sign();
            String sign = Base64.encodeBase64String(signature);
            return sign.replaceAll("\r|\n", "");
        } catch (Exception e) {
            log.error("###NetEaseSignUtil:rsaSign", e);
            return null;
        }
    }

    /**
     * RSA验签
     *
     * @param pubKey
     * @param sign
     * @param src
     * @return
     */
    public static boolean rsaVerify(String pubKey, String sign, String src, String encoding) {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(pubKey));
            KeyFactory fac = KeyFactory.getInstance("RSA");
            RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
            Signature sigEng = Signature.getInstance("SHA1withRSA");
            sigEng.initVerify(rsaPubKey);
            sigEng.update(src.getBytes(encoding));
            byte[] signature = Base64.decodeBase64(sign);
            return sigEng.verify(signature);
        } catch (Exception e) {
            log.warn("###NetEaseSignUtil:rsaVerify", e);
            return false;
        }
    }

}
