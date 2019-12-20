package com.zym.chapter07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by zhaoyimeng on 15/11/26.
 */
public class PropertiesTest {

    public static void test_1() {

        System.out.println("---------------->HashMap:");
        System.out.println(PropertiesTest.class.getSimpleName());
        String dir = "";
        File directory = new File("src/com/zym/chapter07/" + PropertiesTest.class.getSimpleName()+".java"); //设定为当前文件夹
        try{
            String filePath = directory.getCanonicalPath();
            dir = filePath.substring(0, filePath.lastIndexOf("/"));
        }catch (IOException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        Properties properties2 = new Properties();

        FileInputStream fis = null;
        try {

            /**
             *  1. 配置文件中有重复的Key时会被覆盖.
             *  2. 配置文件的key和value之间可以使用 "空格", "冒号", "等号"
             *  3. 如果"空格", "冒号", "等号"都有,按最前面的作为分隔符
             *  4. 属性配置文件java标准规范文件后缀为: properties
             *  5. 如果配置文件中有中文,需要转义
             *  6. properties文件以‘#’符号进行注释
             */
            String fileName = dir +"/tmpProperties.properties";
            fis = new FileInputStream(fileName);
            properties2.load(fis);
            System.out.println(fileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        properties.setProperty("userName", "admin");
        properties.setProperty("passWord", "admin");
        properties.setProperty("url", "jdbc:oracle:thin:@192.168.1.1:1521:dbName");

        String val1 = properties.getProperty("driver");
        String val2 = properties.getProperty("userName");
        String val3 = properties.getProperty("passWord");
        String val4 = properties.getProperty("url");

        System.out.println("driver = " + val1);
        System.out.println("userName = " + val2);
        System.out.println("passWord = " + val3);
        System.out.println("url = " + val4);

        System.out.println("--------->从properties文件获取配置信息");
        System.out.println("userName = " + properties2.getProperty("userName"));
        System.out.println("passWord = " + properties2.getProperty("passWord"));

    }
}
