package com.zym.chapter06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhaoyimeng on 15/11/23.
 */
public class DateTime {

    public static void test_1(){
        //获取自1900-01-01 00:00:00 000到当前时间
        long now = System.currentTimeMillis();
        System.out.println("\n---------------->时间类型:");
        System.out.println(now);

        System.out.println("\n---------------->Date类型:");
        Date nowTime =  new Date();
        System.out.println("当前时间: " + nowTime);

        /**
         * 日期格式：
         *   y  年
         *   M  月
         *   d  日
         *   H  时
         *   m  分
         *   s  秒
         *   S  毫秒
         */
        //1. 创建格式化对象
        SimpleDateFormat simpleDF = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");

        //2. 开始格式化
        String str = simpleDF.format(nowTime);
        System.out.println("日期格式化: " + str);

        /**
         * 获取特定日期
         */
        String str2 = "2008年08月08日 08:08:08 888";
        try {
            Date dt = simpleDF.parse(str2);
            System.out.println("日期格式化: " + dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取当前系统时间的日历
     */
    public static void test_2(){

        System.out.println("\n---------------->日历类型:");
        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int week  = calendar.get(Calendar.DAY_OF_WEEK);
        int month  = calendar.get(Calendar.MONTH) + 1;//月份从0开始，所以要+1
        int year   = calendar.get(Calendar.YEAR);

        System.out.println("day   = " + day);
        System.out.println("week  = " + week);
        System.out.println("month = " + month);
        System.out.println("Calender = " + year + "." + month + "." + day);


        String strTime = "2008.11.08";
        try {
            Date dt = new SimpleDateFormat("yyyy.MM.dd").parse(strTime);
            calendar.setTime(dt);

            day = calendar.get(Calendar.DAY_OF_MONTH);
            month  = calendar.get(Calendar.MONTH) + 1;
            year   = calendar.get(Calendar.YEAR);

            System.out.println("Calender = " + year + "." + month + "." + day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void test_3() {
        System.out.printf("%tc", new Date());
        System.out.println();

        /**
         * 日期的格式化,需要以%t开头，后面跟特定格式化字符，详见《Java核心卷1》P59: 表3-7
         * 说明：
         *     下面格式化串中的数字+$代表: 被格式化的参数索引,索引从1开始. 例如: %1$代表被格式化的参数索引是，"Due date"
         */
        System.out.printf("%1$s %2$tB %2$te %2$tY", "Due date: ", new Date());
        System.out.println();
        System.out.printf("格林尼治时间:%1$ts (单位:s) \n格林尼治时间:%1$tQ (单位: ms)", new Date());
    }

}
