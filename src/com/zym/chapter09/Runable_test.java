package com.zym.chapter09;

/**
 * Created by zhaoyimeng on 15/11/30.
 * 实现Runnable接口 并 实现run()方法
 */

public class Runable_test implements Runnable {

    public boolean run = true;
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if (run == false)return;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }

    public static void main(String[] args) {

        Runable_test runableTest = new Runable_test();

        // 创建线程1
        Thread thread_1 = new Thread(runableTest);
        thread_1.setName("thread_1");
        thread_1.setPriority(3);

        // 创建线程2
        Thread thread_2 = new Thread(runableTest);
        thread_2.setName("thread_2");
        thread_2.setPriority(4);

        // 启动线程
        thread_1.start();
        thread_2.start();

        // 主线程
        runableTest.run();
    }
}
