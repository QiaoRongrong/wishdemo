package org.qr.purejava.tij.concurrency.shareingresourses;//: concurrency/EvenGenerator.java
// When threads collide.

public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    public EvenGenerator() {
        System.out.println("EvenGenerator constructor");
    }

    public /*synchronized*/ int next() {
        ++currentEvenValue; // Danger point here!
        Thread.yield(); //easy to rise issue.

        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {

        EvenChecker.test(new EvenGenerator());



    }
}


/* Output: (Sample)
Press Control-C to exit
89476993 not even!
89476993 not even!
*///:~
