package com.zym.chapter08;

/**
 * Created by zhaoyimeng on 15/11/27.
 */
public class DecoratorClass_A implements DecoratorInterFace{
    @Override
    public void close() {
        System.out.println("DecoratorClass_A close() ...");
    }
}
