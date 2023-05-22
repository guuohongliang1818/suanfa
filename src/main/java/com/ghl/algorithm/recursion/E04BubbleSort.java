package com.ghl.algorithm.recursion;

import java.util.Arrays;

public class E04BubbleSort {
    //一般的冒泡排序

    /**
     * 升序排列
     * [8, 3, 6, 9, 4, 7, 13, 5, 9]
     */
    private static void bubbleSort() {
        int[] arr = {8, 3, 6, 10, 9, 4, 7, 13, 5, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] >= arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void swap(int[] arr, int front, int back) {
        int temp = arr[front];
        arr[front] = arr[back];
        arr[back] = temp;
    }

    /**
     * 冒泡排序<递归解法>
     * [8, 3, 6, 9, 4, 7, 9, 9, 13]
     * 将数组划分为两部分[0....j][j+1,......a.length-1]
     * 左边[0,...j]是未排序部分
     * 右边[j+1,......a.length-1]是已排序部分
     * 未排序区间内，相邻的两个元素比较，如果前一个大于后一个，则交换位置
     *
     * @param arr
     * @param point 为数组的小标，起始值为数组的长度-1
     */
    private static void f(int[] arr, int point) {
        if (point == 0) {
            return;
        }
        for (int i = 0; i < point; i++) {
            if (arr[i] >= arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        f(arr, --point);
    }

    /**
     * [4, 3, 5, 6, 7, 8, 9, 9, 13]
     * 只需要4,3交换一次就可以完成整体排序，没必要point==0时才结束递归
     *
     * @param arr
     */
    private static void f_1(int[] arr, int point) {
        if (point == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < point; i++) {
            if (arr[i] >= arr[i + 1]) {
                swap(arr, i, i + 1);
                x = i;
            }
        }
        f(arr, x);
    }

    public static void sort(int[] arr) {
        f(arr, arr.length - 1);
    }

    public static void main(String[] args) {
        //bubbleSort();
        int[] arr = {8, 3, 6, 10, 9, 4, 7, 13, 5, 9};
        f(arr, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);

    }
}
