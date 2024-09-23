package com.netease.thanos.common.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date toDateStart(String strDate) {
        strDate += " 00:00:01";
        return strToDate(strDate);
    }

    public static Date toDateEnd(String strDate) {
        strDate += " 23:59:59";
        return strToDate(strDate);
    }

}
