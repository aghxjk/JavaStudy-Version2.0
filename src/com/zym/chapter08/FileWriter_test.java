package com.zym.chapter08;

import java.io.*;

/**
 * Created by zhaoyimeng on 15/11/27.
 */
public class FileWriter_test {

    public static  String getDir(){
        return FileWriter_test.class.getResource("").getPath();
    }

    public static void test_1() {

        System.out.println("\n---------------->文件字符输出字节流:test_1()");
        String fisName = getDir() + "/temp04.txt";
        System.out.println("Path:" + fisName);

        FileWriter fiw = null;

        try {

            fiw = new FileWriter(fisName, true);
            fiw.write("赵钱孙李!!!");
            char[] chars = {'中', '华', '人', '民', '共', '和', '国'};
            fiw.write(chars, 1, 5);
            fiw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fiw != null){
                try {
                    fiw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void test_2() {
        System.out.println("\n---------------->文件字符输出字节流:test_2()");
        String fisName = getDir() + "/temp02.txt";
        String fosName = getDir() + "/temp05.txt";
        System.out.println("From:" + fisName);
        System.out.println("To:" + fosName);

        FileReader fi = null;
        FileWriter fo = null;

        try {

            fi = new FileReader(fisName);
            fo = new FileWriter(fosName);

            char[] chars = new char[10];
            int count;

            while ( (count=fi.read(chars)) != -1 ){
                fo.write(chars, 0, count);
            }
            fo.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        FileWriter_test.test_1();
        FileWriter_test.test_2();
    }
}
