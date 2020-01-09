package com.zym.chapter11;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class OptionalExample {

    public void test1(List<MyCar> myCars) {
        /**
         * Optional.of()或者Optional.ofNullable()：创建Optional对象，差别在于of不允许参数是null，而ofNullable则无限制。
         */
        Optional<List<MyCar>> optional1 = Optional.of(myCars);
        Optional<List<MyCar>> optional2 = Optional.ofNullable(myCars);
        Optional<List<MyCar>> optional3 = Optional.ofNullable(null);
//        Optional<List<MyCar>> optional4 = Optional.of(null);  Exception in thread "main" java.lang.NullPointerException

        System.out.println("optional1 -- Optional.of(myCars).isPresent(): " + optional1.isPresent());
        System.out.println("optional2 -- Optional.ofNullable(myCars).isPresent(): " + optional2.isPresent());
        System.out.println("optional3 -- Optional.ofNullable(null).isPresent(): " + optional3.isPresent());
    }

    public void test2(List<MyCar> myCars) {
        List<MyCar> carList = Lists.newArrayList();

        //如果option对象保存的值不是null，则调用consumer对象，否则不调用
        Optional.ofNullable(myCars).ifPresent(carList::addAll);

        for (MyCar myCar : carList) {
            myCar.run();
        }
    }

    public static void main(String[] args) {
        List<MyCar> myCars = Lists.newArrayList();
        myCars.add(new MyCar("red"));
        myCars.add(new MyCar("orange"));
        myCars.add(new MyCar("yellow"));
        myCars.add(new MyCar("green"));
        myCars.add(new MyCar("blue"));
        myCars.add(new MyCar("cyan"));
        myCars.add(new MyCar("purple"));
        myCars.add(new MyCar());

        OptionalExample optionalExample = new OptionalExample();
        optionalExample.test2(myCars);

        System.out.println("----------------------- empty list");
        List<MyCar> myCars_empty = Lists.newArrayList();
        optionalExample.test1(myCars_empty);

        System.out.println("----------------------- myCars");
        optionalExample.test1(myCars);
    }
}
