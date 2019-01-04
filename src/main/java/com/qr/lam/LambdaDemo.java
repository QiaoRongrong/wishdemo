package com.qr.lam;


import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaDemo {

    public static void main(String[] args) {
        System.out.println("Welcome to lambda...");

        Runnable noArguments = () -> System.out.println("Hello world!");
        noArguments.run();

        HelloRunnable helloRunnable = new HelloRunnable();
        helloRunnable.run();

        Predicate<Integer> atLeastFive = x -> x > 5;

        int count = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, element) -> acc + element );
        System.out.println(count);
    }

}


/**
 * Old Thread...
 */
class HelloRunnable implements Runnable {

    @Override
    public void run() {

        System.out.println("Hello by HelloRunnable!");
    }
}