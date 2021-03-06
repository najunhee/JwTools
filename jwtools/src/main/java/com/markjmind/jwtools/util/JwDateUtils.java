package com.markjmind.jwtools.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author 오재웅(JaeWoong-Oh)
 * @email markjmind@gmail.com
 * @since 2015-12-29
 */
public class JwDateUtils {

    public static String getFormat(Date date,  String format, Locale locale)
    {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, locale);
        return formatter.format(date);
    }

    public static String getFormat(Date date,  String format)
    {
        return JwDateUtils.getFormat(date, format, Locale.KOREA);
    }

    public static int betweenSec(Date from, Date to){
        long duration = from.getTime() - to.getTime();
        return (int) (duration / (1000));
    }

    public static int betweenMin(Date from, Date to){
        long duration = from.getTime() - to.getTime();
        return (int) (duration / (1000 * 60));
    }

    public static int betweenHour(Date from, Date to){
        long duration = from.getTime() - to.getTime();
        return (int) (duration / (1000 * 60 * 60));
    }

    public static int betweenDay(Date from, Date to){
        long duration = from.getTime() - to.getTime();
        return (int) (duration / (1000 * 60 * 60 *24));
    }

    public static int betweenMonth(Date from, Date to){
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", java.util.Locale.KOREA);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", java.util.Locale.KOREA);
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", java.util.Locale.KOREA);

        int fromYear = Integer.parseInt(yearFormat.format(from));
        int toYear = Integer.parseInt(yearFormat.format(to));
        int fromMonth = Integer.parseInt(monthFormat.format(from));
        int toMonth = Integer.parseInt(monthFormat.format(to));
        int fromDay = Integer.parseInt(dayFormat.format(from));
        int toDay = Integer.parseInt(dayFormat.format(to));

        int result = 0;
        result += ((toYear - fromYear) * 12);
        result += (toMonth - fromMonth);

        //        if (((toDay - fromDay) < 0) ) result += fromDate.compareTo(toDate);
        // ceil과 floor의 효과
        if (((toDay - fromDay) > 0))
            result += to.compareTo(from);

        return result;
    }

    public static int betweenYear(Date from, Date to){
        long duration = from.getTime() - to.getTime();
        return (int) (duration / (1000 * 60 * 60 * 24 * 356));
    }

    public static boolean equalsSec(Date a, Date b){
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyyMMddhhMMss", java.util.Locale.KOREA);
        return yearFormat.format(a).equals(yearFormat.format(b));
    }

    public static boolean equalsMin(Date a, Date b){
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyyMMddhhMM", java.util.Locale.KOREA);
        return yearFormat.format(a).equals(yearFormat.format(b));
    }

    public static boolean equalsHour(Date a, Date b){
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyyMMddhh", java.util.Locale.KOREA);
        return yearFormat.format(a).equals(yearFormat.format(b));
    }

    public static boolean equalsDay(Date a, Date b){
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyyMMdd", java.util.Locale.KOREA);
        return yearFormat.format(a).equals(yearFormat.format(b));
    }

    public static boolean equalsMonth(Date a, Date b){
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyyMM", java.util.Locale.KOREA);
        return yearFormat.format(a).equals(yearFormat.format(b));
    }

    public static boolean equalsYear(Date a, Date b){
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", java.util.Locale.KOREA);
        return yearFormat.format(a).equals(yearFormat.format(b));
    }
}
