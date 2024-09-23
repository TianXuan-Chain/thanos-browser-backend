package com.netease.thanos.core.depositChain.util;


import java.util.GregorianCalendar;

import com.netease.thanos.common.utils.DateUtil;

public class PartionkeyUtil {

    public static Integer buildPartionKey(){
        GregorianCalendar calendar  = new GregorianCalendar();
        return Integer.valueOf(DateUtil.formatDate(calendar.getTime(), DateUtil.FMT_DATE_SPECIAL));
    }

}
