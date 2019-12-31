package com.zym.chapter09;

/**
 * Created by zhaoyimeng on 15/12/1.
 */

class WaitObj extends Thread{

    Counter counter;

    public WaitObj(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (counter){
                try {
                    counter.wait();
                    counter.add();
                    System.out.println("1111-->" + counter.getCout());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class NotifyObj extends Thread{

    Counter counter;

    public NotifyObj(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        for (int i=0; i<10; i++) {

            synchronized (counter){
                counter.add();
                System.out.println("2222-->" + counter.getCout());
                counter.notify();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Counter{
    int cout;

    public Counter() {
        this.cout = 0;
    }

    public void add(){
        cout++;
    }

    public int getCout() {
        return cout;
    }
}

