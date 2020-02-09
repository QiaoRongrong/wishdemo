package org.qr.purejava.algorithm.recursive;

public class LoopSum {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static int sum(int[] array) {
        int sum = 0;
        for (int one : array) {
            sum += one;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("\nresult: " + sum(arr));
    }
}
