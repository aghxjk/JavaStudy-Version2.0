package com.zym.chapter11;

public interface IFourWheeler {
    default void run() {
        System.out.println("FourWheeler is running...");
    }
    default void run(String color) {
        System.out.println("FourWheeler is running..." + color);
    }
    static void blowHorn () {
        System.out.println("IFourWheeler 按喇叭!!!");
    }
}
