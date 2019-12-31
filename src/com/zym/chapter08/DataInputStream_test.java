package com.zym.chapter08;

import java.io.*;

/**
 * Created by zhaoyimeng on 15/11/27.
 */
public class DataInputStream_test {

    public static  String getDir(){
        return DataInputStream_test.class.getResource("").getPath();
    }

    public static void test_1() {

        System.out.println("---------------->Data输入流:test_1()");
        String fName = getDir() + "/temp08.txt";

        DataInputStream fo = null;


        try {

            fo = new DataInputStream(new FileInputStream(fName));

            /**
             * 注意:
             *     需要知道数据写入时数据类型的顺序,否则....
             */
            byte b = fo.readByte();
            short s = fo.readShort();
            int i = fo.readInt();
            long l = fo.readLong();
            float f =fo.readFloat();
            double d = fo.readDouble();
            boolean bl = fo.readBoolean();
            char c = fo.readChar();

            System.out.println("byte = " + b);
            System.out.println("short = " + s);
            System.out.println("int = " + i);
            System.out.println("long = " + l);
            System.out.println("float = " + f);
            System.out.println("double = " + d);
            System.out.println("boolean = " + bl);
            System.out.println("char = " + c);

            System.out.println("读取: temp08.txt  finshed!!!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DataInputStream_test.test_1();
    }
}
