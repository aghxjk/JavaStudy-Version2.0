package com.zym.chapter03;

/**
 * Created by zhaoyimeng on 15/11/10.
 */
public class SuperClass {

    private String actNo;
    private double babance;

    public SuperClass(){}

    public SuperClass(String actNo, double babance){
        this.actNo = actNo;
        this.babance = babance;
    }

    public void setActNo(String actNo){
        this.actNo = actNo;
    }

    public void setBabance(double babance) {
        this.babance = babance;
    }

    public void m1(){
        System.out.println("m1........");
    }

    public void m2(){
        System.out.println("m2........");
    }
}
