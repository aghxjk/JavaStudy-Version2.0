package com.zym.chapter07;

import java.util.*;

/**
 * Created by zhaoyimeng on 15/11/26.
 */
public class MapTest {

    public static void test_1() {

        System.out.println("---------------->HashMap:");
        Map persons = new HashMap();

        persons.put("10000", "Jack");
        persons.put("10001", "Jim");
        persons.put("10002", "Tom");
        persons.put("10003", "Jimmy");
        persons.put("10000", "Lucy");

        System.out.println("HashMap.size() = " + persons.size());
        System.out.println("HashMap.containsKey() = " + persons.containsKey("10000"));
        System.out.println("HashMap.containsValue() = " + persons.containsValue("Lucy"));

        String key = "10001";
        Object val = persons.get(key);
        System.out.println("HashMap.get() = " + val);

        persons.remove(key);
        System.out.println("HashMap.size() = " + persons.size());

        Collection values = persons.values();
        Iterator it = values.iterator();

        System.out.println("---------------->");
        while (it.hasNext()){
            System.out.println("Values : " + it.next());
        }

        System.out.println("---------------->keySet()");
        Set keys = persons.keySet();
        Iterator itk = keys.iterator();
        while (itk.hasNext()){
            String id = (String)itk.next();
            String name = (String)persons.get(id);

            System.out.println("id = " + id + " ; name = " + name);
        }

        System.out.println("---------------->entrySet()");
        Set entrySet = persons.entrySet();
        Iterator ie = entrySet.iterator();

        while (ie.hasNext()){
            Object obj = ie.next();
            System.out.println("entrySet.getKey() = " + ((Map.Entry) obj).getKey()) ;
            System.out.println("entrySet.getValue() = " + ((Map.Entry) obj).getValue()) ;
            System.out.println("entrySet items = " +  obj) ;
            System.out.println("-------");
        }
    }

    public static void test_2() {

        /**
         * 使用Comparatable实现
         */
        SortedMap  products1 = new TreeMap();

        /**
         * 使用自建的Comparator实现
         */
        SortedMap  products2 = new TreeMap( new Product2Comparator());

        /**
         * 使用Comparator实现
         */
//        SortedMap  products = new TreeMap(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 == o2) return 0;
//
//                if ( (o1 instanceof Product2) && (o2 instanceof Product2) ){
//                    Product2 p1 = (Product2) o1;
//                    Product2 p2 = (Product2) o2;
//
//                    if (p1.price > p2.price)
//                        return -1;
//                    else if (p1.price < p2.price)
//                        return 1;
//                    else
//                        return 0;
//                }
//                return 0;
//            }
//        });

        Product2 prd1 = new Product2("西瓜", 2.5);
        Product2 prd2 = new Product2("苹果", 2.0);
        Product2 prd3 = new Product2("香蕉", 2.9);
        Product2 prd4 = new Product2("菠萝", 3.5);

        System.out.println("---------------->TreeMap: comparable");
        products1.put(prd1, 8.0);
        products1.put(prd2, 3.0);
        products1.put(prd3, 18.0);
        products1.put(prd4, 1.0);

        Set keys = products1.keySet();
        Iterator it = keys.iterator();

        while (it.hasNext()){
            Product2 pt = (Product2) it.next();
            System.out.println(pt + "-->" + products1.get(pt));
        }

        System.out.println("---------------->TreeMap: comparator");
        products2.put(prd1, 8.0);
        products2.put(prd2, 3.0);
        products2.put(prd3, 18.0);
        products2.put(prd4, 1.0);

        Set keys2 = products1.keySet();
        Iterator it2 = keys2.iterator();

        while (it2.hasNext()){
            Product2 pt = (Product2) it2.next();
            System.out.println(pt + "-->" + products2.get(pt));
        }
    }
}

class Product2 implements Comparable{
    String name;
    double price;

    public Product2(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product2{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;

        if ( o instanceof Product2){
            Product2 prd = (Product2)o;
            if (this.price > prd.price)
                return 1;
            else if (this.price < prd.price)
                return -1;
            else
                return 0;
        }
        return 0;
    }
}

class Product2Comparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if ( (o1 instanceof Product2) && (o2 instanceof Product2) ){
            Product2 p1 = (Product2) o1;
            Product2 p2 = (Product2) o2;

            if (p1.price > p2.price)
                return -1;
            else if (p1.price < p2.price)
                return 1;
            else
                return 0;
        }
        return 0;
    }
}