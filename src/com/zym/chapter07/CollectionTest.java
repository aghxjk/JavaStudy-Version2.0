package com.zym.chapter07;


import java.util.*;

/**
 * Created by zhaoyimeng on 15/11/24.
 */
public class CollectionTest {

    public static void test_1() {

        System.out.println("---------------->集合类:");
//        Collection cl = new ArrayList<String>();
        Collection cl = new HashSet();


        cl.add("abc");
        cl.add(1);
        cl.add("1000");
        cl.add(true);

        Iterator it = cl.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof String) {
                System.out.println("I am a String : " + obj);
            } else if (obj instanceof Integer) {
                System.out.println("I am a Integer : " + obj);
            } else if ( obj instanceof Boolean) {
                System.out.println("I am a Boolen : " + obj);
            }
            else {
                System.out.println("I am a nothing : " + obj);
            }
        }

        System.out.println("---------------->");
        for (Iterator tmp = cl.iterator(); tmp.hasNext(); ) {
            Object obj = tmp.next();
            if (obj instanceof String) {
                System.out.println("I am a String : " + obj);
            } else if (obj instanceof Integer) {
                System.out.println("I am a Integer : " + obj);
            } else {
                System.out.println("I am a nothing : " + obj);
            }
        }

        System.out.println("---------------->");
        for (Object obj:cl) {
            if (obj instanceof String) {
                System.out.println("I am a String : " + obj);
            } else if (obj instanceof Integer) {
                System.out.println("I am a Integer : " + obj);
            } else {
                System.out.println("I am a nothing : " + obj);
            }
        }

        Integer i1 = new Integer(1);
        System.out.println("is contains 1 : " + cl.contains(i1));
        System.out.println("ArrayList Number: " + cl.size());
    }

    /**
     * 集合删除元素务必用迭代器
     */
    public static void test_2() {

        System.out.println("---------------->集合删除:");
        Collection cl = new ArrayList();

        cl.add(10);
        cl.add(20);
        cl.add(30);

        Iterator it = cl.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println("item in ArrayList: " + obj);
            it.remove();
        }

        System.out.println("size of ArrayList : " + cl.size());

//        while (it.hasNext()){
//            Object obj = it.next();
//            System.out.println("item in ArrayList: " + obj);
//            cl.remove(obj);
//            it = cl.iterator();  //如果删除该代码,将导致删除元素异常。直接使用集合删除元素需要重新获取迭代器,之前的迭代器已经失效。
//        }
//
//        System.out.println("size of ArrayList : " + cl.size());
    }
}



