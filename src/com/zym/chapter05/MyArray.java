package com.zym.chapter05;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by zhaoyimeng on 15/11/13.
 */
public class MyArray {

    public static void ArrayStatic(){

        /**
         * 数据静态初始化
         */
        //int型数据
        int[] intArr = {100, 200, 300, 400};

        for (int i : intArr) {
            System.out.println("intArr[" + Arrays.binarySearch(intArr, i) + "] =  " + i);
        }

        for (int i=0; i<intArr.length; i++){
            System.out.println("intArr[" + i + "] =  " + intArr[i]);
        }
        System.out.println("-----------------------");

        //boolean类型数组
        boolean[] blArr = {true, false, true};
        for (int i=0; i<blArr.length; i++){
            System.out.println("blArr[" + i + "] =  " + blArr[i]);
        }
        System.out.println("-----------------------");

        //String类型数组
        String[] strArr = {"AB", "ABC", "ABCD"};
        for (int i=0; i<strArr.length; i++){
            System.out.println("strArr[" + i + "] =  " + strArr[i]);
        }
        System.out.println("-----------------------");

        //char类型数组
        char[]  chArr = {'a', 'b', 'c'};
        for (int i=0; i<chArr.length; i++){
            System.out.println("chArr[" + i + "] =  " + chArr[i]);
        }
        System.out.println("-----------------------");

        //byte类型数组
        byte[]  bArr = {10, 20, 30};
        for (int i=0; i<bArr.length; i++){
            System.out.println("bArr[" + i + "] =  " + bArr[i]);
        }
        System.out.println("-----------------------");

    }

    /**
     * 数据动态初始化
     *
     * 1. 动态初始化数据一维数组,堆内存先分配数据,然后默认初始化数组的每个元素;
     *    byte short char  int  long 默认为0
     *    float double  默认为0.0
     *    boolean       默认为false
     *    char          默认为\u0000
     *    引用           null
     */
    public static void ArrayDynamic(){

        int[] iArr = new int[4];

        for (int i = 0; i<iArr.length; i++){
            System.out.println("动态数据组: " + iArr[i]);
        }

        for (int i = 0; i <iArr.length ; i++) {
            iArr[i] += i+10;
        }

        for (int i = 0; i<iArr.length; i++){
            System.out.println("动态数据组: " + iArr[i]);
        }

        Objects[] objs = new Objects[4];
        for (int i = 0; i < objs.length; i++) {

            System.out.println("Object数组: " + objs[i]);
        }

        System.out.println("-----------------------");
        scan(new int[]{1,2,3,4,5});

    }

    /**
     *  数组拷贝
     */

    public static void arrCopy(){

        String[] strArr = {"AB", "ABC", "ABCD"};
        String[] str = new String[5];

        // 该拷贝为浅拷贝
        System.arraycopy(strArr, 0, str, 0, 3);
        for (int i=0; i<str.length; i++){
            System.out.println("string copy : strArr[" + i + "] =  " + str[i]);
        }
    }

    public static void scan(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("scan Array: " + arr[i]);
        }
    }


    /**
     * 二维数据
     */

    public static void twoDimenArr(){
        int[][] arr = {
                {1,2,3},
                {10, 20},
                {0},
                {100, 200, 300 ,400}
        };

        System.out.println("----------------------->二维数组");
        for (int i1 = 0; i1 < arr.length; i1++) {
            for (int i2 = 0; i2 < arr[i1].length; i2++) {
                System.out.println("arr[" + i1 + "]" + "[" + i2 + "] = " + arr[i1][i2]);
            }
        }
    }

}
