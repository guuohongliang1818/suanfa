package com.ghl;

import com.ghl.datastructure.DynamicArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DynamicArrayTest {

    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.add(3, 6);

        for (int i = 0; i < 6; i++) {
            System.out.println(dynamicArray.get(i));
        }

    }

    @Test
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.add(3, 6);

        dynamicArray.forEach(System.out::println);

    }

    @Test
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.add(3, 6);

//        Iterator<Integer> it = dynamicArray.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    public void test4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.add(3, 6);

        dynamicArray.stream().forEach(System.out::println);

    }


    @Test
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        //dynamicArray.add(3,6);
        Assertions.assertEquals(3, dynamicArray.delete(2));
        Assertions.assertEquals(4, dynamicArray.delete(2));
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 5), dynamicArray);
        //dynamicArray.foreach(System.out::println);


    }

    @Test
    public void test6() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 1; i <= 9; i++) {
            dynamicArray.addLast(i);
        }
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), dynamicArray);
        //dynamicArray.foreach(System.out::println);
    }
}
