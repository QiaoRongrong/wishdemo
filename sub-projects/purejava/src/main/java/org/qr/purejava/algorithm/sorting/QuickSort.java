package org.qr.purejava.algorithm.sorting;

import org.qr.purejava.tools.ArrayUtils;

/**
 * 快速排序
 * https://www.jianshu.com/p/c491dceb0bfd
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i, j, x;

            i = left;
            j = right;
            x = arr[i];
            while (i < j) {
                while (i<j && arr[j] > x) {
                    j--;
                }
                if (i<j) {
                    arr[i++] = arr[j];
                }
                while (i<j && arr[i] < x) {
                    i++;
                }
                if (i<j) {
                    arr[j--] = arr[i];
                }
            }

            arr[i] = x;
            quickSort(arr, left, i-1);
            quickSort(arr, i+1, right);

        }
    }

    public static void main(String[] args) {
        int[] arrOf = {138, 22, 34, 461, 5, 67, 7, 81, 9, 101};

        quickSort(arrOf, 0, 9);
        ArrayUtils.toString(arrOf);
    }


}
