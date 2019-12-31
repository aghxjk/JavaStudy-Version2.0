package com.zym.chapter09;

/**
 * Created by zhaoyimeng on 15/12/1.
 */
public class DaemonThread_test implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while (true){
            i++;
            System.out.println(Thread.currentThread().getName() + "-->" + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
