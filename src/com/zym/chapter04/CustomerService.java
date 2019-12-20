package com.zym.chapter04;

/**
 * Created by zhaoyimeng on 15/11/13.
 */
public class CustomerService {

    public void redister(String name) throws IllegalNameExp{

        if (name.length() < 6){
            throw new IllegalNameExp(name, -1);
        }

    }
}
