package com.zym.chapter08;

import java.io.*;

/**
 * Created by zhaoyimeng on 15/11/27.
 */
public class FileOutputStream_test {

    public static  String getDir(){
        return FileOutputStream_test.class.getResource("").getPath();
    }

    public static void test_1() {

        System.out.println("---------------->文件输出字节流:test_1()");
        String fileName = getDir() + "temp02.txt";
        System.out.println("Path-in: " + fileName);

        FileOutputStream fos = null;
        try {

            //1 创建文件字节输出流
            fos = new FileOutputStream(fileName, true);

            //2 写文件
            String msg = "Hello World!!!";
            byte[] bytes = msg.getBytes();
            fos.write(bytes);
//            fos.write(bytes, 0, 8);

            //3 刷新
            fos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 文件复制
     */
    public static void test_2() {

        System.out.println("---------------->文件复制:");

        String fisName = getDir() + "temp02.txt";
        String fosName = getDir() + "temp03.txt";
        System.out.println("Path-out:" + fosName);

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {

            fis = new FileInputStream(fisName);
            fos = new FileOutputStream(fosName);

            byte[] bytes = new byte[10];
            int count = 0;

            try {
                while ( (count=fis.read(bytes)) != -1 ){
                    fos.write(bytes, 0, count);
                }
                fos.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileOutputStream_test.test_1();
        FileOutputStream_test.test_2();
    }
}
