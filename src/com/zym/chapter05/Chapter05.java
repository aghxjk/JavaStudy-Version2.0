package com.zym.chapter05;

/**
 * Created by zhaoyimeng on 15/11/13.
 *
 * 1. 数组
 *     a. 数组是一种引用数据类型;
 *     b. 数组是一种简单的数据结构,线性的结构;
 *     c. 数组是一个容器,可以用来存储其它元素(任意类型元素);
 *     d. 数组分为: 一维数组和多维数组;
 *     e. 数组中存储的类型是统一的;
 *     f. 数组长度一旦确定,不可改变
 *
 * 2. 数组静态初始化与动态初始化
 * 3. 数组拷贝
 * 4. 二维数组
 * 5. Arrays工具类(Sun 提供的工具)
 */
public class Chapter05 {
    public static void main(String[] args) {

        MyArray.ArrayStatic();
        MyArray.ArrayDynamic();
        MyArray.arrCopy();
        MyArray.twoDimenArr();
    }

}
