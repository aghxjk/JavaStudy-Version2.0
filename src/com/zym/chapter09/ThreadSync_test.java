package com.zym.chapter09;

/**
 * Created by zhaoyimeng on 15/11/30.
 */
public class ThreadSync_test implements Runnable{

    Account account;

    public ThreadSync_test(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
//        account.withdraw(1000.0);
        account.withdrawSync(1000.0);
        System.out.println("取款成功:1000,余额: " +  account.getBalance());
    }
}

/**
 * 对象锁
 */
class Account{

    private String name;
    private double balance;

    public Account() {
    }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double money){

        /**
         * 该方式同步的代码比较精细,效率比withdrawSync要高.
         */

        //同步处理
        synchronized (this) {

            double after = balance - money;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }
    }

    public synchronized void withdrawSync(double money){

        double after = balance - money;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setBalance(after);
    }
}

/**
 * 类锁:  与对象无关
 * 特点:  static 方法被synchronize修饰
 *
 */
class Processor implements Runnable{

    MyClass myclass;

    public Processor(MyClass myclass) {
        this.myclass = myclass;
    }

    @Override
    public void run() {
        if ("thread1".equals(Thread.currentThread().getName())){
            myclass.fun();
        }

        if ("thread2".equals(Thread.currentThread().getName())){
            myclass.m1();
        }
    }
}

class MyClass {

    public synchronized void fun(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println("public synchronized void fun()....");
            }
        } catch (InterruptedException e) {
            System.out.println("func()....");
        }
    }

    public synchronized void m1(){
        System.out.println("public synchronized void m1()....");
    }
}


