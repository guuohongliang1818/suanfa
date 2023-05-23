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

    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n + f(n - 1);
    }
}
