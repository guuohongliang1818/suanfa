package com.ghl.algorithm.recursion;

/**
 * 递归求和
 */
public class E06Sum {
    /**
     * f(1)=1
     * f(2)=2+f(1)
     * f(3)=3+f(2)
     * f(4)=4+f(3)
     *
     * @return
     */
    /**
     * 爆栈问题：栈内存溢出
     * StackOverflowError：
     * 该方法并不是尾调用，所以会出现爆栈的问题
     * 如果递归采用的是为调用，编译器会进行编译优化
     */
    public static long f(long n) {
        if (n == 1) {
            return 1;
        }
        return n + f(n - 1);
    }


    /**
     * 优化方法为尾调用，只有c++才会优化，JAVA编译不会优化，还是会出现爆栈，解决办法，利用for循环处理，避免使用递归
     *
     * @param n
     * @param accumulator,累加值，默认出事累加初始值为0
     * @return
     */
    public static long f_1(long n, long accumulator) {
        if (n == 1) {
            return 1 + accumulator;
        }
        return f_1(n - 1, n + accumulator);
    }

    public static void main(String[] args) {
        System.out.println(f_1(15000, 0));
    }
}
