package com.ghl;

public class BinarySearch {


    public static void main(String[] args) {

        int[] arr = {1, 3, 6, 8, 9, 12, 35, 36, 67};
        int index = binarySearchBasic(arr, 8);
        System.out.println(index);

    }

    /**
     * @param arr    有序切递增的数组
     * @param target 寻找的目标数值
     * @return
     */

    public static int binarySearchBasic(int[] arr, int target) {
        //找到起始位置和末尾
        int start = 0;
        int end = arr.length - 1;
        //循环，如果start>end则停止循环，返回-1
        while (start <= end) {
            //取二者的中间值下标，所对应的值
            int mid = (start + end) / 2;//向下取整
            int midVal = arr[mid];
            if (midVal == target) {
                return mid;
            } else if (midVal > target) {//target在midVal的左边
                end = mid - 1;
            } else if (midVal < target) {//target在midVal的右边
                start = mid + 1;
            }
        }
        return -1;
    }
    /**
     * 问题1：为什么是start<=end，意味着区间内有未比较的元素，而不是start<end?
     * start==end 意味着start，end它们指向的元素也会参与比较
     * start<end 只意味着mid指向的元素参与比较
     */

    /**
     * 问题2：（start+end）/2 有没有问题？
     */
}
