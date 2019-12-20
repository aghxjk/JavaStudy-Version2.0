package com.zym.chapter03;

/**
 * Created by zhaoyimeng on 15/11/10.
 */
class Animal {

    Animal(){
        System.out.println("Animal created.....");
    }

    public void move(){
        System.out.println("Animal moving....");
    }

    public void eat(){
        System.out.println("Animal eating....");
    }
}

class Cat extends Animal{

    Cat(){
        super();
        System.out.println("Cat created....");
    }

    @Override
    public void move(){
        System.out.println("Cat moving....");
    }

    @Override
    public void eat() {
        System.out.println("Cat eat....");
    }
}

class Dog extends Animal{

    Dog(){
        super();
        System.out.println("dog created...");
    }

    @Override
    public void move() {
        System.out.println("Dog moving....");
    }

    @Override
    public void eat() {
        System.out.println("Dog eating....");
    }

    public void dogCry(){
        System.out.println("dog crying....");
    }
}
