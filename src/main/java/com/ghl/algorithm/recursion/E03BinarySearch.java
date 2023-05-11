package com.ghl.algorithm.recursion;

/**
 * 递归实现二分查找
 */
public class E03BinarySearch {
    /**
     * [1, 4, 7, 9, 5, 6, 8, 9]
     */

    private static int search(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
