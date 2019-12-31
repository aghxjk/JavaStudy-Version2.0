package com.zym.chapter09;

/**
 * Created by zhaoyimeng on 15/12/1.
 */
public class DeadLock_test implements Runnable{

    Object obj1 = new Object();
    Object obj2 = new Object();

    public DeadLock_test(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj1){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (obj2){

            }
        }
    }
}

class DeadLock_test2 implements Runnable{

    Object obj1;
    Object obj2;

    public DeadLock_test2(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj2){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (obj1){

            }
        }
    }
}
