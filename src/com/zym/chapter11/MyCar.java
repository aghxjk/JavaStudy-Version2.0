package com.zym.chapter11;

/**
 *  MyCar 实现了接口IVehicle 和 IFourWheeler,
 *  1. 这两个接口有相同的default void run()方法,
 *  2. MyCar需要重写run()并指定使用哪个接口的default方法，否则会编译出错
 */
public class MyCar implements IVehicle, IFourWheeler {
    @Override
    public void run() {
        IFourWheeler.super.run();
    }
}
