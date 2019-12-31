package com.zym.chapter09;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;

/**
 * Created by zhaoyimeng on 15/11/27.
 *
 * 1. 多线程实现方式:
 *     1.1 第一种方式:(Thread)
 *         (1) 继承java.lang.Thread
 *         (2) 实现run方法;
 *
 *     1.2 第二种方式:(Runable)
 *         (1) 写一个类实现java.lang.Runable接口
 *         (2) 实现run方法;
 *
 *     1.3 推荐使用第二种方式: 因为一个类实现接口之外还保留了类的继承
 *
 * 2. 线程调度与控制:
 *     2.1 线程优先级:  1-10
 *         默认:  5
 *         最高: 10
 *         最低:  1
 *     2.2 Thread.sleep(毫秒)
 *         作用: 阻塞当前线程
 *     2.3 Thread.interrupt()中断sleep()
 *     2.3 Thread.yield
 *         作用:
 *              a. 与sleep()类似,只是不能确定暂停多长时间
 *              b. yield()静态方法只能让位同等优先级的线程执行
 *     2.3 Thread.join()
 *         作用:
 *              a. 当前调用线程处于阻塞状态,被调用线程结束后才执行当前的线程;
 * 3. 线程同步(加锁):
 *     3.1 什么时候要同步?为什么要引入同步？
 *         a. 为了数据安全.
 *     3.2 什么条件下使用同步?
 *         a. 必须是多线程环境;
 *         b. 多线程环境共享同一个数据;
 *         c. 共享数据涉及修改操作;
 *     3.3 线程中断interrupt()
 *     3.4 线程同步synchronize
 *         a. 同步语句块
 *         b. 同步方法
 *         c. 同步类
 *     3.5 线程死锁
 *
 * 4. 守护线程
 *      (1)所有用户线程生命周期结束,守护线程才会结束;
 *      (2)例如:垃圾回收器就是一个守护线程,只有应用程序中的所有线程结束后才会结束;
 *
 * 5. 定时器
 *     a. 作用: 周期性执行代码
 *
 * 6. wait & notify
 *
 * 7.备注
 * 只有两种情况可以使线程进入阻塞状态：
 *      一是等待进入synchronized块或方法；
 *      另一个是在调用wait()方法后重新进入synchronized块或方法；
 *      调用Thread.sleep()方法应该也算是一个
 *
 */


public class Chapter09 {
    public static void main(String[] args) {

//        System.out.println("Thread.MAX_PRIORITY = " +  Thread.MAX_PRIORITY);
//        System.out.println("Thread.MIN_PRIORITY = " +  Thread.MIN_PRIORITY);

//        if (true) {
        if (false) {
            //获取当前线程
            Thread thd = Thread.currentThread();
            System.out.println("Current Thread Name:" + thd.getName());
            System.out.println("Current Thread Prior:" + thd.getPriority());
            System.out.println("Current Thread State:" + thd.getState());

            /**
             * 第一种方式: 继承类Thread
             */
            //创建线程
            Thread thread = new Thread_test();
            //设置线程名字
            thread.setName("Thread()");
            thread.setPriority(1);

            //启动线程

            /**
             * 第二种方式: 实现接口Runable
             */
            Runable_test runTest = new Runable_test();
            Thread runnable = new Thread(runTest);
            runnable.setName("Runable()");
            runnable.setPriority(10);

            thread.start();
            runnable.start();

            /**
             * main()方法结束,其它线程可能还在运行
             */
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--> " + i);
            }

            thread.interrupt();//中断Thread的sleep()

            /**
             * 终止Runable线程
             */
            runTest.run = false;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----> end.....");
        }

        if (false) {
//        if (true) {
            /**
             * 原理:
             *    1. t1 和 t2 线程执行时，如果t1线程遇到了synchronized关键字,就会去找this的对象锁;
             *    2. 如果找到this对象锁,则进入同步语句块中执行程序,当同步语句块中的代码执行结束后,t1线程归还this的对象锁.
             *    3. t1线程执行同步语句块的过程中,如果t2线程也执行同步语句块中的代码,由于被t1持有,只能等到this对象锁释放后才能继续执行.
             *
             * 注意:
             *    synchronized有多种方式,具体见ThreadSync_test代码
             *
             *
             */
            Account act = new Account("TomCat", 5000);

            Thread t1 = new Thread(new ThreadSync_test(act));
            Thread t2 = new Thread(new ThreadSync_test(act));
            t1.start();
            t2.start();
        }

        /**
         *  类锁示例：
         *  thread1 和 thread2并行执行过程中，虽然执行的方法不一定
         *  但是，thread2会等待thread1执行完毕后，才会执行。因为本质上线程碰到synchronized的时候，会找this的对象锁
         */
        if (false) {
//        if (true) {
            MyClass myClass = new MyClass();
            Thread thread1 = new Thread(new Processor(myClass));
            thread1.setName("thread1");
            Thread thread2 = new Thread(new Processor(myClass));
            thread2.setName("thread2");

            thread1.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            thread2.start();

            System.out.println("public static void main()....");
        }


        /**
         *  死锁示例
         */
        if (false) {
//        if (true) {
            Object o1 = new Object();
            Object o2 = new Object();

            Thread t1 = new Thread(new DeadLock_test(o1, o2));
            Thread t2 = new Thread(new DeadLock_test2(o1, o2));

            t1.start();
            t2.start();
        }


        if (false) {
//        if (true) {
            /**
             * 守护线程示例:
             *    1. daemonThread设置为守护线程;
             *    2. 虽然daemonThread的run方法是一个无限循环,但当所有的用户线程退出时,该守护线程也照样会结束;
             */

            Thread daemonThread = new Thread(new DaemonThread_test());
            daemonThread.setDaemon(true);
            daemonThread.start();

            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + "-->" + j);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            /**
             *  Timer()定时器示例
             */
            Timer timer = new Timer();
            try {

                timer.schedule(new Timer_test(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2019-12-31 17:19:00 000"), 3 * 1000);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            System.out.println("main thread is over!!!");
        }

//        if(false){
        if (true) {

            Counter couter = new Counter();

            WaitObj t1 = new WaitObj(couter);
            try {
                t1.setDaemon(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            NotifyObj t2 = new NotifyObj(couter);

            t1.start();
            t2.start();

        }
    }
}
