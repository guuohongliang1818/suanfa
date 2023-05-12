package com.ghl.algorithm.recursion;

/**
 * 递归实现二分查找
 */
public class E03BinarySearch {
    /**
     * [1, 3, 4, 5, 8, 10, 11, 13]
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

    private static int f(int[] arr, int i, int j, int target) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;

        if (target < arr[m]) {
            j = m - 1;
        } else if (arr[m] < target) {
            i = m + 1;
        } else {
            return m;
        }
        return f(arr, i, j, target);
    }


    private static int f_left_most(int[] arr, int i, int j, int target) {
        if (i > j) {
            return -1;
        }

        int m = (i + j) >>> 1;
        int candidate = -1;
        if (target < arr[m]) {
            j = m - 1;
        } else if (arr[m] < target) {
            i = m + 1;
        } else {
            candidate = m;
            j = m - 1;
        }
        return candidate == -1 ? -1 : f(arr, i, j, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 8, 10, 11, 13};
        //System.out.println(search(arr, 4));
        System.out.println(f(arr, 0, arr.length - 1, -1));


        int[] arr1 = {1, 3, 4, 5, 5, 8, 10, 10, 10, 11, 13};
        //System.out.println(search(arr, 4));
        System.out.println(f(arr1, 0, arr.length - 1, 5));
    }
}
