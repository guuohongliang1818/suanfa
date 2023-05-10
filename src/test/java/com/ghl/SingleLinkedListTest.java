package com.ghl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SingleLinkedListTest {

    @Test
    public void test1() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop1(value -> System.out.println(value));
    }

    @Test
    public void test2() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        list.loop2(value -> System.out.println(value));
    }

    @Test
    public void test3() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(9);
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        for (Integer ele : list) {
            System.out.println(ele);
        }
    }

    @Test
    public void test4() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(13);
        list.addLast(14);
        list.addLast(15);
        list.addLast(16);
        Assertions.assertIterableEquals(Arrays.asList(13, 14, 15, 16), list);

    }

    @Test
    public void test5() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(13);
        list.addLast(14);
        list.addLast(15);
        list.addLast(16);
        int i = list.get(2);
        System.out.println(i);
    }
}
