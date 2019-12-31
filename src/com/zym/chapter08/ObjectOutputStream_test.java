package com.zym.chapter08;

import java.io.*;

/**
 * Created by zhaoyimeng on 15/11/30.
 * transient关键字:
 * 1. transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的
 * 2. 被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化
 * 3. 一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 *    也可以认为在将持久化的对象反序列化后，被transient修饰的变量将按照普通类成员变量一样被初始化
 */
public class ObjectOutputStream_test {

    public static  String getDir(){
        return ObjectOutputStream_test.class.getResource("").getPath();
    }

    public static void test_1() {

        System.out.println("---------------->ObjectOutputStream");
        String fileName = getDir() + "/temp10.txt";
        User user =  new User("刘德华",53);
        ObjectOutput objectOutput = null;

        try {
            objectOutput = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutput.writeObject(user);
            objectOutput.flush();
            System.out.println("-->" + user.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ( objectOutput == null) {
                try {
                    objectOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class User implements Serializable{

    private static final long serialVersionUID = -7342024645322946497L;
    String name;
    transient int age;

    public User(String name) {
        this.name = name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' + ";" +
                "age='" + age + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ObjectOutputStream_test.test_1();
    }
}