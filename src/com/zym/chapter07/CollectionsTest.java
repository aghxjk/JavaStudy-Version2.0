package com.zym.chapter07;

import java.util.*;

/**
 * Created by zhaoyimeng on 15/11/26.
 */
public class CollectionsTest {

    public static void test_1() {

        System.out.println("---------------->集合工具类:");

        List lst = new ArrayList();

        lst.add(10);
        lst.add(20);
        lst.add(9);
        lst.add(15);

        for (int i = 0; i < lst.size(); i++) {
            Object obj = lst.get(i);
            System.out.println("items in List : " + obj);
        }

        Collections.sort(lst);
        System.out.println("----------");
        Iterator it = lst.iterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.println("items in List : " + ob);
        }
    }

    public static void test_2() {

        System.out.println("---------------->集合工具类:");
        Set set = new HashSet();

        set.add(10);
        set.add(0);

        set.add(100);
        set.add(85);
        set.add(88);

        List list = new ArrayList(set);
        Collections.sort(list);

        Iterator it = list.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println("HashSet items :" + obj);
        }
        System.out.println("HashSet size = " + set.size());
    }
}
