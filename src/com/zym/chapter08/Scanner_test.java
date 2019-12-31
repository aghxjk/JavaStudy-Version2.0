package com.zym.chapter08;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Scanner_test {
    public static void test_1() {
        Scanner scanner = null;
        try {
            String string;
            scanner = new Scanner(Paths.get(BufferedReader_test.getDir()+"/temp06.txt"), "UTF-8");
            while (scanner.hasNext()) {
                string = scanner.nextLine();
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
            scanner.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(Paths.get(BufferedReader_test.getDir()));
        Scanner_test.test_1();
    }
}
