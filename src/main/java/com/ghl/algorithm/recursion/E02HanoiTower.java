package com.ghl.algorithm.recursion;

import java.util.LinkedList;

public class E02HanoiTower {

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    /**
     * @param n 圆盘个数
     * @param a 源柱子
     * @param b
     * @param c
     * T(n)=2T(n-1)+c,T(1)=c
     */
    public static void hanoiTower(int n, LinkedList<Integer> a,
                           LinkedList<Integer> b,
                           LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        hanoiTower(n - 1, a, c, b);
        c.addLast(a.removeLast());
        print();
        hanoiTower(n - 1, b, a, c);
    }

    public static void print() {
        System.out.println("==================");
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);

    }

    public static void main(String[] args) {
        init(64);
        print();
//        b.addLast(a.removeLast());
//        print();
//        c.addLast(a.removeLast());
//        print();
//        c.addLast(b.removeLast());
//        print();
//        b.addLast(a.removeLast());
//        print();
//        a.addLast(c.removeLast());
//        print();
//        b.addLast(c.removeLast());
//        print();
//        b.addLast(a.removeLast());
//        print();
//        c.addLast(a.removeLast());
//        print();
//        c.addLast(b.removeLast());
//        print();
//        a.addLast(b.removeLast());
//        print();
//        a.addLast(c.removeLast());
//        print();
//        c.addLast(b.removeLast());
//        print();
//        b.addLast(a.removeLast());
//        print();
//        c.addLast(a.removeLast());
//        print();
//        c.addLast(b.removeLast());
//        print();
        hanoiTower(64, a, b, c);

    }
}
