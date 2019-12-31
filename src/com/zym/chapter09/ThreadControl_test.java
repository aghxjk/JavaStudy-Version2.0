package com.zym.chapter09;

/**
 * Created by zhaoyimeng on 15/11/30.
 */
public class ThreadControl_test implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
