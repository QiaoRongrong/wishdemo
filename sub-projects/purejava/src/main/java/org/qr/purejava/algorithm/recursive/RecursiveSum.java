package org.qr.purejava.algorithm.recursive;

import java.util.Arrays;

public class RecursiveSum {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    static int sum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else {
            return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    public static void main(String[] args) {
        System.out.println("\nresult: " + sum(arr));
    }

}
