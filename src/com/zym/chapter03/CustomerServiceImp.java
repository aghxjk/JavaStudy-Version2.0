package com.zym.chapter03;

/**
 * Created by zhaoyimeng on 15/11/11.
 * 该类完全面向接口去实现
 */
public class CustomerServiceImp implements CustomerService{

    @Override
    public void logout() {
        System.out.println("成功退出系统");
    }
}
