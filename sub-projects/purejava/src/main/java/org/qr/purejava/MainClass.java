package org.qr.purejava;

import org.apache.commons.lang3.StringUtils;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("welcome!!");
        sayHello("Lucy");
    }

    public static void sayHello(String name) {
        System.out.println("Hi " + name);

        String origin = "5dec49416b1ec811f4770f94f6d7e6c0e6befa74";
        String after = StringUtils.upperCase(origin);

        System.out.println(after);
    }
}
