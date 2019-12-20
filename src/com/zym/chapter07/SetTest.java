package com.zym.chapter07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhaoyimeng on 15/11/25.
 */
public class SetTest {

    public static void test_1() {

        System.out.println("---------------->Set:");
        Set set = new HashSet();

        set.add(10);
        set.add(10);

        set.add(100);
        set.add(85);
        set.add(88);

        Iterator it = set.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println("HashSet items :" + obj);
        }
        System.out.println("HashSet size :" + set.size());

    }

    /**
     * 关于HashSet中存储的元素, 该元素的HashCode和equals方法
     */
    public static void test_2() {

        System.out.println("---------------->HashSet:");
        Set<Employee> st = new HashSet<Employee>();
        Employee emp1 = new Employee("1000", "Jack");
        Employee emp11 = new Employee("1000", "Jack");
        Employee emp2 = new Employee("1001", "King");
        Employee emp3 = new Employee("2000", "Tom");
        Employee emp4 = new Employee("2001", "Sum");
        Employee emp5 = new Employee("3001", "Jame");

        st.add(emp1);
        System.out.println("emp1  hashCode = " + emp1.hashCode());
        System.out.println("emp11 hashCode = " +  emp11.hashCode());
        st.add(emp11);
        st.add(emp2);
        st.add(emp3);
        st.add(emp4);
        st.add(emp5);

        System.out.println("HashSet size = " + st.size());
    }

    /**
     * TreeSet中存储的元顺序存储
     */
    public static void test_3() {

        System.out.println("---------------->SortedSet:");

        Set s = new TreeSet();

        s.add(10);
        s.add(100);
        s.add(40);
        s.add(80);
        s.add(90);
        s.add(1);

        Iterator it = s.iterator();
        while (it.hasNext()){
            Object o = it.next();
            System.out.println("TreeSet items : " + o);
        }
        System.out.println("TreeSet size : " + s.size());

        /**
         * Date
         */

        System.out.println("---------------->SortedSet:");
        SortedSet ss = new TreeSet();
        String s1 = "2008-08-08";
        String s2 = "2008-09-08";
        String s3 = "2009-08-08";
        String s4 = "2010-08-08";
        String s5 = "2010-08-01";

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = sf.parse(s1);
            Date dt2 = sf.parse(s2);
            Date dt3 = sf.parse(s3);
            Date dt4 = sf.parse(s4);
            Date dt5 = sf.parse(s5);

            ss.add(dt1);
            ss.add(dt2);
            ss.add(dt3);
            ss.add(dt4);
            ss.add(dt5);

            it = ss.iterator();
            while (it.hasNext()){
                Object o = it.next();
                if (o instanceof Date){
                    Date tmp = (Date)o;
                    System.out.println("TreeSet items : " + sf.format(tmp));
                }
            }
            System.out.println("TreeSet size : " + ss.size());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * TreeSet中存储的元素实现Comparable
     */
    public static void test_4() {

        System.out.println("---------------->Comparable:");
        Set s = new TreeSet();

        s.add(new User(23));
        s.add(new User(32));
        s.add(new User(44));
        s.add(new User(20));
        s.add(new User(21));

        Iterator it = s.iterator();

        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
    }

    /**
     * TreeSet另外一种实现Comparable的方式
     */
    public static void test_5() {

        System.out.println("---------------->Comparator:");
        Set s = new TreeSet(new ProductComparator());

        //下面代码是内部类的实现方式:
//        Set s = new TreeSet(new Comparator() {
//                    @Override
//                    public int compare(Object o1, Object o2) {
//                        if ( (o1 instanceof Product) && (o2 instanceof Product) ){
//                           Product p1 = (Product)o1;
//                           Product p2 = (Product)o2;
//
//                            if ( p1.price > p2.price ){
//                                return 1;
//                            } else if ( p1.price < p2.price){
//                                return -1;
//                            }
//                        }
//                        return 0;
//                    }
//                });

        s.add(new Product(23.00));
        s.add(new Product(23.00));
        s.add(new Product(32.01));
        s.add(new Product(44.44));
        s.add(new Product(20.22));
        s.add(new Product(21.11));

        Iterator it = s.iterator();

        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
        System.out.println("TreeSet Size = " + s.size());
    }
}

class Product{

    double price;

    Product(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "The price is : " + price;
    }
}

class ProductComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        if ( (o1 instanceof Product) && (o2 instanceof Product) ){

            Product p1 = (Product)o1;
            Product p2 = (Product)o2;

            if ( p1.price > p2.price ){
                return 1;
            } else if ( p1.price < p2.price){
                return -1;
            }
        }
        return 0;

    }
}

class User implements Comparable{

    int age;

    User(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "User Age = " + age;
    }

    @Override
    public int compareTo(Object o) {
        if ( o instanceof User){
//            return ((User) o).age - this.age;
            return this.age - ((User) o).age;
        }
        return 0;
    }
}

class Employee{
    private String empNo;
    private String empName;

    Employee(String empNo, String empName){
        this.empName = empName;
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    /**
     * @return
     * 1. 如果不重写hashCode方法,集合中将存在重复的元素
     * 2. 散列值要均匀分布
     */
    @Override
    public int hashCode() {
        //
        return empNo.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Employee){

            Employee e = (Employee)obj;

            if ( this.empNo.equals(e.getEmpNo()) && this.empName.equals(e.getEmpName()) ){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
