package com.ghl.algorithm.recursion;

import java.util.Arrays;

/**
 * 插入排序
 */
public class E05InsertionSort {

    public static void sort(int[] arr) {
        f(arr, 0);
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * low
     * [3, 4, 5, 8, 9, 7, 10, 13]
     *
     * @param arr
     */

    public static void f(int[] arr, int low) {

        if (low == arr.length) {//当low指向最后一个元素时，也是需要排序的
            return;
        }
        //1.取出low下标对应的值
        int temp = arr[low];
        for (int i = 0; i < low; i++) {
            if (arr[low] >= arr[i] && arr[low] <= arr[i + 1]) {
                System.arraycopy(arr, i + 1, arr, i + 2, low - i - 1);
                arr[i + 1] = temp;
                break;
            }
        }
        f(arr, ++low);

    }

    private static void swap(int[] arr, int front, int back) {
        int temp = arr[front];
        arr[front] = arr[back];
        arr[back] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 10, 8, 4, 7, 11, 6, 13};
        sort(arr);
    }
}
