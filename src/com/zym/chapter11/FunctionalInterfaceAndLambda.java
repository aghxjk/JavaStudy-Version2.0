package com.zym.chapter11;

public class FunctionalInterfaceAndLambda {
    public static void main(String[] args) {
        FunctionalInterfaceAndLambda.test();
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return (Integer) mathOperation.operation(a, b);
    }

    public static void test() {
        // 类型声明
        MathOperation addtion = (Object a, Object b) -> (Integer)a + (Integer) b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> (Integer)a - (Integer)b;

        // 大括号中的返回语句
        MathOperation multiplication = (Object a, Object b) -> {
            System.out.println();
            return (Integer)a * (Integer)b;
        };

        // 没有大括号及返回语句
        MathOperation division = (Object a, Object b) -> (Integer)a / (Integer)b;

        /**
         * 调用方式一：
         * 1. 函数式接口用lambda表达式实例化
         * 2. 直接调用实例方法
         */
        System.out.println("1 + 1 = " + addtion.operation(1, 1));
        System.out.println("2 - 1 = " + subtraction.operation(2, 1));
        System.out.println("2 * 2 = " + multiplication.operation(2, 2));
        System.out.println("4 / 2 = " + division.operation(4, 2));

        /**
         * 调用方式二：
         * 1. 传递函数式接口实例给调用方法
         */
        System.out.println("--------");
        FunctionalInterfaceAndLambda functionalInterfaceAndLambda = new FunctionalInterfaceAndLambda();
        System.out.println("1 + 1 = " + functionalInterfaceAndLambda.operate(1, 1, addtion));
        System.out.println("2 - 1 = " + functionalInterfaceAndLambda.operate(2, 1, subtraction));
        System.out.println("2 * 2 = " + functionalInterfaceAndLambda.operate(2, 1, multiplication));
        System.out.println("4 / 2 = " + functionalInterfaceAndLambda.operate(4, 2, division));
    }
}

@java.lang.FunctionalInterface
interface MathOperation<T> {
    T operation(T a, T b);
}

@java.lang.FunctionalInterface
interface GreetingService {
    void sayMessage(Object obj);
}