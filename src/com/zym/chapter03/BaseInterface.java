package com.zym.chapter03;

/**
 * Created by zhaoyimeng on 15/11/11.
 */
public interface BaseInterface {
    public static final double PI = 3.14;
    public static byte MAX_VALUE = 127;

    void fun1();
}

interface A_Interface{
    void fun1();
}

interface B_Interface{
    void fun1();
}

/**
 * 接口多继承
 */
interface C_interface extends BaseInterface, A_Interface, B_Interface{
    void fun2();
}

/**
 * 实现多个接口
 */
class  MyClass implements A_Interface, B_Interface{
    @Override
    public void fun1() {
    }
}

class MyClass2 implements C_interface{
    @Override
    public void fun1() {
    }

    @Override
    public void fun2() {
    }
}
