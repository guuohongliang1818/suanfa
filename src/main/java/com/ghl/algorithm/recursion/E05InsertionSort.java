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
    public static void sort_1(int[] arr) {
        f_1(arr, 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort_2(int[] arr) {
        f_2(arr, 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void f(int[] arr, int low) {

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

    /**
     * @param arr
     * @param low 代表未排序区域的下边界
     */
    private static void f_1(int[] arr, int low) {

        if (low == arr.length) {//当low指向最后一个元素时，也是需要排序的
            return;
        }
        int temp = arr[low];//low指针指向的元素值
        int i = low - 1;//代表已排序区域的指针（已排序区域的右边界）
        //从有向左找，找到以一个比temp值小的即可跳出循环
        //同时需要将低（i-1）个元素向右移动一个位置
        while (i >= 0 && arr[i] > temp) {//寻找比temp小的元素
            arr[i + 1] = arr[i];//空出插入位置
            i--;//继续寻找比temp小的元素位置
        }
        //找到了插入位置，将（i+1）的位置赋值为t
        if (i + 1 != low) {
            arr[i + 1] = temp;
        }
        f_1(arr, low + 1);

    }

    private static void f_2(int[] arr, int low) {

        if (low == arr.length) {//当low指向最后一个元素时，也是需要排序的
            return;
        }
        int i = low - 1;//代表已排序区域的指针（已排序区域的右边界）
        //从有向左找，找到以一个比temp值小的即可跳出循环
        //同时需要将低（i-1）个元素向右移动一个位置
        while (i >= 0 && arr[i] > arr[i + 1]) {//寻找比temp小的元素
            swap(arr, i, i + 1);
            i--;
        }
        f_2(arr, low + 1);

    }

    private static void swap(int[] arr, int front, int back) {
        int temp = arr[front];
        arr[front] = arr[back];
        arr[back] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 12, 1, 9, 23, 2, 12, 34};
        sort_2(arr);
    }
}
