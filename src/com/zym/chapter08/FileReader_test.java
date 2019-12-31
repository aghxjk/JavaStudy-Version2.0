package com.zym.chapter08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by zhaoyimeng on 15/11/27.
 */
public class FileReader_test {

    public static  String getDir(){
        return FileReader_test.class.getResource("").getPath();
    }

    public static void test_1() {


        System.out.println("---------------->文件字符输入字节流:test_1()");
        String fisName = getDir() + "/temp02.txt";

        FileReader fir = null;

        try {

            fir = new FileReader(fisName);

            char[] chars = new char[10];
            int count = 0;

            while ( (count=fir.read(chars)) != -1 ){
                System.out.print(new String(chars, 0, count));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fir != null){
                try {
                    fir.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        FileReader_test.test_1();
    }
}
