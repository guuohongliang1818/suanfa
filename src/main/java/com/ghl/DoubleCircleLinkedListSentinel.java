package com.ghl;

import java.util.Iterator;

/**
 * 双向循环链表
 */
public class DoubleCircleLinkedListSentinel implements Iterable<Integer> {
    /**
     * 头哨兵和尾哨兵尾同一个节点
     * 哨兵：哨兵.prev=9 ，9.next=哨兵
     * 666 = 1 = 3 = 8 = 5 = 7 = 9 = 666
     */
    //头哨兵和尾哨兵公用一个节点
    private Node he_ta;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = he_ta.next;

            @Override
            public boolean hasNext() {
                return p != he_ta;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

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

    //构造器，初始化哨兵节点
    public DoubleCircleLinkedListSentinel() {
        he_ta = new Node(null, 666, null);
        he_ta.next = he_ta;
        he_ta.prev = he_ta;
    }

    /**
     * 头部添加节点
     *
     * @param value
     */
    public void addFirst(int value) {
        /**
         * 头哨兵和尾哨兵尾同一个节点
         * 哨兵：哨兵.prev=9 ，9.next=哨兵
         * 666 = 1 = 3 = 8 = 5 = 7 = 9
         */
        //创建新节点
        Node a = he_ta;
        Node b = he_ta.next;
        Node insert = new Node(a, value, b);
        a.next = insert;
        b.prev = insert;

    }

    /**
     * 尾部添加节点
     *
     * @param value
     */
    public void addLast(int value) {
        /**
         * 头哨兵和尾哨兵尾同一个节点
         * 哨兵：哨兵.prev=9 ，9.next=哨兵
         * 1 = 3 = 8 = 5 = 7 = 9 = 666
         */
        //创建新节点
        Node a = he_ta;
        Node b = he_ta.prev;
        Node insert = new Node(b, value, a);
        b.next = insert;
        a.prev = insert;


    }

    /**
     * 删除头节点
     */
    public void removeFirst() {
        //根据he_ta获取要删除的节点
        Node removed = he_ta.next;
        if (removed == he_ta) {
            throw new IllegalArgumentException("参数不合法");
        }
        //获取删除节点的下一个节点
        Node removed_next = removed.next;
        //修改指针关系
        he_ta.next = removed_next;
        removed_next.prev = he_ta;

    }

    /**
     * 删除尾节点
     */
    public void removeLast() {
        //根据he_ta获取要删除的节点
        Node removed = he_ta.prev;
        if (removed == he_ta) {
            throw new IllegalArgumentException("参数不合法");
        }
        //获取删除节点的前一个节点
        Node removed_prev = removed.prev;
        //修改指针关系
        removed_prev.next = he_ta;
        he_ta.prev = removed_prev;
    }

    /**
     * 根据值删除
     */
    public void removeByValue(int value) {
        Node node = findNode(value);
        //找到该删除节点的(next)(prev)
        if (node == null) {
            throw new IllegalArgumentException("参数不合法");
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private Node findNode(int value) {
        Node p = he_ta.next;
        while (p != he_ta) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
