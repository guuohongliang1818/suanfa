package com.ghl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */

public class DynamicArray implements Iterable<Integer> {

    private int size = 0;//逻辑大小
    private int capacity = 8;//容量
    private int[] arr = new int[capacity];

    /**
     * 向数组的末尾添加元素
     *
     * @param element
     */
    public void addLast(int element) {
//        arr[size] = element;
//        size++;
        add(size, element);
    }

    /**
     * 向数组中的固定位置添加元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {

        if (index >= 0 && index < size) {//如果index=size，则相当于在arr的末尾插入元素
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        arr[index] = element;
        size++;
    }

    public int get(int index) {
        return arr[index];
    }

    /**
     * 使用函数式接口
     * 提供 array[i]
     * 不需要返回值
     */
    //遍历方法一：
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
//            System.out.println(arr[i]);
            consumer.accept(arr[i]);
        }
    }

    //遍历方法二：
    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {//询问有无下一个元素
                return i < size;
            }

            @Override
            public Integer next() {//返回当前元素，并移动到下一个元素
                return arr[i++];
            }
        };
    }

    //遍历方法三：
    public IntStream stream() {
        //return IntStream.of(arr);
        //return Arrays.stream(arr).limit(size);
        return IntStream.of(Arrays.copyOfRange(arr, 0, size));
    }

    //删除元素
    public int delete(int index) {//[0...size)
        /**
         * [1, 5, 6, 4, 3, 7, 8, 0]
         * 删除下标为3的元素
         */
        int element = arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - (index + 1));
        //arr[size - 1] = 0;
        size--;
        return element;
    }
}
