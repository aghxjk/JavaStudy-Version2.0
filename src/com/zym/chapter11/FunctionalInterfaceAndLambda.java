package com.zym.chapter11;

public class FunctionalInterfaceAndLambda {
    public static void main(String[] args) {

        // 类型声明
        MathOperation addtion = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            System.out.println();
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

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
        System.out.println("--------------------------");
        FunctionalInterfaceAndLambda functionalInterfaceAndLambda = new FunctionalInterfaceAndLambda();
        System.out.println("1 + 1 = " + functionalInterfaceAndLambda.operate(1, 1, addtion));
        System.out.println("2 - 1 = " + functionalInterfaceAndLambda.operate(2, 1, subtraction));
        System.out.println("2 * 2 = " + functionalInterfaceAndLambda.operate(2, 1, multiplication));
        System.out.println("4 / 2 = " + functionalInterfaceAndLambda.operate(4, 2, division));

    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}

@java.lang.FunctionalInterface
interface MathOperation {
    int operation(int a, int b);
}

@java.lang.FunctionalInterface
interface GreetingService {
    void sayMessage(Object obj);
}