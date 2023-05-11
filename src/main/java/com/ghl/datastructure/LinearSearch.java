package com.ghl.datastructure;

import java.util.Arrays;
import java.util.stream.Stream;

public class LinearSearch {

    /**
     * 线性查找
     *
     * @param arr
     * @param target
     * @return
     */

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //1.最差的执行情况(找不到的情况)
    //2.假设每行语句执行的时间一样

    /**
     * 数据元素个数n
     * int i=0          1
     * i<arr.length     n+1
     * i++              n
     * arr[i]==target   n
     * return -1        1次
     * 累计：3n+3执行的次数
     * n=4是执行15t
     * n=1024时执行3075t
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int num = Arrays.stream(arr).filter(i -> i == 3).findFirst().getAsInt();
        System.out.println(num);
    }
}
