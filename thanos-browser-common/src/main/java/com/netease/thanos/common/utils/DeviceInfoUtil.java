/**
 *
 */
package com.netease.thanos.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * @author hzzhanglei
 * @Title DeviceInfoUtil.java
 * @Package com.netease.epay.common.util
 * @Description 设备信息处理工具类
 * @date Jan 19, 2017
 */
public class DeviceInfoUtil {
    private static Log log = LogFactory.getLog(DeviceInfoUtil.class);

    private static PrivateKey getPrivateKey(String privateKey) throws Exception {
        //		byte[] keyBytes = Base64.decode(private_key, Base64.DEFAULT);
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKeyObj = keyFactory.generatePrivate(keySpec);
        return privateKeyObj;
    }

    /**
     * @param endata
     * @return
     */
    private static byte[] rsa_decyprt(byte[] endata, String privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            PrivateKey privateKeyObj = getPrivateKey(privateKey);
            cipher.init(Cipher.DECRYPT_MODE, privateKeyObj);
            byte[] deBytes = cipher.doFinal(endata);
            return deBytes;
        } catch (Exception e) {
            log.error("rsa_decyprt error", e);
        }
        return null;
    }

    /**
     * iOS的
     *
     * @param endata
     * @return
     */
    private static byte[] rsa_decyprt_nopadding(byte[] endata, String privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            PrivateKey privateKeyObj = getPrivateKey(privateKey);
            cipher.init(Cipher.DECRYPT_MODE, privateKeyObj);
            byte[] deBytes = cipher.doFinal(endata);
            return deBytes;
        } catch (Exception e) {
            log.error("rsa_decyprt error", e);
        }
        return null;
    }

    protected static String decodeByClientType(ClientDeviceType clientType, String fingerprint, String privateKey) {
        if (StringUtils.isBlank(fingerprint)) {
            return null;
        }
        if (clientType == ClientDeviceType.ANDROID || clientType == ClientDeviceType.IOS) {
            JSONObject obj = JSONObject.parseObject(fingerprint);
            String rk = obj.getString("rk");
            String rdata = obj.getString("rdata");

            rk = StringUtils.replace(rk, " ", "+");
            rdata = StringUtils.replace(rdata, " ", "+");

            if (StringUtils.isNotBlank(rk) && StringUtils.isNotBlank(rdata)) {
                String decode_fingerprint = decodeOnMobile(clientType, rk, rdata, privateKey);
                return decode_fingerprint;
            }
        }
        return null;
    }

    /**
     * android/ios decode
     *
     * @param rk
     * @param rdata
     * @return
     */
    protected static String decodeOnMobile(ClientDeviceType clientType, String rk, String rdata, String privateKey) {
        try {
            byte[] bytes = null;
            if (clientType == ClientDeviceType.IOS) {
                bytes = rsa_decyprt_nopadding(Base64.decodeBase64(rk.getBytes()), privateKey);
            } else {
                bytes = rsa_decyprt(Base64.decodeBase64(rk.getBytes()), privateKey);
            }
            byte[] aes_bytes = new byte[16];
            System.arraycopy(bytes, 0, aes_bytes, 0, 16);

            Key aesKey = new SecretKeySpec(aes_bytes, "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decValue = c.doFinal(Base64.decodeBase64(rdata.getBytes()));
            String decryptedValue = new String(decValue);
            return decryptedValue;
        } catch (Exception e) {
            log.error("rsa_decyprt error", e);
        }
        return null;
    }

    protected static enum ClientDeviceType {
        IOS, ANDROID;
    }

}
