package com.netease.thanos.common.enums;

import org.apache.commons.lang3.StringUtils;


/**
 * 类DatabaseConst.java的实现描述：TODO 类实现描述
 *
 * @author hzcaochongrui 2018年1月29日 上午11:30:56
 */
public final class DatabaseConst {

    public static final String DEFAULT_ORDER_BY = StringUtils.join(Field.CREATE_TIME, " ", OrderBy.DESC); // 默认数据库sql排序
    public static final String DEFAULT_ORDER_BY_CREATE_TIME_ASC = StringUtils.join(Field.CREATE_TIME, " ", OrderBy.ASC); // 默认数据库sql排序

    //勋章倒序排列
    public static final String COIN_ORDER_BY = StringUtils.join(Field.COIN, " ", OrderBy.DESC); // 勋章倒序排列
    //勋章+虚拟勋章倒序排列
    public static final String COIN_AND_VIR_ORDER_BY = StringUtils.join(Field.COIN_AND_VIR, " ", OrderBy.DESC); // 勋章倒序排列


    /**
     * 类DatabaseConst.java的实现描述：数据库字段静态常量
     *
     * @author jared Mar 17, 2016 10:00:32 AM
     */
    public final class Field {

        public static final String CREATE_TIME = "create_time";
        public static final String COIN = "coin";
        public static final String COIN_AND_VIR = "coin,vir_coin";
    }

    public final class OrderBy {

        public static final String DESC = "desc";
        public static final String ASC = "asc";
    }
}
