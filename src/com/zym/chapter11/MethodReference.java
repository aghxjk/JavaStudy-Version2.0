package com.zym.chapter11;

import java.util.ArrayList;


public class MethodReference {
    public static void main(String[] args) {
        MethodReference.test();
    }

    public static void test() {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // 构造方法引用
            System.out.println("-----构造方法引用:");
            Car car = Car.create(String.valueOf(i), Car::new); // 同 Car car = new Car();
            cars.add(car);
        }
        Car car = new Car();
        cars.add(car);

        // 类的实例方法引用
        System.out.println("-----类的实例方法引用:");
        cars.forEach(Car::showCar);

        // 静态方法引用
        System.out.println("-----静态方法引用:");
        cars.forEach(Car::collide);

        // 实例上的实例方法引用
        System.out.println("-----实例上的实例方法引用:");
        final Car police = new Car("Police");
        cars.forEach(police::follow);


    }

    @FunctionalInterface
    interface Factory<T> {
        T init(String color);
    }

    static class Car {
        public String getColor() {
            return color;
        }

        String color;
        public Car() {
            this("default color");
        }
        public Car(String color) {
            this.color = color;
        }
        public void showCar() {
            System.out.println(this.toString());
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.getColor());
        }

        public static Car create(String color,Factory<Car> factory) {
            return factory.init(color);
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.getColor());
        }

        @Override
        public String toString() {
            return "Car{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }
}
