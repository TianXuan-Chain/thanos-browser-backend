package com.netease.thanos.common.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hzxuyankang on 2017/4/7.
 */
public class TimeUtil {

    public static Date now() {
        return new Date();
    }


    public static String date2String(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        return format.format(date);
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime toLocalDatetime(Date date) {
        return date == null ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDate toLocalDate(Date date) {
        return date == null ? null : toLocalDatetime(date).toLocalDate();
    }

    public static Date addDate(Date date, int dayOffset) {
        LocalDateTime localDateTime = toLocalDatetime(date);
        return toDate(localDateTime.plusDays(dayOffset));
    }

    public static LocalDate clearDay(LocalDate localDate) {
        return localDate.withDayOfMonth(0);
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.from(localDateTime.atOffset(ZoneOffset.ofHours(8)).toInstant());
    }

    public static Date toDate(LocalDate localDate) {
        return localDate == null ? null : Date.from(localDate.atStartOfDay().atOffset(ZoneOffset.ofHours(8)).toInstant());
    }

    public static String getBillMonth(LocalDate localdate) {
        return localdate.format(DateTimeFormatter.ofPattern("yyyyMM"));
    }


    public static String plusMonth(String yyyyMM) {
        yyyyMM += "01";
        LocalDate month = LocalDate.parse(yyyyMM, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return getBillMonth(month.plusMonths(1L));
    }

    public static LocalDate firstDayOfMonth(String yyyyMM) {
        yyyyMM += "01";
        return LocalDate.parse(yyyyMM, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static LocalDate stringToLocalDate(String text) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        return parsedDate;
    }

    public static int stringToLocalDate(Date date1, Date date2) {
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(date1);
        aft.setTime(date2);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result);
    }

    /**
     * @param date
     * @param day  想要获取的日期与传入日期的差值 比如想要获取传入日期前四天的日期 day=-4即可
     * @return
     */
    public static Date getSomeDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }


}
