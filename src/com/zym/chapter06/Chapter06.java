package com.zym.chapter06;

import java.time.Clock;
import java.util.Date;

/**
 * Created by zhaoyimeng on 15/11/20.
 *
 * 1. java.lang.String;是字符串类型
 *
 *    1.1. 字符串一旦创建不可改变。"abc"一旦创建不可改变为"bcd"
 *    1.2. 提升字符串访问效率: 在程序中使用了"缓存"技术. 所以使用"双引号"括起来的字符串都会在字符串常量池中创建一份。字符串常量池在方法区中被存储;
 *    1.3. 程序在执行过程中,如果程序用到某个字符串,如"abc",则会在字符串常量池中搜索,如果没有则在常量池中新建一个"abc"，如果找到则直接用;
 *
 *    a. 码点与代码单元
 *          Java字符串由char值序列组成。char是一个采用UTF-16编码表示的Unicode码点的代码单元。常用Unicode字符使用一个代码单元(2字节)就可以表示，
 *       而辅助字符需要一对代码单元表示。
 *
 * 2. 正则表达式初步:
 *
 *    2.1. 正则表达式是一门独立的学科;
 *    2.2. 正则表达式是一种字符模型,专门做字符串格式匹配;
 *    2.3. 正则表达式是通用的;
 *    例如:
 *         "^a{2}$" 以"a开始，以a"结束.表示：2个a等同于"aa"
 *         \d 数字
 *         \D 非数字
 *         \w 英文字母
 *         \W 非英文字母
 *
 * 3. 字符串字符串缓冲区
 *
 *    3.1. StringBuffer 和 StringBuilder是什么?
 *         是一个字符串缓冲区
 *    3.2 工作原理:
 *        预先申请一块内存空间,以容纳字符串序列,如果空间不够则自动化扩充.
 *
 *    3.3 它们与String的最大区别?
 *        String: 是不可变的字符序列,存在字符串常量池中;
 *        StringBuffer: 底层是一个char数组,但是该char数组是可变的,且可以自动扩容;
 *
 *    3.4 StringBuffer和StringBuilder的默认容量都是16;
 *
 *    3.5 如何优化StringBuffer和StringBuilder?
 *        最好在创建StringBuffer之前预测存储数量,然后在创建时采用指定初始化容量的方式创建StringBuffer,为了减少底层数组拷贝,提高效率.
 *
 *    3.6 StringBuffer和StringBuilder的区别?
 *         a. StringBuffer  是线程安全的。 (多线程环境下使用不会出问题)
 *         b. StringBuilder 是非线程安全的.(多线程环境下使用可能出问题)
 *
 * 4. 八种数据类型对应的包装类型
 *         基本数据类型        包装类型
 *           byte            java.lang.Byte
 *           short           java.lang.Short
 *           int             java.lang.Integer
 *           long            java.lang.Long
 *
 *           float           java.lang.Float
 *           double          java.lang.Double
 *
 *           boolean         java.lang.Boolean
 *
 *           char            java.lang.Character
 *
 * 5. 日期处理-当前系统时间
 * 6. 日历处理
 * 7. 数字格式化
 *
 * 8. 随机数
 *
 * 9. 枚举类型
 *
 */
public class Chapter06 {
    public static void main(String[] args) {



        if ( true ) {
            StringTest.test_1();
            StringTest.test_2();
            StringTest.test_3();
            StringTest.test_4();
            StringTest.test_regExp();
            StringTest.test_codePoint();

            DateTime.test_1();
            DateTime.test_2();
            DateTime.test_3();

            NumberObj.test_1();
            NumberObj.test_2();
            NumberObj.test_3();

            EnumTest.test_1();
            EnumTest.test_2();

            System.out.println(Clock.systemUTC().millis());
            System.out.println(System.currentTimeMillis());
        }
    }
}
