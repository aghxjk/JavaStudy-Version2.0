package com.zym.chapter08;

import java.io.*;

/**
 * Created by zhaoyimeng on 15/11/27.
 */
public class BufferedWriter_test {

    public static  String getDir(){
        File directory = new File("src/com/zym/chapter08/" + BufferedWriter_test.class.getSimpleName() + ".java"); //设定为当前文件夹
        return directory.getParent();
    }

    public static void test_1() {

        System.out.println("\n---------------->BufferedWriter:test_1()");
        String fosName = getDir() + "/temp06.txt";

        BufferedWriter bw = null;

        try {

            bw = new BufferedWriter(new FileWriter(fosName));
            bw.write("奥运会开幕式");
            bw.newLine();
            bw.write("你去了吗？");

            bw.flush();
            System.out.println("写文件temp06.txt  成功!!!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw == null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void test_2() {

        System.out.println("\n---------------->文件拷贝");

        String inFile = getDir() + "/Chapter08.java";
        String outFile = BufferedWriter_test.class.getResource("").getPath() + "temp07.txt";
        System.out.println("From: " + inFile);
        System.out.println("To: " + outFile);

        BufferedWriter bw = null;
        BufferedReader br = null;

        try {

            bw = new BufferedWriter(new FileWriter(outFile));
            br = new BufferedReader(new FileReader(inFile));
            String line;

            while ( (line=br.readLine()) != null ){
                bw.write(line);
                bw.newLine();
            }

            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw == null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br == null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BufferedWriter_test.test_1();
        BufferedWriter_test.test_2();
    }

}

