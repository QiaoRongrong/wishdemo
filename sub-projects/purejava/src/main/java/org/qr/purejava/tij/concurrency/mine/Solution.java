package org.qr.purejava.tij.concurrency.mine;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    private static ThreadLocal<AtomicInteger> threadLocal = new ThreadLocal<>();
    private static AtomicInteger atomicInteger;

    static {
        atomicInteger = new AtomicInteger();
    }

    public AtomicInteger getConn() {
        AtomicInteger oneInteger = threadLocal.get();
        if (null == oneInteger) {
            threadLocal.set(atomicInteger);
        }
        return threadLocal.get();
    }



}



class Client {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        solution.getConn().set(2);

        System.out.println(solution.getConn());

        new Thread() {
            public void run() {
                System.out.println(solution.getConn());
            }
        }.start();

        System.out.println("Hello");
    }
}