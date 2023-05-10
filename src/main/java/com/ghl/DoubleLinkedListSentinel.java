package com.ghl;

import java.util.Iterator;

/**
 * 带哨兵的双向链表
 */
public class DoubleLinkedListSentinel implements Iterable<Integer> {

    private Node head;
    private Node tail;

    private static class Node {
        private Node prev;
        private int value;
        private Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public DoubleLinkedListSentinel() {
        /**
         * 初始化哨兵关系
         */
        head = new Node(null, 666, null);
        tail = new Node(null, 999, null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }

    /**
     * 根据索引查找node节点
     *
     * @param index
     * @return
     */
    private Node findNode(int index) {
        /**
         * null <-666 = 1 = 3 = 8 = 5 = 7 = 9 = 999 -> null
         *         -1   0   1   2   3   4   5    6      7
         * 从head.next开始遍历链表，可以查询 index对应的节点信息
         */
        int i = -1;
        Node pointer = head;
        while (pointer != tail) {
            if (i == index) {
                return pointer;
            }
            pointer = pointer.next;
            i++;
        }
        return null;
    }


    public void addFirst(int value) {
        //1.先创建一个新的节点
//        Node node = new Node(null, value, null);
//        //获取头节点和尾节点，头节点为head，
//        //尾节点为
//        Node tail = head.next;
//        //处理头节点
//        node.prev = head;
//        head.next = node;
//        //获取尾节点
//        tail.prev = node;
//        node.next = tail;
        insert(0, value);

    }

    public void addLast(int value) {
        //1.先创建一个新的节点
        Node node = new Node(null, value, null);
        //获取头节点和尾节点，尾节点为tail，
        //头节点为
        Node head = tail.prev;
        //处理头节点
        node.prev = head;
        head.next = node;
        //处理尾节点
        tail.prev = node;
        node.next = tail;

    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {

    }

    /**
     * 根据索引位置插入值
     *
     * @param index
     * @param value
     */
    public void insert(int index, int value) {
        /**
         * null <-666 = 1 = 3 = 8 = 5 = 7 = 9 = 999 -> null
         *         -1   0   1   2   3   4   5
         * 从head.next开始遍历链表，可以查询 index对应的节点信息
         */

        //1.查询该索引（下标-1）的节点信息，尾节点不能插入元素
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalException(index);
        }
        //尾节点信息
        Node next = prev.next;
        //创建新节点
        Node insert_node = new Node(prev, value, next);
        //head指向new，new指向head
        prev.next = insert_node;
        //tail指向new，new指向tail
        next.prev = insert_node;
    }

    public void remove(int index) {
        /**
         * null <-666 = 1 = 3 = 8 = 5 = 7 = 9 = 999 -> null
         *         -1   0   1   2   3   4   5    6      7
         * 从head.next开始遍历链表，可以查询 index对应的节点信息
         */
        //1.获取索引下标为index的节点
        Node node = findNode(index);
        if (node == null) {
            throw illegalException(index);
        }
        //获取当前元素的prev和next
        Node prev = node.prev;
        Node next = node.next;

        //修改指向
        prev.next = next;
        next.prev = prev;


    }

    private IllegalArgumentException illegalException(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }
}
