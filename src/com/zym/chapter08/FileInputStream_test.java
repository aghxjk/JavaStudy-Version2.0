package com.zym.chapter08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by zhaoyimeng on 15/11/27.
 */
public class FileInputStream_test {


    public static  String getDir(){
        return FileInputStream_test.class.getResource("").getPath();
    }
    /**
     * 从输入流中读取一个字节，文件结束时返回：-1
     * 以下程序存储缺点:
     *    频繁访问磁盘,性能不高,伤害磁盘
     */
    public static void test_1() {
        System.out.println("---------------->文件输入字节流:test_1()");

        FileInputStream fileInStream = null;
        try {
            /**
             *  1. 创建文件输入流
             */
            String filePath = getDir() + "temp01.txt";
            fileInStream = new FileInputStream(filePath);

           /**
            *  2. 读文件
            */
            int iRead1 = fileInStream.read();
            int iRead2 = fileInStream.read();
            int iRead3 = fileInStream.read();
            int iRead4 = fileInStream.read();
            int iRead5 = fileInStream.read();
            int iRead6 = fileInStream.read();
            int iRead7 = fileInStream.read();

            System.out.println(iRead1);
            System.out.println(iRead2);
            System.out.println(iRead3);
            System.out.println(iRead4);
            System.out.println(iRead5);
            System.out.println(iRead6);
            System.out.println(iRead7);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ( fileInStream != null ){
                try {
                    fileInStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * test_1()的循环方式
     */
    public static void test_2() {

        System.out.println("---------------->文件输入字节流:test_2()");

        FileInputStream fileInStream = null;
        try {
            /**
             *  1. 创建文件输入流
             */
            String filePath = getDir() + "/temp01.txt";
            fileInStream = new FileInputStream(filePath);

            /**
             *  2. 读文件
             */
            int tmp;
            while ( (tmp=fileInStream.read()) != -1 ){
                System.out.println("temp01.txt : " + tmp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ( fileInStream != null ){
                try {
                    fileInStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 以指定长度的byte[]读取文件内容
     * 备注：
     *      一个中文占用2个byte,奇数位置的中文，输出的时候会乱码
     */
    public static void test_3() {

        System.out.println("---------------->文件输入字节流:test_3()");

        FileInputStream fileInStream = null;
        try {
            /**
             *  1. 创建文件输入流
             */
            String filePath = getDir() + "/temp01.txt";
            fileInStream = new FileInputStream(filePath);

            //返回流中估计剩余字节数
            System.out.println("FileInputStream.available() = " + fileInStream.available());

            /**
             *  2. 读文件
             */
            byte[] arr = new byte[7];
            int count;

            while ((count=fileInStream.read(arr)) != -1){
                // 一个中文占用2个byte,奇数位置的中文，输出的时候会乱码
                System.out.println("byte[] = " + new String(arr, 0 , count));
            }
            //返回流中估计剩余字节数
            System.out.println("FileInputStream.available() = " + fileInStream.available());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ( fileInStream != null ){
                try {
                    fileInStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(FileInputStream_test.class.getResource("").getFile());
        System.out.println(FileInputStream_test.class.getName());
        System.out.println(FileInputStream_test.class.getSimpleName());
        FileInputStream_test.test_3();
    }

}
