package com.zym.chapter10;

/**
 * Created by zhaoyimeng on 15/12/1.
 */
public class Reflect_Test {

    public static void test(int... a){
        for (int i:a){
            System.out.println("test(int... a) : param.length = " + a.length + " : " + i);
        }
        if (a.length==0){
            System.out.println("test(int... a) : param.length = " + a.length);
        }
    }

    public static void test(int a){
        System.out.println("test(int a) : " + a);
    }

    public static void test(int a, String... str){
        for (String st:str) {
            System.out.println("test(int a, String... str) : a = " + a + " str = " + st );
        }
    }

    public static void test1(){

        /**
         *  会执行A的静态语句块
         */
        System.out.println("------------------>Class.forName()");
        try {
            Class c = Class.forName("com.zym.chapter10.A");
            System.out.println("Class = " + c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     *  不会执行A的静态语句块
     */
    public static void test2(){
        System.out.println("\n------------------>Class.class");
        Class c = A.class;
        System.out.println("Class = " + c);
    }

    public static void test3(){
        Class c = A.class;
        try {
            /**
             *  调用newInstance()一定要求有无参构造方法
             */
            Object o1 = c.newInstance();//调用了A类的无参数构造函数
            if (o1 instanceof A){
                System.out.println("I'm  class A");
                System.out.println("Class = " + o1.getClass());
            }
            System.out.println("\n------------------>Object.getClass()");
            Object o2 = new A();
            System.out.println("Class = " + o2.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Reflect_Test.test1();
        Reflect_Test.test2();
        Reflect_Test.test3();

        /**
         *  可变长参数设置
         */
        Reflect_Test.test();
        Reflect_Test.test(0);//如果可以精确匹配,在调用精确匹配方法
        Reflect_Test.test(1, 11);
        Reflect_Test.test(2, "abc", "def");
        Reflect_Test.test(3, 33, 333);
    }
}

class A{

    static {
        System.out.println("static initial");
    }

    public A() {
    }

    {
        System.out.println("\nnone static initial");
    }
}

