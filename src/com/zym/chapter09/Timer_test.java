package com.zym.chapter09;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created by zhaoyimeng on 15/12/1.
 */
public class Timer_test extends TimerTask{
    @Override
    public void run() {
        System.out.println("当前时间 : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
    }
}
