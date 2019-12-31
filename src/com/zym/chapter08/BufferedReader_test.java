package com.zym.chapter08;

import java.io.*;

/**
 * Created by zhaoyimeng on 15/11/27.
 */
public class BufferedReader_test {

    public static  String getDir(){
        return BufferedReader_test.class.getResource("").getPath();
    }

    public static void test_1() {

        System.out.println("\n---------------->BufferedReader:test_1()");
        String fisName = getDir() + "/temp06.txt";

        BufferedReader br = null;

        try {

            /**
             * 1 创建字符文件输入流 new FileReader()
             * 2 将1包装成带有缓冲区的字符输入流
             *
             * 注意: 装饰者设计模式: 只需要关闭外层包装流
             */

            br = new BufferedReader(new FileReader(fisName));

            String line;

            /**
             * 注意:  readLine()行尾不带换行符
             */
            while ( (line=br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void test_2() {

        System.out.println("\n---------------->BufferedReader:test_2()");
        String fisName = getDir() + "/temp06.txt";

        BufferedReader br = null;

        try {

            /**
             * 1. 创建文件字节输入流
             * 2. 将1包装成文件字符输入流
             * 3. 将2包装成带有缓冲区的字符输入流
             * 注意: 装饰者设计模式: 只需要关闭外层包装流
             */

            br = new BufferedReader(new InputStreamReader(new FileInputStream(fisName)));

            String line;

            /**
             * 注意:  readLine()行尾不带换行符
             */
            while ( (line=br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void test_3() {

        System.out.println("\n---------------->接收键盘输入:test_3()");

        /**
         * 对于带空格的输入是有缺陷的,空格后的内容会被忽略
         */
//        Scanner scanner = new Scanner(System.in);
//        String str = null;
//        while ( (str=scanner.next()).equals("") ) {
//            System.out.println("your Input : " + str);
//        }

        /**
         * 新方式
         */

        BufferedReader br = null;
        try {
            while (true){
                br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                if (str.equals("")) {
                    break;
                }
                else {
                    System.out.println("your Input : " + str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader_test.test_1();
        BufferedReader_test.test_2();
        BufferedReader_test.test_3();
    }

}