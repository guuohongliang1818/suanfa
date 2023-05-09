package com.ghl;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {


    /**
     * @param arr    有序切递增的数组
     * @param target 寻找的目标数值
     * @return
     */
    //左闭右闭边界，将来边界值都会参与运算
    public static int binarySearchBasic(int[] arr, int target) {
        //找到起始位置和末尾
        int start = 0;
        int end = arr.length - 1;
        //循环，如果start>end则停止循环，返回-1

        /**
         L次，元素在最左边 L次，只需要比较if，成本较低
         L次，元素在最右边 2*L次，需要比较if和else if，成本较高
         左边和右边查找元素不平衡，需要优化为左右查找元素平衡的算法
         */

        while (start <= end) {
            //取二者的中间值下标，所对应的值
            int mid = (start + end) >>> 1;//向下取整,无符号按位右移可以避免出现负数，而且试用更多的语言，比如javaScript
            //int midVal = arr[mid];
            if (target < arr[mid]) {//target在midVal的左边
                end = mid - 1;
            } else if (arr[mid] < target) {//target在midVal的右边
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    /**
     *1 [2,3,4,5] 6 右侧没有找到的效率更差
     *  int start = 0;                1次
     *  int end = arr.length - 1;     1次
     *  return -1                     1次
     *元素个数 循环次数
     *4-7       3  = floor(log_2(4))+1
     *8-15      4  = floor(log_2(8))+1
     *16-31     5  = floor(log_2(16))+1
     *32-63     6  = floor(log_2(32))+1
     *循环次数：L=floor(log_2(n))+1
     *  start <= end                    L+1
     *  int mid = (start + end) >>> 1   L
     *  target < arr[mid]               L
     *  arr[mid] < target               L
     *  start = mid + 1                 L
     *总共执行=5(floor(log_2(n))+1)+4
     *
     *n=4时执行19t
     *n=1024时执行59t
     */
    /**
     * 问题1：为什么是start<=end，意味着区间内有未比较的元素，而不是start<end?
     * start==end 意味着start，end它们指向的元素也会参与比较
     * start<end 只意味着mid指向的元素参与比较
     */

    /**
     * 问题2：（start+end）/2 有没有问题？
     * 同一个二进制数：1011 1111 1111 1111 1111 1111 1111 1110
     * 不把最高位视为符号位的结果是：3221225470
     * 把最高位视为符号位的结果是：-1073741826
     * 除以2会出现负数，如果采用无符号按位右移则不会出现负数
     */

    //左闭右开边界，将来右边界不会参与运算
    public static int binarySearchBasicAlternative(int[] arr, int target) {
        int start = 0;
        //end只是边界，一定不是查找目标，不参与比较
        int end = arr.length;//改1
        //如果start==end，那么如果当查找数组中没有的元素时，就会进入死循环
        while (start < end) {//改2
            //取二者的中间值下标，所对应的值
            int mid = (start + end) >>> 1;//向下取整,无符号按位右移可以避免出现负数，而且试用更多的语言，比如javaScript
            //int midVal = arr[mid];
            if (target < arr[mid]) {//target在midVal的左边
                end = mid;//改3
            } else if (arr[mid] < target) {//target在midVal的右边
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找平衡版
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchBasicBalance(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while (start + 1 < end) {//改2
            int mid = (start + end) >>> 1;//向下取整,无符号按位右移可以避免出现负数，而且试用更多的语言，比如javaScript
            if (target < arr[mid]) {//target在midVal的左边
                end = mid;//此时不参与比较
            } else {//target在midVal的右边，或中间值为mid
                start = mid;
            }
        }
        return (arr[start] == target) ? start : -1;
    }

    /**
     * 重复的元素返回最左元素的下标
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchLeftMost(int[] arr, int target) {
        /**
         * [1, 3, 6, 7, 7, 7, 9, 12, 35, 36, 67]
         */
        int start = 0;
        int end = arr.length - 1;
        //候选位置
        int candidate = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                candidate = mid;
                end = mid - 1;
            }
        }
        return candidate;
    }

    /**
     * 重复的元素返回最左元素的下标
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchLeftMost2(int[] arr, int target) {
        /**
         * [1, 3, 6, 7, 7, 7, 9, 12, 35, 36, 67]
         */
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        //返回的值：>=目标值得最靠左的位置
        return start;//找到：与目标相等的最靠左的索引位置。找不到：比目标大的并且是最靠左的索引位置
    }

    /**
     * 重复的元素返回最右元素的下标
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchRightMost(int[] arr, int target) {
        /**
         * [1, 3, 6, 7, 7, 7, 9, 12, 35, 36, 67]
         */
        int start = 0;
        int end = arr.length - 1;
        //候选位置
        int candidate = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                candidate = mid;
                start = mid + 1;
            }
        }
        return candidate;
    }

    /**
     * 重复的元素返回最右元素的下标
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchRightMost2(int[] arr, int target) {
        /**
         * [1, 3, 6, 7, 7, 7, 9, 12, 35, 36, 67]
         */
        int start = 0;
        int end = arr.length - 1;
        //候选位置
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start - 1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 6, 8, 9, 12, 35, 36, 67};
        int index = binarySearchBasic(arr, 8);
        System.out.println(index);

        int start = 0;
        int end = Integer.MAX_VALUE;
        System.out.println("end:" + end);

        int mid = (start + end) / 2;
        System.out.println("mid:" + mid);

        //start右移
        start = mid + 1;
        System.out.println("start:" + start);
        System.out.println("start + end:" + (start + end));
        mid = (start + end) / 2;
        System.out.println("mid:" + mid);

        mid = (start + end) >>> 1;
        System.out.println("无符号按位右移:" + mid);

        /**
         * 同一个二进制数：1011 1111 1111 1111 1111 1111 1111 1110
         * 不把最高位视为符号位的结果是：3221225470
         * 把最高位视为符号位的结果是：-1073741826
         */
        int ind = Arrays.binarySearch(arr, 7);
        /**
         * ind = -(插入点+1)
         * 求：插入点=-ind-1
         */
        System.out.println("ind:" + ind);
        System.out.println("插入点:" + (-ind - 1));
        /**
         * 将7插入数组arr中
         *           i
         * [1, 3, 6, 8, 9, 12, 35, 36, 67]
         * [1, 3, 6, 7, 8, 9, 12, 35, 36, 67]
         */
        if (ind < 0) {
            int insert = -ind - 1;//插入点索引
            //1.数组扩容，同时将原数组插入点之前的数据拷贝到新数组中
            int[] new_array = new int[arr.length + 1];
            System.arraycopy(arr, 0, new_array, 0, insert);
            //2.在新数组中添加新的元素
            new_array[3] = 7;
            //3.将原数组插入点之后的数据拷贝到新数组中
            System.arraycopy(arr, insert, new_array, insert + 1, arr.length - insert);
            System.out.println(Arrays.toString(new_array));

        }
        int[] array = new int[]{12,3};
        int[] array1 = new int[2];

        //测试
    }

    public static int[] test() {
        return new int[]{1,2};
    }
}
