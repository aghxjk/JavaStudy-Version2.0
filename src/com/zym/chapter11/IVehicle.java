package com.zym.chapter11;

/**
 * 接口的默认方法是通过default关键字。
 * 因此，在Java8中接口能够包含抽象方法外还能够包含若干个默认方法（即有完整逻辑的实例方法）。
 * 可以被接口的实现者实例直接调用(见RedCar示例)。
 */
public interface IVehicle {
    default void run() {
        System.out.println("Vehicle is running...");
    }
    static void blowHorn () {
        System.out.println("IVehicle 按喇叭!!!");
    }
}
