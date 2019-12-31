package com.zym.chapter08;


import java.util.Scanner;

/**
 * Created by zhaoyimeng on 15/11/27.
 *
 * 1. java.io.核心IO流
 *          |--InputStream(Abstract) Implements Closeable
 *          |     |--FileInputStream         <--->      字节byte流操作
 *          |     |--FilterInputStream(不常用)
 *          |            |--BufferedInputStream
 *          |            |--DataInputStream
 *          |     |--ObjectInputStream
 *          |
 *          |--OutputStream(Abstract) Implements Closeable, Flushable
 *          |     |--FileOutputStream       <--->       字节byte流操作
 *          |     |--FilterOutputStream(不常用)
 *          |            |--BufferedOutputStream
 *          |            |--DataOutputStream
 *          |            |--PrintStream
 *          |     |--ObjectOutputStream
 *          |
 *          |--Reader(Abstract) Implements Closeable
 *          |     |--InputStreamReader      <--->      字符char流操作
 *          |            |--FileReader      <--->      字符char流操作
 *          |     |--BufferedReader         <--->      带缓冲区的字符char流操作
 *          |
 *          |--Writer(Abstract) Implements Closeable, Flushable
 *          |     |--OutputStreamWriter     <--->      字符char流操作
 *          |            |--FileWriter      <--->      字符char流操作
 *          |     |--BufferedWriter         <--->      带缓冲区的字符char流操作
 *          |     |--PrintWriter
 *
 * 2. 文件字节输入流(FileInputStream_test)
 * 3. 文件字节输出流(FileOutputStream_test)
 * 4. 文件复制(FileOutputStream_test)
 *
 * 5. 文件字符输入流(FileReader_test)
 * 6. 文件字符输出流(FileWriter_test)
 * 7. 文件复制(FileWriter_test)
 *
 * 8. 带缓冲区的Reader(BufferedReader_test)
 * 9. 带缓冲区的Writer(BufferedWriter_test)
 * 10.  装饰者模式(DecoratorPattern)
 *         1. 需要有一个公共接口例如: Interface;
 *         2. 有两个类分别实现了Interface接口;
 *         3. 两个类间的关系见代码DecoratorClass_B
 *
 * 11. 数字输入输出流(DataOutputStream_test)
 * 12. 输入输出流(PrintStream_test)
 * 13. Object序列化
 *         1.序列化的对象需要实现serializable接口
 *           注意：
 *               (1)该接口没有任何方法,是一个标识接口
 *               (2)像这样的接口还有:Cloneable
 *         2.标识接口作用:
 *             (1)起到标识的作用;
 *             (2)JVM看到该对象实现了某个标识接口,会对它特殊待遇.
 *                特殊待遇: JVM会给该类添加一个属性, Static final long serialVersionUID = ???
 *         3.可以通过关键字transient选择性排除待序列化的属性
 *
 * 14. File类:
 *         1. File类和流无关,不能通过该类实现文件的读和写;
 *         2. File是文件和目录路径名的抽象表示形式;
 *         3. File代表的是硬盘上的Directory和file
 *
 *
 *
 *
 *
 */


public class Chapter08 {
    public static void main(String[] args) {

        if ( false ) {

            /**
             * 使用java.util.Scanner读取文本文件
             */
            Scanner_test.test_1();
            System.out.println(BufferedReader_test.getDir());
            System.out.println(System.getProperty("user.dir"));

            /**
             * File 文件操作：
             * 1. 判断文件是否存在
             * 2. 创建目录 & 创建文件
             * 3. 递归删除目录 & 文件
             */
            File_test.test_1();

            /**
             * 按byte读取文件内容
             * 以指定长度的byte[]读取文件内容
             */
            FileInputStream_test.test_1();//文件输入流示例
            FileInputStream_test.test_2();//文件输入流示例
            FileInputStream_test.test_3();//文件输入流示例

            /**
             *  按bytes写文件
             *  按bytes实现文件的拷贝
             */
            FileOutputStream_test.test_1();//文件输出流示例
            FileOutputStream_test.test_2();//文件复制

            /**
             * 以指定长度的字符流数组 char[] 读取文件
             */
            FileReader_test.test_1();//文件字符输入流

            /**
             *  以字符串 String 方式写文件
             *  以字符数组 char[] 方式拷贝文件
             */
            FileWriter_test.test_1();//文件字符写入流
            FileWriter_test.test_2();//文件字符写入流

            /**
             * 字符文件输入流装饰者模式示例
             * 带缓冲区的字符文件写入示例
             */
            BufferedReader_test.test_1();//带缓冲区的Reader(BufferedReader_test)
            BufferedReader_test.test_2();//带缓冲区的Reader(BufferedReader_test)
            BufferedReader_test.test_3();//带缓冲区的Reader(BufferedReader_test)

            /**
             * 字符文件输出流装饰者模式示例
             * 带缓冲区的字符文件读取示例
             */
            BufferedWriter_test.test_1();//带缓冲区的Writer(BufferedWriter_test)
            BufferedWriter_test.test_2();//带缓冲区的Writer(BufferedWriter_test)

            /**
             * 装饰者模式演示
             */
            DecoratorClass_B decB = new DecoratorClass_B(new DecoratorClass_A());
            decB.close();

            /**
             * 带数据类型的输入输出流
             */
            DataOutputStream_test.test_1();//Data输出流,文件是乱码的，因为附带了数据类型
            DataInputStream_test.test_1();//Data输入流

            /**
             * System.out.println();
             * 将上面的终端输出重定向到文件中
             */
            PrintStream_test.test_1();//重定向输出流到文件

            /**
             * 对象序列化 与 反序列化
             */
            ObjectOutputStream_test.test_1();//对象序列化输出到文件
            ObjectInputStream_test.test_1();

        } else {
        }
    }

}
