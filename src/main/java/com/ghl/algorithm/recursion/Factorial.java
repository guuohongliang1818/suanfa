package com.ghl.algorithm.recursion;

public class Factorial {

    private static int f(int n) {
        if (n == 1) {
            return 1;
        }

        return n * f(n - 1);
    }

    public static void main(String[] args) {

        System.out.println(f(1));
        System.out.println(f(2));
        System.out.println(f(3));
        System.out.println(f(4));
        System.out.println(f(5));
    }
    /**
     f(int n=3) {
        return 3 * f(int n=2) {
            return 2 * f(int n=1) {
                return 1;
            };
        };
     }
     */
}
