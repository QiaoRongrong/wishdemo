package org.qr.purejava.tij.concurrency.shareingresourses;//: concurrency/EvenChecker.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int ident) {
        this.intGenerator = intGenerator;
        id = ident;
    }

    public void run() {
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            if (isNotEvenNumber(val)) { //如果不是偶数

                System.out.println(val + " not even!");
                intGenerator.cancel(); // Cancels all EvenCheckers
            }
        }
    }

    // Test any type of IntGenerator:
    public static void test(IntGenerator intGenerator, int count) {
        System.out.println("Press Control-C to exit");

        //new 10 thread to process ...
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(intGenerator, i));
        }

        exec.shutdown();
    }
    // Default value for count:

    public static void test(IntGenerator intGenerator) {
        test(intGenerator, 10);
    }






    private static boolean isNotEvenNumber(final int val) {
        return val % 2 != 0;
    }
}

///:~
