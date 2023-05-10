package com.ghl;

import org.junit.jupiter.api.Test;

public class DoubleLinkedListSentinelTest {

    @Test
    public void test1(){
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        System.out.println(doubleLinkedListSentinel);
    }

    @Test
    public void test2(){
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addFirst(1);
        doubleLinkedListSentinel.addFirst(2);
        doubleLinkedListSentinel.addFirst(3);
        doubleLinkedListSentinel.addFirst(4);
        System.out.println(doubleLinkedListSentinel);
    }

    public void test3(){
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addFirst(1);
        doubleLinkedListSentinel.addFirst(2);
        doubleLinkedListSentinel.addFirst(3);
        doubleLinkedListSentinel.addFirst(4);
        System.out.println(doubleLinkedListSentinel);
    }
}
