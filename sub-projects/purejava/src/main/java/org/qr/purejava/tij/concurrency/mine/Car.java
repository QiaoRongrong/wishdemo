package org.qr.purejava.tij.concurrency.mine;

import lombok.Data;

@Data
public class Car {
    private String name;
    private int age;

    public void go() {
        System.out.println(name + ", go...");
    }

    public void stop() {
        System.out.println(name + ", stop...");
    }


    public static void main(String[] args) {
        Car car = new Car();
        car.setName("Nissan Dan");

        new Thread(() -> car.go()).start();

        car.stop();
    }
}


