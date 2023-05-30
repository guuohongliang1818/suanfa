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
                System.out.printf("%-12d", pascalTriangle(i, j));
            }
            System.out.println();
        }
    }


    private static void printBlank(int n, int i) {

        int num = (n - 1 - i) * 6;
        for (int b = 0; b < num; b++) {
            System.out.print(" ");
        }

    }

    /**
     * 代码优化，使用记忆法，使用二维数组进行优化
     *
     * @param i
     * @param j
     * @return
     */
    private static int pascalTriangle1(int[][] triangle, int i, int j) {
        if (triangle[i][j] != 0) {
            return triangle[i][j];
        }
        if (j == 0 || i == j) {
            triangle[i][j] = 1;
            return 1;
        }
        triangle[i][j] = pascalTriangle1(triangle, i - 1, j - 1) + pascalTriangle1(triangle, i - 1, j);
        return triangle[i][j];
    }

    private static void print1(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            printBlank(n, i);
            triangle[i] = new int[n + 1];
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-12d", pascalTriangle1(triangle, i, j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        f(8);
//        System.out.println(pascalTriangle(4, 2));
        print1(10);
    }
}
