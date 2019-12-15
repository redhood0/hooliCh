package com.redhood.hoolicalendar.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cky
 * date 2019-12-14
 */
public class MyDateFormat {
    //将时间转换为时间戳
    public static String dateToStamp(String s) throws Exception {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long time = date.getTime();
        res = String.valueOf(time);
        return res;
    }
    //将时间戳转换为时间
    public static String stampToTime(String s) throws Exception{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
