package com.ghl.algorithm.recursion;

public class E03PascalTriangle {

    private static void f(int hang) {
        for (int i = 1; i <= hang; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 求i行，j列的元素值
     * 1    (i=0,j=0)=1
     * 1    1   (i=1,j=0或者i=1,j=1)=1
     * 1    2   1   (i=2,j=0或者i=2,j=2)=1
     * 1    3   3   1
     * 1    4   6   4   1
     * 1    5   10  10  5   1
     * 1    6   15  20  15  6   1
     */
    private static int pascalTriangle(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }
        return pascalTriangle(i - 1, j - 1) + pascalTriangle(i - 1, j);
    }

    private static void print(int n) {
        for (int i = 0; i < n; i++) {
            printBlank(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-6d", pascalTriangle(i, j));
            }
            System.out.println();
        }
    }

    private static void printBlank(int n, int i) {

        int num = (n - 1 - i) * 3;
        for (int b = 0; b < num; b++) {
            System.out.print(" ");
        }

    }

    public static void main(String[] args) {
//        f(8);
//        System.out.println(pascalTriangle(4, 2));
        print(10);
    }
}
