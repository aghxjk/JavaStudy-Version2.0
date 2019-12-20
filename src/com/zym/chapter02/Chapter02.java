package com.zym.chapter02;

import java.util.Arrays;

/**
 * Created by zhaoyimeng on 15/11/4.
 *
 * 1. 什么是字面值？
 *       眼睛看上去就知道是多少的数据，就是字面值
 *
 * 2. 字面值本质：
 *    a. 字面值有数据类型
 *    b. 在内存中占用空间
 *    c. 字面值就是内存中一块空间,这块空间有类型，有类型有值。
 *
 * 3. 方法的执行原理
 *    a. 方法在调用的时候才会给方法在内存中分配空间
 *    b. 如果这个方法是定义没有调用，则不会在内存中分配空间
 *    c. 方法调用时，在栈中分配空间，其实就是“入栈”和“出栈”操作
 *
 */

public class Chapter02{
    static String getChapter = "Chapter 02 : ";

    /**
     * 字面值示例
     */
    public static void dataBySee(){

        System.out.println(Chapter02.getChapter + 1_000_000);        //整型字面值
        System.out.println(Chapter02.getChapter + 3.14);      //浮点字面值
        System.out.println(Chapter02.getChapter + 0b0001_0001);      //二进制字面值,可以通过下划线分隔,便于阅读

        System.out.println(Chapter02.getChapter + true);      //布尔字面值
        System.out.println(Chapter02.getChapter + false);     //布尔字面值

        System.out.println(Chapter02.getChapter + 'a');       //字符字面值
        System.out.println(Chapter02.getChapter + "Hello");   //字符串字面值

        System.out.println(Chapter02.getChapter + 10);        //注意：不能与上面的字面值10共用同一块存储空间
    }

    /**
     * 默认数据类型示例
     */
    public static void defaultType(){

        byte b = 1;
        short s = 1;
        int i = 1;
        long l = 1;

        float f = 1.1f;
        double d = 1.1;

        boolean bl = true;
        char c = '1';

        System.out.println("----------------------");
        System.out.println(Chapter02.getChapter + b);
        System.out.println(Chapter02.getChapter + s);
        System.out.println(Chapter02.getChapter + i);
        System.out.println(Chapter02.getChapter + l);
        System.out.println(Chapter02.getChapter + f);
        System.out.println(Chapter02.getChapter + d);
        System.out.println(Chapter02.getChapter + bl);
        System.out.println(Chapter02.getChapter + c);
    }

    /**
     * 递归求和
     */
    public static int sumNumer(int n){

        if (n == 1){
            return 1;
        }
        else{
            return n + sumNumer(n-1);
        }
    }

    static void chapter_fun2(){
        dataBySee();
        defaultType();
        System.out.println("递归:" + sumNumer(100));
    }

    static void chapter_fun3(){
        String str1 = "2017-06-14 17:20:30";
        String str2 = "2017-06-13 18:20:30";
        int cr = str2.compareTo(str1);
        System.out.println("str2.compareTo(str1) = " + cr);
    }

    //

    /**
     * 可变参数列表
     */
    static int chapter_fun4(String str, int... nums){
        int sum = 0;
        for (int i:nums) {
            sum += i;
        }

        StringBuilder res = new StringBuilder();
        Arrays.asList(str.substring(str.indexOf("1")).split("")).forEach( i -> res.append(i + "+") );
        res.deleteCharAt(res.length()-1);

        System.out.println(str.substring(0, str.indexOf("1")) + res + " = " + sum);
        return sum;
    }

    /**
     * 移位运算符要完成模32的运算,除非操作数是long会模64
     */
    static void chapter_fun5() {
        System.out.println("1<<3 = " + String.valueOf(1<<3));
        System.out.println("1<<35 = " + String.valueOf(1<<35));
    }
    public static void main(String[] args) {

        chapter_fun2();
        chapter_fun3();
        chapter_fun4("求和：123456789",1, 2, 3, 4, 5, 6, 7, 8, 9);
        chapter_fun5();
    }
}










