package com.netease.thanos.common.utils;

import org.slf4j.MDC;

public class MDCUtil {

    public static final String TRACE_ID = "TRACE_ID";

    public static void put(Type type,String value) {
        MDC.put(type.name(),value);
    }

    public static String get(Type type) {
        return MDC.get(type.name());
    }

    public static void remove(Type type) {
        MDC.remove(type.name());
    }

    public static void clear() {
        MDC.clear();
    }

    public enum Type {
        TRACE_ID("跟踪号"),TRANS_ID("订单号");
        private String desc;

        Type(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }
}