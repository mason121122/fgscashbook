package com.fgs.fgscashbook.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Evan Gui on 2018/8/9.
 * 时间工具类
 */
public class DateUtils {

    protected static Logger logger = LoggerFactory.getLogger("COMMON.LOG");

    public final static String DATE_YYYY_MM_DD = "yyyy-MM-dd";

    public final static String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 判断日期格式是否有效
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static boolean isValidDate(String dateStr, String format) {

        if (StringUtils.isBlank(dateStr)) {
            return false;
        }

        if (StringUtils.isBlank(format)) {
            format = DATE_YYYY_MM_DD_HH_MM_SS;
        }

        boolean isValid = true;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(dateStr.trim());
        } catch (Exception e) {
            // 格式不正确
            isValid = false;
        }
        return isValid;
    }

    public static Date getDateZeroTime(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static String getCurrentTime(String format) {
        if (StringUtils.isBlank(format)) {
            format = DATE_YYYY_MM_DD_HH_MM_SS;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

    public static Date getCurrentDate() {
        Calendar date = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_YYYY_MM_DD_HH_MM_SS);
        dateFormat.setCalendar(date);
        return dateFormat.getCalendar().getTime();
    }

    /**
     * 将日期字符串按照指定格式转换成Date类型
     *
     * @param date   String
     * @param format String
     * @return Date
     */
    public static Date strToDate(String date, String format) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        if (StringUtils.isBlank(format)) {
            format = DATE_YYYY_MM_DD;
        }

        Date result = null;
        try {
            result = new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            logger.error("时间格式不正确，date={}, format={}，失败原因={}.", date, format, e.getMessage());
        }
        return result;
    }

    /**
     * 快速获取通项Date类型
     * 兼容格式 yyyy-mm-dd, yyyy-mm-ddTHH:MM:SS, yyyy-mm-dd HH:MM:SS
     *
     * @param date   String
     * @return Date
     */
    public static Date fastToDate(String date) {
        if (StringUtils.isBlank(date) || date.length() < 10) {
            return null;
        }
        // yyyy-mm-dd
        if (date.length() == 10) {
            return strToDate(date, DATE_YYYY_MM_DD);
        }
        // yyyy-mm-ddTHH:MM:SS
        if (date.charAt(10) == 'T') {
            return new DateTime(date).toDate();
        }
        // yyyy-mm-dd HH:MM:ss
        return strToDate(date, DATE_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 将日期类型按照指定格式转换成String
     *
     * @param date
     * @param format
     * @return
     */
    public static String getDateStr(Date date, String format) {
        if (date == null) {
            return "";
        }
        if (StringUtils.isBlank(format)) {
            format = DATE_YYYY_MM_DD_HH_MM_SS;
        }
        return new SimpleDateFormat(format).format(date);
    }

    public static String getDateStr(Long date, String format) {

        if (StringUtils.isBlank(format)) {
            format = DATE_YYYY_MM_DD_HH_MM_SS;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 在指定日期的基础上添加n小时，返回添加后的日期
     *
     * @param date
     * @param n
     * @return
     */
    public static Date addHours(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, n);
        return c.getTime();
    }

    /**
     * 在指定日期的基础上添加n天，返回添加后的日期
     *
     * @param date
     * @param n
     * @return
     */
    public static Date addDays(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, n);
        return c.getTime();
    }

    /**
     * 判断time时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param time      当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static boolean isEffectiveDate(Date time, Date startTime, Date endTime) {

        if (time == null || startTime == null || endTime == null) {
            return false;

        }
        if (time.after(startTime) && time.before(endTime)) {
            return true;
        }
        return (time.getTime() == startTime.getTime() || time.getTime() == endTime.getTime());
    }

    /**
     * 获取两个日期间的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getBetweenDate(Date startDate, Date endDate) {
        long startDateTime = startDate.getTime();
        long endDateTime = endDate.getTime();
        long dayTime = 86400000L;
        long days = (endDateTime - startDateTime) / dayTime;
        return days;
    }

    /**
     * 获取当前日期是星期几
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static int getWeekOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        return day_of_week;
    }

    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取n天前00:00:00对应的时间
     *
     * @param n
     * @return
     */
    public static Date getBeforeDayStartTime(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        return calendar.getTime();
    }

    /**
     * 获取n天前23:59:59对应的时间
     *
     * @param n
     * @return
     */
    public static Date getBeforeDayEndTime(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        return calendar.getTime();
    }

    /**
     * 获取指定日期的下n个天数的h点
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextDayTime(Date date, int n, int h) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, n);
        c.set(Calendar.HOUR_OF_DAY, h);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定日期的下n个天数的h点，m分，s秒
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextDayTime(Date date, int n, int h, int m, int s) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, n);
        c.set(Calendar.HOUR_OF_DAY, h);
        c.set(Calendar.MINUTE, m);
        c.set(Calendar.SECOND, s);
        return c.getTime();
    }

    /**
     * 获取指定日期的下m分钟的时间点
     *
     * @param date
     * @param m
     * @return
     */
    public static Date getNextMinuteTime(Date date, int m) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, m);
        return c.getTime();
    }

    /**
     * 清零毫秒数
     *
     * @param date
     * @return
     */
    public static Date clearByMilliSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定日期的最后一秒时间（23：59：59）
     *
     * @param date
     * @return
     */
    public static Date getEndOfDateTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

}
