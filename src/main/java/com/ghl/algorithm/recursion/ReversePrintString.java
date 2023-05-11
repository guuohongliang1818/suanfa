package com.ghl.algorithm.recursion;

import java.util.function.Consumer;

/**
 * 递归反向打印字符串：打印代码如果在递归函数之后，则是倒序打印
 */
public class ReversePrintString {

    private static void f(String str, int n, Consumer<Character> consumer) {
        if (str == null) {
            return;
        }
        if (n == str.length()) {
            return;
        }
        f(str, n + 1, consumer);
        consumer.accept(str.charAt(n));
    }


    private static void f_reverse(String str, int n, Consumer<Character> consumer) {
        if (str == null) {
            return;
        }
        if (n < 0) {
            return;
        }
        consumer.accept(str.charAt(n));
        f_reverse(str, n - 1, consumer);

    }

    public static void main(String[] args) {
        f("abcdefg", 0, c -> System.out.println(c));
        System.out.println("-------------");
        f_reverse("abcdefg","abcdefg".length()-1,System.out::println);
    }
}
