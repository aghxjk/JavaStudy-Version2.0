package com.zym.chapter01;
/**
 * Created by zhaoyimeng on 15/10/30.
 *
 * 笔记：
 * [1]   Java 代码中可以没有public class
 */

class Chapter01{
    static String getChapter = "Chapter 01 : ";
}

class multiClass1 {
    void print(){
        System.out.println(Chapter01.getChapter + "multiClass1" );
    }
}

class multiClass2 {
    void print() {
        System.out.println(Chapter01.getChapter + "multiClass2");
    }
}

class multiClass3 {
    void print() {
        System.out.println(Chapter01.getChapter + "multiClass3");
    }
}
