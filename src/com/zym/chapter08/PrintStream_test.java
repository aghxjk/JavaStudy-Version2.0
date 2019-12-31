package com.zym.chapter08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by zhaoyimeng on 15/11/30.
 */
public class PrintStream_test {

    public static  String getDir(){
        return PrintStream_test.class.getResource("").getPath();
    }

    public static void test_1() {

        System.out.println("---------------->printstream:test_1()");

        PrintStream ps = System.out;
        ps.println("1 -->Hello World!");

        String fileName = getDir() + "/temp09.txt";

        try {

            System.setOut(new PrintStream(new FileOutputStream(fileName)));
            PrintStream ps1 = System.out;
            ps1.println("2 -->Hello World!");
            System.out.println("To: " + fileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintStream_test.test_1();
    }
}
