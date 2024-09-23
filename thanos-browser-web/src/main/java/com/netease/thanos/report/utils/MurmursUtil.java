package com.netease.thanos.report.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 类MurmursUtil.java 的实现描述:
 * Created by wangting04 on 2018/08/10
 */
public class MurmursUtil {

    /**
     * murmur hash算法实现
     */
    public static Long hash(byte[] key) {

        ByteBuffer buf = ByteBuffer.wrap(key);
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                    ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return h;
    }

    public static Long hash(String key) {
        return hash(key.getBytes());
    }


    /**
     * 获取当前块在第几个矿区
     * @param key
     * @param numCount
     * @return
     */
    public static int typeCode(String key, int numCount){
        Long l = hash(key);
        if(l<0){
            l = -l;
        }
        return (int) (l%numCount+1);
    }

    public static void main(String[] args) {
        System.out.println(typeCode("0xb6a8a01da499ad1e7c23048a0559f4d0c3810f2a16ac88cf8d2131885a445343ab", 4));
    }
}
