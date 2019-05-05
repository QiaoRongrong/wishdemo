package org.qr.purejava.algorithm.sorting;

/**
 * 二分查找
 * <p>
 * O(log n)
 * <p>
 * 接受一个有序数组和一个元素, 查找该元素在数组中的位置
 */
public class BinarySearch {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    static int target = 7;

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;  //important
            //System.out.println("mid = " + mid + ", array[" + mid + "] = " + arr[mid]);

            if (arr[mid] == target) {
                //System.out.println("find it.");
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
                //System.out.println("Forward ... high = " + high);
            } else if (arr[mid] < target){
                low = mid + 1;
                //System.out.println("Backward ... low = " + low + ", array[" + low + "] = " + arr[low]);
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("The element index is: " + binarySearch(arr, target));
    }


}
