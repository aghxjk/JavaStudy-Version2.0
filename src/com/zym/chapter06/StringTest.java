package com.zym.chapter06;

/**
 * Created by zhaoyimeng on 15/11/20.
 */
public class StringTest {

    public static void test_1(){

        //创建一个"abc"字符串对象,该对象的内存地址保存在s1中
        //s1是一个引用,s1指向"abc"对象
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("常理字符串 s1 == s2 :" + (s1 == s2));

        System.out.println("---------------->字符串存储本质:");
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(" s3 == s4 :" + (s3 == s4));
        System.out.println(" s3.equals(s4) :" + (s3.equals(s4)));
    }

    public static void test_2(){
        //使用字符串是要避免大量的字符串拼接操作，否则会导致字符串常量池有大量的字符串对象,给垃圾回收器带来问题
        //不建议进行如下频繁的拼接操作

        String[] str = {"sport", "musci", "food", "sleep"};
        String tmp = ""; //避免使用String类型拼接
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length; i++) {
            if (i == str.length-1){
                tmp += str[i];
                sb.append(str[i]);
            } else {
                tmp += str[i] + ",";
                sb.append(str[i]).append(",");
            }
        }
        System.out.println("\n---------------->避免字符串拼接操作:");
        System.out.println("tmp = " + tmp);
        System.out.println("sb = " + sb);
    }

    /**
     * 字符串初始化
     */
    public static void test_3(){

        //字符串初始化方式-1
        String s1 = "abc";

        //字符串初始化方式-2
        String s2 = new String("abc");

        //字符串初始化方式-3
        byte[] bt = {97, 98, 99, 100};
        String s3 = new String(bt);
        System.out.println("\n---------------->字符串初始化:");
        System.out.println("s3 = " + s3);

        //字符串初始化方式-4
        String s4 = new String(bt, 0 ,2);
        System.out.println("s4 = " + s4);


        //字符串初始化方式-5
        char[] c1 = {'我','是','中','国','人'};
        String s5 = new String(c1);
        System.out.println("s5 = " + s5);

        //字符串初始化方式-6
        String s6 = new String(c1,2 ,2);
        System.out.println("s6 = " + s6);
    }

    public static void test_4(){

        System.out.println("\n---------------->字符串常用方法:");

        //1. char charAt(int index)
        char c1 = "abcdef".charAt(3);
        System.out.println("charAt() : " + c1);

        //2. boolean endsWith(String endStr)
        System.out.println("endsWith(): " + "Hello World.java".endsWith("java"));
    }

    public static void test_regExp(){

        System.out.println("\n---------------->正则表达式:");

        String s1 = "asdfdddd33dkljadskkdkdd99asdf66asdf66asdf55asdfasdfljjja";

        //将dd替换为中
        System.out.println(s1.replaceAll("dd", "--"));
        System.out.println(s1.replaceAll("d{2}", "--"));

        //将数字替换为中
        System.out.println(s1.replaceAll("\\d", "--"));
        System.out.println(s1.replaceAll("\\D", "--"));
    }

    public static void test_codePoint() {
        String greeting = "Hello";
        int n = greeting.length();
        System.out.println("\"Hello\" 字符的码点单元数是: " + n);

        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println("\"Hello\" 字符串的码点数是: " + cpCount);

        int index = greeting.offsetByCodePoints(0, 3);
        System.out.println("\"Hello\" 字符串的第3个码点是: " + greeting.codePointAt(index)); // 第3个码点对应的字符l为108，对于双码点单元的Case详见《Java核心技术 卷1》P49

        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.appendCodePoint(108); // l的ASCII码是108
        System.out.println("appendCodePoint 示例: " + stringBuffer.toString());
    }
}
