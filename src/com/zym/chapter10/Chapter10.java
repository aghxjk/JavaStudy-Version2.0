package com.zym.chapter10;

/**
 * Created by zhaoyimeng on 15/12/1.
 *
 *  1. 需要掌握的类:
 *      a. java.lang.Class
 *      b. java.lang.reflect.Constructor
 *      c. java.lang.reflect.Field
 *      d. java.lang.reflect.Method
 *      e. java.lang.reflect.Modifier
 *
 *  2. 反射机制作用:
 *      a. 反编译
 *      b. 通过反射机制访问java对象的属性, 方法, 构造方法等
 *
 *  3. 获取Class类型对象的方式:
 *      a. ClassName.class
 *      b. Class.forName("name")
 *      c. Object.getClass()
 *
 *  4. 获取Class类型后如何创建实例
 *
 *  5. 可变长参数
 *     a. 如果可以精确匹配,在调用精确匹配方法;
 *     b. 可变长参数可以等同看做数组;
 *     c. 可变长参数只能在参数列表的最后一位;
 *
 *  6. 反射机制 + IO + Properties 联合应用(ReflectApply.java)
 *     a. 修改classInfo.properties文件后动态创建java对象
 *
 *  7. 类中的属性(Field)
 *     a. Field.getName只能获取所有的public修饰的属性
 *     b. Class.getDeclaredFields
 *     c. 反射机制打破了封装性,导致java对象属性不安全
 *
 *  8. 反射机制两个缺点
 *     a. 性能问题: 反射机制是一种解释操作,性能远慢于直接代码.
 *     b. 反射机制会模糊程序内部实际要发生的事情.会带来维护性问题.
 *
 *
 *
 *
 *
 */
public class Chapter10 {
    public static void main(String[] argv){


        if (false) {
            ClassGet.test1();
            Reflect_Test.test1();
            Reflect_Test.test2();
            Reflect_Test.test3();

            /**
             *  可变长参数设置
             */
            Reflect_Test.test();
            Reflect_Test.test(0);//如果可以精确匹配,在调用精确匹配方法
            Reflect_Test.test(1, 11);
            Reflect_Test.test(2, "abc");
            Reflect_Test.test(3, 33, 333);

            /**
             * 反射机制应用
             */
            ReflectApply_Test.test1();
            ReflectApply_Test.test2();//反编译Field示例
            ReflectApply_Test.test3();//给Field赋值
            ReflectApply_Test.test4();//获取方法示例
            ReflectApply_Test.test5();//反射机制执行方法
            ReflectApply_Test.test6();//反射机制获取构造方法
            ReflectApply_Test.test7();//反射机制获取构造方法并创建对象
        }
        else {
            ClassGet.test1();
        }


    }
}








