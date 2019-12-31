package com.zym.chapter08;

/**
 * Created by zhaoyimeng on 15/11/27.
 */
public class DecoratorClass_B implements DecoratorInterFace{

    DecoratorInterFace decoratorInterFace;

    DecoratorClass_B(DecoratorInterFace decoratorInterFace){
        this.decoratorInterFace = decoratorInterFace;
    }

    @Override
    public void close() {
        System.out.println("DecoratorClass_B close() ...");
        decoratorInterFace.close();
        System.out.println("finish ...");
    }

    public static void main(String[] args) {
        DecoratorClass_B decoratorClass_b = new DecoratorClass_B(new DecoratorClass_A());
        decoratorClass_b.close();
    }
}
