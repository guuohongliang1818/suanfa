package com.ghl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DoubleCircleLinkedListSentinelTest {

    @Test
    public void test1() {
        DoubleCircleLinkedListSentinel doubleCircleLinkedListSentinel = new DoubleCircleLinkedListSentinel();
        doubleCircleLinkedListSentinel.addFirst(2);
        doubleCircleLinkedListSentinel.addFirst(3);
        doubleCircleLinkedListSentinel.addFirst(4);
        Assertions.assertIterableEquals(Arrays.asList(4, 3, 2), doubleCircleLinkedListSentinel);
    }


    @Test
    public void test2() {
        DoubleCircleLinkedListSentinel doubleCircleLinkedListSentinel = new DoubleCircleLinkedListSentinel();
        doubleCircleLinkedListSentinel.addLast(2);
        doubleCircleLinkedListSentinel.addLast(3);
        doubleCircleLinkedListSentinel.addLast(4);
        Assertions.assertIterableEquals(Arrays.asList(2, 3, 4), doubleCircleLinkedListSentinel);
    }


    @Test
    public void test3() {
        DoubleCircleLinkedListSentinel doubleCircleLinkedListSentinel = new DoubleCircleLinkedListSentinel();
        doubleCircleLinkedListSentinel.addLast(1);
        doubleCircleLinkedListSentinel.addLast(2);
        doubleCircleLinkedListSentinel.addLast(3);
        doubleCircleLinkedListSentinel.addLast(4);
        doubleCircleLinkedListSentinel.addLast(5);
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeFirst();
        Assertions.assertIterableEquals(Arrays.asList(2, 3, 4, 5), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeFirst();
        Assertions.assertIterableEquals(Arrays.asList(3, 4, 5), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeFirst();
        Assertions.assertIterableEquals(Arrays.asList(4, 5), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeFirst();
        Assertions.assertIterableEquals(Arrays.asList(5), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeFirst();
        Assertions.assertIterableEquals(Arrays.asList(), doubleCircleLinkedListSentinel);
        Assertions.assertThrows(IllegalArgumentException.class, () -> doubleCircleLinkedListSentinel.removeFirst());

    }

    @Test
    public void test4() {
        DoubleCircleLinkedListSentinel doubleCircleLinkedListSentinel = new DoubleCircleLinkedListSentinel();
        doubleCircleLinkedListSentinel.addLast(1);
        doubleCircleLinkedListSentinel.addLast(2);
        doubleCircleLinkedListSentinel.addLast(3);
        doubleCircleLinkedListSentinel.addLast(4);
        doubleCircleLinkedListSentinel.addLast(5);
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeLast();
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeLast();
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeLast();
        Assertions.assertIterableEquals(Arrays.asList(1, 2), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeLast();
        Assertions.assertIterableEquals(Arrays.asList(1), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeLast();
        Assertions.assertIterableEquals(Arrays.asList(), doubleCircleLinkedListSentinel);
        Assertions.assertThrows(IllegalArgumentException.class, () -> doubleCircleLinkedListSentinel.removeLast());

    }

    @Test
    public void test5() {
        DoubleCircleLinkedListSentinel doubleCircleLinkedListSentinel = new DoubleCircleLinkedListSentinel();
        doubleCircleLinkedListSentinel.addLast(1);
        doubleCircleLinkedListSentinel.addLast(2);
        doubleCircleLinkedListSentinel.addLast(3);
        doubleCircleLinkedListSentinel.addLast(4);
        doubleCircleLinkedListSentinel.addLast(5);
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeByValue(3);
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 4, 5), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeByValue(1);
        Assertions.assertIterableEquals(Arrays.asList(2, 4, 5), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeByValue(5);
        Assertions.assertIterableEquals(Arrays.asList(2, 4), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeByValue(2);
        Assertions.assertIterableEquals(Arrays.asList(4), doubleCircleLinkedListSentinel);
        doubleCircleLinkedListSentinel.removeByValue(4);
        Assertions.assertIterableEquals(Arrays.asList(), doubleCircleLinkedListSentinel);
        Assertions.assertThrows(IllegalArgumentException.class, () -> doubleCircleLinkedListSentinel.removeLast());

    }


}
