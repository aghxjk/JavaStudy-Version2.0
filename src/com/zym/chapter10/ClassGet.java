package com.zym.chapter10;

/**
 * Created by zhaoyimeng on 15/12/1.
 */
public class ClassGet {

    public static void test1(){

        /**
         *  第一种方式:
         */
        Class c1=null;
        try {
            c1 = Class.forName("com.zym.chapter10.User");//返回与带有给定字符串名的类或接口相关联的 Class 对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         *  第二种方式:
         */
        Class c2 = User.class;//java中每个类型都有一个class属性
        Class ci = int.class; //基本数据类型也有一个class属性

        /**
         *  第三种方式:
         */
        User user = new User("Tom");
        Class c3 = user.getClass(); //返回此 user 的运行时类

        /**
         *  User这个类在JVM中只有一个,所以c1, c2, c3地址相等,指向堆中唯一的一个对象
         */
        System.out.println("c1 == c2 is " + (c1==c2) );
        System.out.println("c2 == c3 is " + (c2==c3) );
    }

    public static void main(String[] args) {
        ClassGet.test1();
    }
}

class User{
    private String id;
    public String name;
    public int age;
    protected String addr;
    boolean sex;


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void work(){
        System.out.println("working....");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getAddr() {
        return addr;
    }
}
