package com.zym.chapter04;

/**
 * Created by zhaoyimeng on 15/11/11.
 *
 * 1. 异常是什么？
 *     a. 异常模拟的是现实世界中不正常的事件
 *     b. java中采用"类"去模拟异常
 *     c. "类"是可以创建对象的
 *
 * 2. 异常的层次结构
 *                          |-->Error(错误无法被处理，只能退出JVM. 例如：StackOverflowError)
 *    Object --> Throwable -|
 *                          |-->Exception(是可以被处理的,如果没有被处理,则程序退出JVM)
 *                                 |
 *                                 |
 *                                 |-->RuntimeException(运行时异常)
 *                                 |      a. 所有运行时异常,程序员编写程序阶段无需进行处理
 *                                 |
 *                                 |
 *                                 |-->编译时异常(所有Exception的直接子类都是编译时异常)
 *                                        a. 所有编译时异常要求程序员编写程序阶段必须对它进行处理
 *                                        b. 处理方式: (1)捕获   (2)抛出
 * 3. 处理异常两种方式
 *     a. 声明抛出  throws
 *     b. 捕获异常  try...catch...
 *
 * 4. 关于finally语句块
 *     a. finally语句块可以直接和try语句块联用.
 *        try...catch...finally
 *        try...finally
 *     b. 在finally语句块中的代码一定会执行
 *
 * 4. final, finalize, finally
 *     a. final 修饰变量  方法  类
 *     b. finalize JVM消耗对象时调用的方法
 *     c. finally  与try接口释放资源
 *
 *
 */


public class Chapter04 {

    public static boolean expThrow;
    public static boolean tryCatch;
    public static boolean tryFinal;
    public static boolean myExpEg;

    static {
        expThrow = false;
        tryCatch = false;
        tryFinal = false;
        myExpEg = true;
    }


    public static void main(String[] args) throws Exception {

        if ( expThrow == true){

            ExceptionTest.throwExpTest_1();
            //捕获到异常后,异常后面的代码不再被执行
            ExceptionTest.throwExpTest_2();
            ExceptionTest.throwExpTest_3();

            System.out.printf("Hello World.....");

        } else if( tryCatch ==  true ){

            ExceptionTest.tryCatchTest_1();

        } else if ( tryFinal == true ){

//            ExceptionTest.finallyExp_1();
            int res = ExceptionTest.finallyExp_2();
            System.out.println("res = " + res);

        } else if (myExpEg == true){
            String name = "jack";

            CustomerService cs = new CustomerService();
            try {

                cs.redister(name);

            } catch (IllegalNameExp illegalNameExp) {

                System.out.println("错误码:" + illegalNameExp.getErrCode());
                System.out.println(illegalNameExp.getExceptionMsg());
                illegalNameExp.printStackTrace();
            }
        }
    }
}
