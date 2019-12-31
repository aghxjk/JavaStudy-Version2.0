package com.zym.chapter10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Properties;

/**
 * Created by zhaoyimeng on 15/12/2.
 */
public class ReflectApply_Test {

    public static Properties properties = new Properties();
    public static FileReader fileReader = null;

    public static  String getDir(){
        return ReflectApply_Test.class.getResource("/").getPath() + "/com/zym/properties/";
    }

    public static void loadProperties() {

        System.out.println("-------------->反射机制应用");
        try {

            String fileName = getDir() + "classInfo.properties";
            System.out.println(fileName);
            fileReader = new FileReader(fileName);

            properties.load(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("载入classInfo.properties失败!!!!!!!!");
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *  Field.getName获取public属性
     */
    public static void test1() {
        loadProperties();

        String className = properties.getProperty("className");
        System.out.println("ClassName = " + className);

        Class c;

        try {

            c = Class.forName(className);
            Object o = c.newInstance();
            System.out.println("Object = " + o);

            System.out.println("--------");
            Field[] fields = c.getFields();
            for (Field f : fields){
                System.out.println(f.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     *  1. 反编译拿出*.class字节码文件中的属性
     *  2. Class.getDeclaredFields获取所有属性
     */
    public static void test2() {
        loadProperties();

        String className = properties.getProperty("className");
        Class c;
        StringBuffer strBuffer = new StringBuffer();

        try {

            c = Class.forName(className);
            Field[] fields = c.getDeclaredFields();

            strBuffer.append( Modifier.toString(c.getModifiers()) + " class " + c.getName() + "{\n");

            for (Field f:fields){
                strBuffer.append("\t");
                strBuffer.append(Modifier.toString(f.getModifiers()) + " " + f.getType() + " " + f.getName() + ";\n");
            }
            strBuffer.append("}");

            System.out.println(strBuffer);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  1. 通过反射机制给对象属性赋值
     *  2. 可以给private属性赋值
     */
    public static void test3() {

        System.out.println("----------->反射机制给对象赋属性值");
        loadProperties();

        String className = properties.getProperty("className");
        Class c;

        try {

            c = Class.forName(className);
            Object obj = c.newInstance();

            Field field_name = c.getField("name");
            field_name.set(obj, "xiaoMing");

            Field field_id = c.getDeclaredField("id");
            field_id.setAccessible(true);
            field_id.set(obj, "13011119111111");

            System.out.println(field_name.get(obj));
            System.out.println(field_id.get(obj));
            // 第二种方式
            User user = (User)obj;
            System.out.println(user.name);
            System.out.println(user.age);
            System.out.println(user.getId());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     *  反编译获取类的所有方法示例
     */
    public static void test4() {

        System.out.println("----------->反编译获取类方法示例");
        try {

//            Class cls = Class.forName("chapter10.CustomerService");
            Class cls = Class.forName("java.util.Date");
            Method[] methods = cls.getDeclaredMethods();
            StringBuffer strBuffer =  new StringBuffer();

            strBuffer.append(Modifier.toString(cls.getModifiers()) + "class " + cls.getName() + "{\n");

            for (Method m : methods){
                strBuffer.append("\t" + Modifier.toString(m.getModifiers()) + " " + m.getName() + "(");
//                System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getGenericReturnType() + " " + m.getName());
                Class[] pc = m.getParameterTypes();
                int i=0;
                for (Class c : pc){
                    i++;
                    if (pc.length != i) {
                        strBuffer.append(c.getSimpleName() + ", ");
                    } else {
                        strBuffer.append(c.getSimpleName());
                    }
                }
                strBuffer.append("){}\n");
            }
            strBuffer.append("}");

            System.out.println(strBuffer);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  通过反射机制执行某个特定方法
     */
    public static void test5() {

        System.out.println("----------->反射机调用方法示例");

        try {

            Class cls = Class.forName("chapter10.CustomerService");
            Object obj = cls.newInstance();
            Method method = cls.getDeclaredMethod("login", String.class, String.class);

            Object retVal = method.invoke(obj, "admin", "123");

            System.out.println("lonin : " + retVal);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     *  反编译构造方法
     */
    public static void test6() {

        System.out.println("----------->反射机获取构造方法示例");
        StringBuffer strBuffer = new StringBuffer();

        try {

            Class aClasss = Class.forName("java.lang.String");
            Constructor[] constructors = aClasss.getConstructors();

            strBuffer.append(Modifier.toString(aClasss.getModifiers()) + " class " + aClasss.getSimpleName() + "{\n");

            for (Constructor c : constructors){
                strBuffer.append("\t" + Modifier.toString(c.getModifiers()) + " " + aClasss.getSimpleName() + "(");
                Class[] pc = c.getParameterTypes();
                int i=0;
                for (Class p : pc){
                    i++;
                    if (i != pc.length) {
                        strBuffer.append(p.getSimpleName() + ", ");
                    } else {
                        strBuffer.append(p.getSimpleName());
                    }
                }
                strBuffer.append(")\n");
            }
            strBuffer.append("}");
            System.out.println(strBuffer);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  使用反射机制获取构造方法并创建对象
     */
    public static void test7() {

        System.out.println("----------->反射机获取构造方法并创建对象");

        try {

            Class aClass = Class.forName("chapter10.User");

            //获取带参数的构造方法
            Constructor constructor = aClass.getConstructor(String.class);

            //创建实例
            Object object = constructor.newInstance("Administrator");
            System.out.println(object.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReflectApply_Test.test3();
    }
}

class CustomerService{

    public boolean login(String name, String pwd){
        if ("admin".equals(name) && "123".equals(pwd) ){
            return true;
        }
        return false;
    }

    public void logout() {
        System.out.println("Welcome to again!!!");
    }
}
