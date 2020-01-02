package com.zym.chapter11;

/**
 * Created by zhaoyimeng on 20/01/02
 *
 * 01. Java 8 新增了接口的默认方法。(以default关键字标识)
 *      为什么要有这个特性？
 *          首先，之前的接口是个双刃剑，好处是面向抽象而不是面向具体编程，缺陷是，当需要修改接口时候，需要修改全部实现该接口的类。
 *      目前的java 8之前的集合框架没有foreach方法，通常能想到的解决办法是在JDK里给相关的接口添加新的方法及实现。然而，对于已经
 *      发布的版本，是没法在给接口添加新方法的同时不影响已有的实现。所以引进的默认方法。他们的目的是为了解决接口的修改与现有的实现
 *      不兼容的问题。见：MyCar，RedCar示例.
 *
 * 02. 接口可以声明并实现静态方法。
 *
 * 03. 函数式接口 与 lambda表达式：
 *      3.1 函数式接口：
 *          a) 函数式接口(Functional Interface)就是一个具有一个抽象方法的普通接口(可以有多个default方法)；
 *          b) 函数式接口可以被隐式转换为lambda表达式；
 *          c) 函数式接口可以使现有的函数友好地支持 lambda
 *          d) 如果一个接口满足函数式接口的定义，会默认转换成函数式接口(@FunctionalInterface注解显式声明)；
 *
 *      3.2 lambda表达式：
 *          a) 语法格式：
 *              (parameters) -> expression
 *              或
 *              (parameters) ->{ statements; }
 *
 *              举例：
 *                  1. () -> System.out.println("Hello Lambda");
 *                  2. (number1, number2) -> int a = number1 + number2;
 *                  3. (number1, number2) -> {
 *                                               int a = number1 + number2;
 *                                               System.out.println(a);
 *                                           }
 *          b) 特征：
 *              · 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值
 *              · 可选参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号
 *              · 可选的大括号：如果主体包含了一个语句，就不需要使用大括号
 *              · 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值
 *
 * 04. forEach & stream
 *
 * 05. 方法引用在Java8中使用方式相当灵活，总的来说，一共有以下几种形式：
 *
 *     5.1 静态方法引用：ClassName::methodName;
 *     5.2 实例上的实例方法引用：instanceName::methodName;
 *     5.3 超类上的实例方法引用：supper::methodName;
 *     5.4 类的实例方法引用：ClassName:methodName;
 *     5.5 构造方法引用：Class:new;
 *     5.6 数组构造方法引用::TypeName[]::new
 *
 * 06. Optional
 */
public class Chapter11 {
    public static void main(String[] args) {

        /**
         * 1. 接口新增default默认方法;
         * 2. 接口新增static静态方法;
         */
        System.out.println("-----------接口默认方法 & 静态方法:");
        RedCar redCar = new RedCar();
        MyCar myCar = new MyCar();

        redCar.run();
        myCar.run();
        IVehicle.blowHorn();
        IFourWheeler.blowHorn();

        /**
         * 1. 函数式接口用例
         * 2. Lambda表达式
         */
        System.out.println("-----------函数式接口 & Lambda表达式:");
        FunctionalInterfaceAndLambda.test();

        /**
         * 1. forEach & stream
         */
        System.out.println("-----------forEach & stream 示例:");
        ForEachExample forEachExample = new ForEachExample();
        forEachExample.test1();
        forEachExample.test2();

        /**
         * 方法引用
         */
        MethodReference.test();

    }
}
