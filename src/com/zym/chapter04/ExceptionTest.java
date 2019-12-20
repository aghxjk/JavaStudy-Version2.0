package com.zym.chapter04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by zhaoyimeng on 15/11/13.
 *
 * 1. 编译器只要发现调用的方法声明处有throws异常,代码就需要对异常进行处理;
 * 2. 程序运行过程分析：
 *       a. 程序运行过程发生了FileNotFoundException异常;
 *       b. JVM为我们创建一个FileNotFoundException对象;
 *       c. 该对象携带相关信息并输出到控制台;
 *       d. 并且JVM停止程序运行;
 *
 */
public class ExceptionTest {

    static void throwExpTest_1() throws FileNotFoundException {
        System.out.println("throwExpTest_1 ....");
        FileInputStream fs = new FileInputStream("./test.txt");
    }

    static void throwExpTest_2() throws IOException {
        System.out.println("throwExpTest_2 ....");
        FileInputStream fs = new FileInputStream("./test.txt");
    }

    static void throwExpTest_3() throws Exception {
        System.out.println("throwExpTest_3 ....");
        FileInputStream fs = new FileInputStream("./test.txt");
    }

    static void tryCatchTest_1(){
        try {

            System.out.println("tryCatchTest_1 ....");
            System.out.println("---异常捕获从上到下，从小到大捕获...");
            FileInputStream fs = new FileInputStream("./test.txt");
            fs.read();

        } catch (FileNotFoundException e){

            System.out.println("---读取的文件不存在...");
            String msg = e.getMessage();
            System.out.println("---" + msg);

        } catch (ArithmeticException e){

            System.out.println("---数据计算异常...");
            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("---IOException 异常...");
        }
    }

    static void finallyExp_1() {

        FileInputStream fs = null;
        try {

            System.out.println("Game Over 1...");
            fs = new FileInputStream("./test.txt");
            System.out.println("Game Over 2...");
            return;

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } finally {

            System.out.println("finall...");
            if (fs != null){
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static int finallyExp_2() throws FileNotFoundException {

        int i = 10;
        try {
            return i;
        } finally {
            i++;
            System.out.println("finall i = " + i);
        }
    }
}
