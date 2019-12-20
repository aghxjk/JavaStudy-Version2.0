package com.zym.chapter07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhaoyimeng on 15/11/25.
 */
public class ListTest {

    public static void test_1() {
        System.out.println("---------------->List:");

        List lst = new ArrayList();

        lst.add(10);
        lst.add(20);
        lst.add(40);
        lst.add(40);

        for (int i = 0; i < lst.size(); i++) {
            Object obj = lst.get(i);
            System.out.println("items in List : " + obj);
        }

        System.out.println("---------------");
        for (Object i:lst) {
            System.out.println("items in List : " + i);
        }

        System.out.println("----------------");
        Iterator it = lst.iterator();
        while (it.hasNext()){
            Object ob = it.next();
            System.out.println("items in List : " + ob);
        }
        System.out.println("---------------->List:");
    }

}
