package com.ghl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SingleLinkedListSentinelTest {

    @Test
    public void test1() {
        SingleLinkedListSentinel singleLinkedListSentinel = new SingleLinkedListSentinel();
        singleLinkedListSentinel.addLast(3);
        singleLinkedListSentinel.addLast(5);
        singleLinkedListSentinel.addLast(7);
        singleLinkedListSentinel.addLast(9);
        Assertions.assertIterableEquals(Arrays.asList(3, 5, 7, 9), singleLinkedListSentinel);

    }

    @Test
    public void test2() {
        SingleLinkedListSentinel singleLinkedListSentinel = new SingleLinkedListSentinel();
        singleLinkedListSentinel.addLast(3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> singleLinkedListSentinel.get(10));

    }

    @Test
    public void test3() {
        SingleLinkedListSentinel singleLinkedListSentinel = new SingleLinkedListSentinel();
        singleLinkedListSentinel.addLast(1);
        singleLinkedListSentinel.addLast(2);
        singleLinkedListSentinel.addLast(3);
        singleLinkedListSentinel.addLast(4);

        singleLinkedListSentinel.insert(0, 99);

        Assertions.assertIterableEquals(Arrays.asList(99, 1, 2, 3, 4), singleLinkedListSentinel);

    }
}
