package org.qr.purejava.algorithm.sorting;


import org.qr.purejava.tools.ArrayUtils;

/**
 * 选择排序
 */
public class SelectionSorting {

    static int[] arrOf = {138, 22, 34, 461, 5, 67, 7, 81, 9, 101};

    /**
     *
     * @param arr raw array
     * @return index of array
     */
    public static int findMax(int[] arr) {
        int max = arr[0];
        int maxIndex = 0;

        for (int i = 1; i<arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        arrOf = remove(arr, maxIndex);
        return max;
    }

    public static int[] remove(int[] rawArray, int index) {
        if (index >= rawArray.length) {
            System.out.printf("index out of the array length.");
        }
        int[] newArray = new int[rawArray.length - 1];
        for (int i = 0; i< newArray.length; i++) {  // new array
            if (i < index) {
                newArray[i] = rawArray[i];
            } else { // i >= index
                newArray[i] = rawArray[i+1];
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
//        toString(arr);
//        int[] removed = remove(arr, 3);
//        toString(removed);

        ArrayUtils.toString(arrOf);
        int length = arrOf.length;
        int[] newArr = new int[length];
        for (int i = 0; i< length; i++) {
            int max = findMax(arrOf);
            newArr[i] = max;
        }

        ArrayUtils.toString(newArr);

    }

}
