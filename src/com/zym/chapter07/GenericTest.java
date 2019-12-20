package com.zym.chapter07;

import java.util.*;

/**
 * Created by zhaoyimeng on 15/11/26.
 */
public class GenericTest {

    public static void test_1() {

        System.out.println("---------------->泛型初步(List<E>)");

        List<String> list = new ArrayList<String>();

        /**
         * 编译阶段错误
         */
//        list.add(1);
        list.add("Jack");
        list.add("Jim");
        list.add("Tom");
        list.add("Apple");


        Iterator<String> it = list.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

    public static void test_2() {

        System.out.println("---------------->泛型初步(Map<K V>)");

        Map<String, Integer> maps = new HashMap<String, Integer>();

        maps.put("苹果", 22);
        maps.put("香蕉", 12);
        maps.put("橘子", 32);
        maps.put("橙子", 2);

        Set<String> set = maps.keySet();

        for ( Iterator<String> it = set.iterator(); it.hasNext(); ){
            String item = it.next();
            System.out.println(item + " : " + maps.get(item));
        }
    }

    public static void test_3() {

        System.out.println("---------------->泛型初步(SortedSet)");

        SortedSet<Manager> mgs = new TreeSet<Manager>();

        mgs.add(new Manager(32000.0));
        mgs.add(new Manager(33000.0));
        mgs.add(new Manager(31000.0));
        mgs.add(new Manager(30000.0));


        for ( Iterator<Manager> it = mgs.iterator(); it.hasNext(); ){
            Manager manager = it.next();
            System.out.println(manager);
        }
    }

    /**
     * 自定义泛型
     */
    public static void test_4() {


        System.out.println("---------------->自定义泛型");
        MyClass<String> myClass = new MyClass<String>();

        //编译时错误
//        myClass.m1(100);
        myClass.m1("Jack");
    }

    /**
     * 增强for循环
     */
    public static void test_5() {

        System.out.println("---------------->增强for循环");
        int[] intArray = {1,3,4,2,3,6};

        for (int item: intArray){
            System.out.println("intArray[] = " + item);
        }



        Set<String> myset = new HashSet<String>();

        System.out.println("-----------");
        myset.add("Apple");
        myset.add("Orange");
        myset.add("Banana");
        myset.add("Pear");
        myset.add("Strawberry");

        for (String str : myset){
            System.out.println("HashSet = " + str);
        }
    }
}

class MyClass<T>{
    public void m1(T t){
        System.out.println("自定义泛型 : " + t);
    }
}

class Manager implements Comparable<Manager>{

    double salary;

    public Manager(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Manager o) {

        if (this==o) return 0;

        if (this.salary < o.salary)
            return -1;
        else if (this.salary > o.salary)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "salary=" + salary +
                '}';
    }
}
