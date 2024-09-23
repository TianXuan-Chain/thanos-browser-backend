package com.netease.thanos.core.depositChain.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author lyy create on 2018-05-12
 */
public class PartitionKeyUtil {

    public static Long getPartitionKey(Date date) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String test = df.format(date);
        return Long.parseLong(test);
    }

    public static void main(String[]  args) {
        System.out.println(getPartitionKey(new Timestamp(1666627200000L)));
    }
}
