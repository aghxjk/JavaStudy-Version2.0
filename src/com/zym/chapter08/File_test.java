package com.zym.chapter08;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by zhaoyimeng on 15/11/30.
 */
public class File_test {

    public static void test_1() {

        System.out.println("---------------->File");
        String dir;
        dir = File_test.class.getResource("").getPath();

        File f1 = new File(dir + "/temp01.txt");
        File f2 = new File(dir);
        File f3 = new File(dir + "/DirTest");
        File f4 = new File(dir + "/DirTest/mkFile.txt");

        System.out.println("文件是否存在: " +  f1.exists());
        System.out.println("文件是否存在: " +  f2.exists());
        System.out.println("文件是否存在: " +  f3.exists());
        System.out.println("获取文件父目录: " +  f1.getParent());
        System.out.println("文件修改日期: " +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(f1.lastModified()));
        System.out.println("获取文件大小: " +  f1.length() + " byte");

        if ( !f3.exists() ){
            f3.mkdir();
            try {
                f4.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            DeleteDirectory(f3);
        }

        File[] fList = f2.listFiles();
        for (File fl:fList){
            if ( fl.getAbsolutePath().endsWith(".txt") ){
                System.out.println(fl.getAbsolutePath());
            }
        }
    }

    public static void DeleteDirectory(File file){
        File[] fls = file.listFiles();
        if ( fls == null || fls.length == 0 ){
            file.delete();
        } else {
            System.out.println("length = " + fls.length);
            for (File f:fls) {
                System.out.println(f.getAbsoluteFile());
                DeleteDirectory(f);
            }
        }
        file.delete();
    }

    public static void main(String[] args) {
        File_test.test_1();
    }
}

