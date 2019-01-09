package org.qr.purejava.tij.concurrency;

//: concurrency/BasicThreads.java
// The most basic use of the Thread class.

import java.util.stream.Stream;

public class BasicThreads {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();

        Stream.of(1, 2, 3, 4, 5).forEach(it -> new Thread(new LiftOff()).start());

        System.out.println("Waiting for LiftOff");
    }
}

/* Output: (90% match)
Waiting for LiftOff
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
*///:~
