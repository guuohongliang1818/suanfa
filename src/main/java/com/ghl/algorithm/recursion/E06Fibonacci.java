package com.ghl.algorithm.recursion;

import java.util.Arrays;

public class E06Fibonacci {

    /**
     * 使用记忆法，也叫备忘录对斐波那契数列进行优化（减枝）
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        //初始化数组为-1，表示没有计算过
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;

        return f(n, cache);
    }

    /**
     * 多路递归
     *
     * @param n
     * @return
     */
    //f(3)=>5次递归
    //f(4)=>9次递归
    //f(5)=>15次递归
    //f(n)=>2*f(n-1)-1
    public static int f(int n, int[] cache) {

        if (cache[n] != -1) {
            return cache[n];
        }
        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;
        return x + y;


    }

    /**
     * 兔子问题
     *
     * @param args f(6)=f(5)+f(4)
     */
    public static int rabbits(int month) {
        if (month == 1) {
            return 1;//1对兔子
        }
        if (month == 2) {
            return 1;//1对兔子
        }
        return rabbits(month - 1) + rabbits(month - 2);
    }

    /**
     * 青蛙跳台阶
     *
     * @param args 1个台阶:(1)=1种
     *             2个台阶:(1,1)(2)=2种
     *             3个台阶:(1,1,1)(1,2)(2,1)=3种
     *             4个台阶:(1,1,1,1)(2,1,1)(1,2,1)来源于3个台阶的跳法
     *             (2,2)(1,1,2)来源于2个台阶的跳法
     */
    public static int jump(int n) {//n表示台阶数
        if (n == 1) {
            return 1;//1对兔子
        }
        if (n == 2) {
            return 2;//1对兔子
        }
        return jump(n - 1) + jump(n - 2);
    }

    public static void main(String[] args) {

        System.out.println(rabbits(4));

    }
}
