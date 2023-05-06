package com.ghl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    @DisplayName("binarySearchBasic找到")
    public void test1(){
        int[] arr = {1, 3, 6, 8, 9, 12, 35, 36, 67};
        Assertions.assertEquals(0,BinarySearch.binarySearchBasic(arr,1));
        Assertions.assertEquals(1,BinarySearch.binarySearchBasic(arr,3));
        Assertions.assertEquals(2,BinarySearch.binarySearchBasic(arr,6));
        Assertions.assertEquals(3,BinarySearch.binarySearchBasic(arr,8));
        Assertions.assertEquals(4,BinarySearch.binarySearchBasic(arr,9));
        Assertions.assertEquals(5,BinarySearch.binarySearchBasic(arr,12));
        Assertions.assertEquals(6,BinarySearch.binarySearchBasic(arr,35));
        Assertions.assertEquals(7,BinarySearch.binarySearchBasic(arr,36));
        Assertions.assertEquals(8,BinarySearch.binarySearchBasic(arr,67));

    }

    @Test
    @DisplayName("binarySearchBasic未找到")
    public void test2(){
        int[] arr = {1, 3, 6, 8, 8, 12, 35, 36, 67};
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasic(arr,2));
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasic(arr,4));
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasic(arr,5));
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasic(arr,10));
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasic(arr,11));

    }

    @Test
    @DisplayName("binarySearchBasic找到")
    public void test3(){
        int[] arr = {1, 3, 6, 8, 9, 12, 35, 36, 67};
        Assertions.assertEquals(0,BinarySearch.binarySearchBasicAlternative(arr,1));
        Assertions.assertEquals(1,BinarySearch.binarySearchBasicAlternative(arr,3));
        Assertions.assertEquals(2,BinarySearch.binarySearchBasicAlternative(arr,6));
        Assertions.assertEquals(3,BinarySearch.binarySearchBasicAlternative(arr,8));
        Assertions.assertEquals(4,BinarySearch.binarySearchBasicAlternative(arr,9));
        Assertions.assertEquals(5,BinarySearch.binarySearchBasicAlternative(arr,12));
        Assertions.assertEquals(6,BinarySearch.binarySearchBasicAlternative(arr,35));
        Assertions.assertEquals(7,BinarySearch.binarySearchBasicAlternative(arr,36));
        Assertions.assertEquals(8,BinarySearch.binarySearchBasicAlternative(arr,67));

    }

    @Test
    @DisplayName("binarySearchBasic未找到")
    public void test4(){
        int[] arr = {1, 3, 6, 8, 8, 12, 35, 36, 67};
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasicAlternative(arr,2));
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasicAlternative(arr,4));
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasicAlternative(arr,5));
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasicAlternative(arr,10));
        Assertions.assertEquals(-1,BinarySearch.binarySearchBasicAlternative(arr,11));

    }
}
