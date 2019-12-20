package com.zym.chapter03;

import com.zym.chapter03.Car.Car;
import com.zym.chapter03.Car.HONDA;
import com.zym.chapter03.Car.YAMAHA;

/**
 * Created by zhaoyimeng on 15/11/9.
 *
 * 1. 关于java类的构造方法
 *      a.构造方法语法
 *          [修饰符列表] 构造方法名(形参){
 *              方法体;
 *          }
 *      c.构造方法的名字必须和类名一致
 *      d.构造方法作用：
 *          第一：可以创建对象
 *          第二：初始化成员变量
 *      e.如何调用：
 *          new + 构造方法名(实参); 在堆中开辟空间存储对象
 *
 *      f. 如果一个类没有提供构造方法，系统默认提供无参构造方法。
 *          如果一个类已经手动提供了构造方法，那么系统不会再提供任何构造方法。
 *
 * 2. java虚拟机内存管理（深入java虚拟机第五章）
 *      a.方法区：类的所有信息，包括所有方法，静态变量，常量
 *      b.栈  区：每调用一个方法，会创建一个桟帧，存放局部变量
 *      c.堆  区：存放new出来的对象，此对象由垃圾收集器收集，垃圾收集器针对的是堆区
 *
 * 3. 程序在执行过程中，参数的传递问题：
 *      a.传递的数据是基本数据类型：
 *      b.传递的数据是引用数据类型：
 *
 * 4. 关于this指针
 *      a. 静态方法不需要java对象存在，直接使用类名.  的方法访问
 *      b. 而this代表的是当前对象，所以静态方法中根本没有this
 *      c. this可以用在构造方法中:
 *          this(参数);  目的是代码重用
 *          this(参数);  必须出现在构造函数的第一行
 *
 * 5. static关键字:
 *      a.static修饰的变量叫：静态变量
 *          (1)存储在方法区
 *          (2)被所有对象共享
 *      b.static修饰的方法叫：静态方法
 *          (1)可以使用"类型."方式调用
 *          (2)静态方法中不能直接访问非静态数据
 *          (3)静态方法中不能使用this
 *          (4)空引用访问成员时会报空指针异常，访问静态方法不会
 *      c.static还可以修饰语句块: 在类加载阶段执行，并且只执行一次
 *
 * 6. 关于实例语句块
 *      a.每次调用构造函数之前调用实例语句块
 *      b.实例语句块顺序执行
 *
 * 7.单例模式《java与模式》
 *      a.保证java虚拟机中只有一个实例
 *      b.节省内存开销
 *
 *      c.缺点:
 *           1.单例模式类型无法被继承，因为单例模式的类构造函数私有化
 *
 * 8. 类继承最基本的作用: 代码重用
 *    语法:
 *        [修饰符列表] class 子类名 extends 父类名
 *
 *    a. 类和类之间只能单继承
 *    b. 一个类没有显示的继承其它类，则该类默认继承Object
 *    c. 子类会继承父类的全部数据
 *    d. 子类无法访直接问父类私有数据，但可以间接访问
 *
 * 9. 方法覆盖
 *    9.1. 什么时候需要重写(overwrite override)?
 *          a. 父类方法无法满足当前子类业务需求；
 *          b. 子类重写父类方法后，子类对象一定调用的是重写之后的方法
 *
 *    9.2. 发生方法覆盖的条件
 *          a. 具有继承关系的两个类之间
 *          b. 必须具有相同的方法名、返回值类型、参数列表
 *          c. 重写方法不能比被重写方法具有更低的访问权限
 *          d. 重写方法不能比被重写方法抛出更宽泛的异常
 *          e. 私有的方法不能被覆盖
 *          f. 构造方法无法被覆盖
 *          g. 静态方法不存在覆盖
 *          h. 覆盖指的是成员方法，和成员变量无关
 *
 * 10.多态
 *    a. 项目的扩展能力增强
 *    b. 降低代码之间的耦合度
 *
 *
 *    10.1. 向上转型(upcasting)  : 子-->父
 *    10.2. 向下转型(downcasting): 父-->子
 *    注意:  两个转型都需要两个类之间需要有继承关系
 *
 *    10.3 super关键字
 *         1. super不是引用类型，存储的不是内存地址，指向的不是父类的对象；
 *         2. super代表的是当前子类对象的父类特征
 *    10.4 什么时候使用super?
 *         1. 子类父类都有某个数据
 *         2. 子类要访问父类中的同名数据
 *    10.5 super用在什么地方?
 *         1. 可以用在成员方法中,不用在静态方法中
 *         2. 可以用在构造方法中
 *             a. 通过子类构造方法去调用父类构造方法
 *             b. 对super的调用必须是构造函数的第一个语句
 *             c. super 和 this 不能共存(this 也只能出现在构造函数第一行)
 *             d. super构造函数执行后，不会创建对象
 *
 *    备注：
 *         a. this 和 super相同，都不能用在静态上下文中
 *         b. 在java语言中,只要创建对象,那么Object无参构造方法一定会执行,但构造方法执行不一定会创建对象
 *
 * 11.final关键字
 *   a. final修饰的类无法被继承
 *   b. final修饰的方法无法被覆盖
 *   c. final修饰的局部变量,一旦被赋值,不可再改变
 *   d. final修饰的成员变量必须"显示的"初始化,即：在构造函数调用介绍前必须赋值
 *   e. final修饰的成员变量一般和public static关键字连用,没必要让每一个对象都有一份final数据成员
 *   f. final修饰的引用类型,该引用不可再重新指向其它java对象,但final修饰的引用,该引用指向的对象属性是可以修改的
 *
 * 12.抽象类abstract class
 *     12.1. 如何定义抽象类: class 关键字前加abstract
 *     12.2. 抽象类无法被实例化
 *     12.3. 虽然抽象类无法被实例化,但抽象类有构造函数,该构造函数给子类用
 *     12.4. 抽象类中可以定义抽象方法
 *           语法：在方法修饰符列表中添加abstract关键字,并且抽象方法以";"结束,不能带有"{}"
 *     12.5. 抽象类中不一定有抽象方法,但抽象方法必须出现在抽象类中.
 *     12.6. 非抽象类继承抽象类,必须将抽象类中的抽象方法实现、覆盖、重写.
 *     12.7. 抽象类不能被final修饰
 *
 * 13.接口interface,也是一种引用类型
 *     13.1. 如何定义接口,语法:
 *           [修饰符] interface 接口名{}
 *     13.2. 接口中只能出现: 常量(interface成员变量都必须是public static final)、抽象方法
 *     13.3. 接口是一个特殊的抽象类,特殊在接口是完全抽象的
 *     13.4. 接口没有构造方法,接口无法被实例化
 *     13.5. 接口和接口之间可以多继承
 *     13.6. 一个类可以实现多个接口
 *     13.7. 一个非抽象的类实现接口,需要将接口中的所有方法: 实现/重写/覆盖
 *
 *     接口作用:
 *         a. 可以使项目分层,所有分层都面向接口开发,开发效率提高
 *         b. 接口使代码直接的耦合度降低,像主板一样可插拔,可任意更换内存
 *
 * 14.finalize关键字
 *     14.1 finalize什么时候调用?
 *          a. finalize 方法每个java对象都有
 *          b. finalize 方法不需要程序员去调用,由系统自动调用
 *          c. java对象如果没有更多的引用指向它,则该对象成为垃圾数据,等待垃圾回收器回收,垃圾回收器在回收此对象之前会自动化调用finalize方法.
 *
 * 15.软件包机制
 *     15.1. 为了解决类的命名冲突问题,在类名前加命名空间(包机制)
 *     15.2. 在java中使用package语句定义包.(单包,复包)
 *     15.3. package语句只能出现在java源文件的第一行
 *     15.4. package定义格式通常采用公域名倒序方式
 *     15.5. 完整的类名是带有包名的
 *
 * 16.访问权限控制
 *     |-----------------------------------------------------|
 *     |  修饰符  |  类的内部  |  同一个包内  |  子类  |  任何地方  |
 *     | private |    Yes   |     No     |   No   |    No    |
 *     | default |    Yes   |     Yes    |   No   |    No    |
 *     |protected|    Yes   |     Yes    |   Yes  |    No    |
 *     | public  |    Yes   |     Yes    |   Yes  |    Yes   |
 *     |-----------------------------------------------------|
 *
 *
 *
 */

class Student{
    Student(){
        this("default", 10, true);
        System.out.println("construct function");
    }

    Student(String name, int age, boolean sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    static {
        System.out.println("static block");
    }

    {
        System.out.println("instance block 1");
    }

    {
        age = 0;
        System.out.println("instance block 2");
    }

    String  name;
    int     age;
    boolean sex;

    static void basicDataType(int i){
        i++;
        System.out.println("basicDataType: i=" + i);
    }
}

/**
 * 单例模式要领:
 *      1.构造方法私有化；
 *      2.对外提供一个公开静态的获取当前类对象的方法;
 *      3.提供一个当前类型的静态变量;
 *
 * 单例模式分两种
 *      1.懒汉式单例：用到的时候才创建对象
 *      2.饿汉式单例：类加载的时候就创建对象
 */

/**
 * 懒汉式单例模式
 */
class Singleton{

    private static Singleton sl = null;
    private Singleton(){
    }

    public static Singleton getInstance(){
        if(sl==null){
            sl = new Singleton();
        }
        return sl;
    }
}

/**
 * 饿汉式单例模式
 */
class Singleton2{

    private static Singleton2 sl = new Singleton2();

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        return sl;
    }
}


public class Chapter_03 {
    public static void main(String args[]){

        Student st1 = new Student();
        st1.name = "name";

        /**
         * 构造方法及程序执行过程
         */
        int i = 10;
        Student.basicDataType(i);
        System.out.println("main: i=" + i);
        System.out.println("--------------->构造方法及程序执行过程");
        Student st2 = new Student();
        if (st2==null) {
            System.out.println("Student is null ");
        }

        /**
         * 单例模式 懒汉式
         */
        System.out.println("--------------->单例模式,懒汉式");
        Singleton sl1 = Singleton.getInstance();
        Singleton sl2 = Singleton.getInstance();
        System.out.println("懒汉式: " + (sl1==sl2));

        /**
         * 单例模式 饿汉式
         */
        System.out.println("--------------->单例模式,饿汉式");
        Singleton2 sl3 = Singleton2.getInstance();
        Singleton2 sl4 = Singleton2.getInstance();
        System.out.println("饿汉式: " + (sl3==sl4));

        /**
         * 类继承示例
         */

        System.out.println("--------------->类继承示例");
        SubClass sb = new SubClass("zym", 1.5);
        sb.m1();
        sb.m2();
        sb.m3();

        sb.setActNo("yimeng.zhao");
        sb.setBabance(1000000.0);

        /**
         * 方法覆盖示例
         */
        System.out.println("--------------->方法覆盖");
        Cat ct = new Cat();
        ct.move();

        Animal al = new Animal();
        al.move();

        /**
         * 向上转型(自动类型转换)
         * 1. 父类型的引用指向子类型的对象
         * 2. 程序编译阶段只知道a1是一个Animal类型
         * 3. 程序运行阶段的时候，堆中的实际对象是Cat类型
         */

        System.out.println("--------------->向上转型");
        //程序在编译阶段a1引用绑定的是Animal类中的eat方法(静态绑定)
        //程序在运行的时候,堆中的对象实际上是Cat类型,而Cat已经重写了eat方法
        //程序在运行阶段，程序绑定的方法是Cat中的eat方法(动态绑定)
        Animal  cat1 = new Cat();
        cat1.eat();

        /**
         * 向下转型
         * 1. 强制类型转换存在风险
         * 2. 为了避免ClassCastException异常，java引入了instanceof
         * 用法：
         *    a. instanceof运算符的运算结果是 boolean 类型
         *    b. (引用 instanceof Cat) --> true/false
         */

        System.out.println("--------------->向下转型");
        //要执行move方法,怎么做？
        //只能强制类型转换
        Animal  a2 = new Dog();

        Dog     dog1 = (Dog)a2;
        dog1.dogCry();


        // Exception in thread "main" java.lang.ClassCastException: chapter03.Dog cannot be cast to chapter03.Cat
        // 为了避免这个Exception，引入了instanceof
        Animal  a3 = new Dog();
        if (a3 instanceof Cat){
            Cat     cat2 = (Cat)a3;
            cat2.move();
        }else {
            System.out.println("强制类型转换失败....");
        }


        /**
         * 多态示例
         */
        System.out.println("--------------->多态示例");
        Person ps = new Person();
        ps.feed(dog1);
        ps.feed(cat1);

        /**
         * 面向接口的编程
         */
        System.out.println("--------------->面向接口编程");
        CustomerService  cs = new CustomerServiceImp();
        cs.logout();

        YAMAHA yamaha = new YAMAHA();
        Car car1 = new Car(yamaha);
        car1.testEngin();

        HONDA honda = new HONDA();
        Car car2 = new Car(honda);
        car2.testEngin();
        System.out.println(car2.getClass().getName());
        System.out.println(car2.hashCode());
        System.out.println(car1.hashCode());


        /**
         * finalize方法
         */
        System.out.println("--------------->垃圾回收器");

    }
}



