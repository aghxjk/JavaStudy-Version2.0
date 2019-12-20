package com.zym.chapter03.Car;

/**
 * Created by zhaoyimeng on 15/11/11.
 */
public class Car {

    Engine eg;
    public Car(Engine eg){
        this.eg = eg;
    }

    public void testEngin(){
        eg.start();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Car对象将要被回收...");
        super.finalize();
    }
}
