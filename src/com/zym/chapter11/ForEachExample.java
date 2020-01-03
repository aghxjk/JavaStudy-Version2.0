package com.zym.chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ForEachExample {
    private List<Character> list = new ArrayList<>();

    /**
     * 随机初始化20个整数,范围对应ASCII的65(A)~90(Z)
     */
    public ForEachExample() {
        for (int i=0; i < 20; i++ ){
            // A-Z总共26个英文字符，A对应的ASCII整数值为65
            list.add( (char) (65 + Math.random() * 26)) ;
        }
    }

    /**
     * 使用List.forEach()方法,将大写字符转换为小写
     */
    public void test1() {
        AtomicInteger flag = new AtomicInteger();
        list.forEach((c) -> {
            flag.addAndGet(1);
            if (20  == flag.get()) {
                System.out.println((char)(c + 32));
            } else {
                System.out.print((char)(c + 32) + ",");
            }
        });
    }

    /**
     * 使用List.stream示例
     */
    public void test2() {
        System.out.println("-----------stream & filter & map & distinct & sorted & forEach");
        list.stream().filter(c -> c > 'M').distinct().map(s -> Character.toLowerCase(s)).sorted().forEach(System.out::println);
        System.out.println("-----------stream & filter & map & distinct & sorted & collect:");
        String string = list.stream().filter(c -> c > 'M').map(s -> String.valueOf(Character.toLowerCase(s))).distinct().sorted().collect(Collectors.joining(", "));
        System.out.println(string);
    }

    public static void main(String[] args) {
        ForEachExample forEachExample = new ForEachExample();
        forEachExample.test1();
        forEachExample.test2();
    }
}
