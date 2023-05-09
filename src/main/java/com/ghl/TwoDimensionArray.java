package com.ghl;

public class TwoDimensionArray {

    public static long getSum_ij(int[][] arr, int rows, int columns) {
        long sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static long getSum_ji(int[][] arr, int rows, int columns) {
        long sum = 0;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int rows = 1000000;
        int columns = 14;
        int[][] arr = new int[rows][columns];
        long start_time=System.currentTimeMillis();
        getSum_ij(arr,rows,columns);
        long end_time_ij=System.currentTimeMillis();
        getSum_ji(arr,rows,columns);
        long end_time_ji=System.currentTimeMillis();
        long total = end_time_ji-start_time;//总共耗时
        double getSum_ij_p = (end_time_ij-start_time)/(total*1.0);

        double getSum_ji_p = (end_time_ji-end_time_ij)/(total*1.0);
        System.out.println("getSum_ij耗时："+(end_time_ij-start_time)+",占比："+getSum_ij_p);
        System.out.println("getSum_ji耗时："+(end_time_ji-end_time_ij)+",占比："+getSum_ji_p);
        /**
         * 问题：为什么二维数组外层从行开始遍历要比外层从列开始遍历要快？
         * 缓存局部性原理
         * 皮秒                  纳秒
         * cpu   -》  缓存   -》  内存
         * 缓存：64个字节，缓存行，cacheLine，空间局部性
         * <一次读取64个字段的数据到cpu中进行处理，所以并不是每次循环都需要到内容中获取，所以节约时间
         * 所以先从行遍历充分利用了缓存行，提升了效率>
         * 缓存作用：提升CPU读和写的效率
         *
         */

    }

}
