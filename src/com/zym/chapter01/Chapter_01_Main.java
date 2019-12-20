package com.zym.chapter01;

import java.io.Console;
import java.util.Scanner;

public class Chapter_01_Main {

    static void chapter_fun1() {
        multiClass1 mc1 = new multiClass1();
        multiClass2 mc2 = new multiClass2();
        multiClass3 mc3 = new multiClass3();

        mc1.print();
        mc2.print();
        mc3.print();
    }

    public static void main(String argv[]){
        Chapter_01_Main.chapter_fun1();
    }
}

