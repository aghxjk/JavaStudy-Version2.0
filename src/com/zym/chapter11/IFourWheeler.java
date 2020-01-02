package com.zym.chapter11;

public interface IFourWheeler {
    default void run() {
        System.out.println("FourWheeler is running...");
    }
    static void blowHorn () {
        System.out.println("IFourWheeler 按喇叭!!!");
    }
}
