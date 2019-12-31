package com.zym.chapter09;

/**
 * Created by zhaoyimeng on 15/11/30.
 *
 * 继承Thread并实现run方法
 *
 */



public class Thread_test extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("main-->false me : " + Thread.currentThread().getName());
            }
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread_test();
        System.out.println("Current Thread Name:" + thread.getName());
        System.out.println("Current Thread Prior:" + thread.getPriority());
        System.out.println("Current Thread State:" + thread.getState());
        thread.run();
    }
}
