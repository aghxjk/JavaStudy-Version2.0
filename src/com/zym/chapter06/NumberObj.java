package com.zym.chapter06;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by zhaoyimeng on 15/11/23.
 */
public class NumberObj {

    public static void test_1(){

        System.out.println("\n---------------->包装类型:");
        System.out.println("int最小值: " + Integer.MIN_VALUE);
        System.out.println("int最大值: " + Integer.MAX_VALUE);


        System.out.println("\n---------------->包装类型:");
        System.out.println("byte最小值: " + Byte.MIN_VALUE);
        System.out.println("byte最大值: " + Byte.MAX_VALUE);

        //创建Integer类型
        Integer int1 = new Integer(10);
        Integer int2 = new Integer("123");
        int int3 = int1.intValue();
        int int4 = Integer.parseInt("345");
        System.out.println(int1);
        System.out.println(int2);
        System.out.println(int3);
        System.out.println(int4);


        //JDK5.0以后就可以直接装箱  拆箱了
        int int5 = int1;
        Integer int6 = 999;
        System.out.println(int5);
        System.out.println(int6);

    }

    /**
     * 数字格式化
     */
    public static void test_2(){

        System.out.println("\n---------------->数字格式化:");

        //加入千分位
        DecimalFormat df =  new DecimalFormat("###,###");
        System.out.println("数字格式化: " + df.format(1234567));

        //加入千分位,保留两位小数
        DecimalFormat df1 =  new DecimalFormat("###,###.##");
        System.out.println("数字格式化: " + df1.format(12345.6789));

        //加入千分位,保留四位小数不够补零
        DecimalFormat df2 =  new DecimalFormat("###,###.0000");
        System.out.println("数字格式化: " + df2.format(12345.67));
    }

    /**
     * 随机数
     */
    public static void test_3(){

        System.out.println("\n---------------->随机数:");
        Random rd = new Random();

        for (int i = 0; i < 10; i++) {
            int tm = rd.nextInt(100);
            System.out.println("随机数: " + tm + " : " + (int)(Math.random() * 100));
        }

    }
}
