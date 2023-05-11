package com.ghl.datastructure;

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
        /**
         * null <-666 = 1 = 3 = 8 = 5 = 7 = 9 = 999 -> null
         *         -1   0   1   2   3   4   5    6      7
         */
        return new Iterator<Integer>() {
            //从head.next开始,同时不是尾节点
            Node  p = head.next;
            @Override
            public boolean hasNext() {
                //return p!=null && p!=tail;
                return p!=tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
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
        /**
         * null <-666 = 1 = 3 = 8 = 5 = 7 = 9 = 999 -> null
         *         -1   0   1   2   3   4   5
         */
        //获取 （tail）（tail.prev）
        //创建新节点
        Node insert = new Node(tail.prev, value, tail);
        tail.prev.next = insert;
        tail.prev = insert;

    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        /**
         * null <-666 = 1 = 3 = 8 = 5 = 7 = 9 = 999 -> null
         *         -1   0   1   2   3   4   5
         */
        //已知哨兵尾节点，所以需要获取 （tail）（tail.prev）(tail.prev.prev)
        Node removed = tail.prev;
        if (removed == head) {
            throw new IllegalArgumentException("参数不合法");
        }
        //tail.prev.prev节点
        Node removed_prev = removed.prev;
        removed_prev.next = tail;
        tail.prev = removed_prev;


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
         * 需要找到删除节点，以及删除节点的上一个节点，以及删除节点的下一个节点
         */
        //获取删除元素的上一个节点
        Node node = findNode(index - 1);
        if (node == null) {
            throw illegalException(index);
        }
        //获取要删除的节点
        Node removed = node.next;
        if (removed == tail) {
            throw illegalException(index);
        }
        //改变链表的关系
        node.next = removed.next;
        removed.next.prev = node;


    }

    private IllegalArgumentException illegalException(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }
}
