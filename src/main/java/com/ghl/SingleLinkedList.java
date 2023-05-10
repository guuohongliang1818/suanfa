package com.ghl;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SingleLinkedList implements Iterable<Integer> {//整体
    private Node head = null;//头指针


    /**
     * 节点类：
     * 这个类是相对独立的，和外部成员变量没有关系，那么在类上就可以加static关键字
     */
    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加元素
     */
    public void addFirst(int value) {
        //1.链表为空的情况
        //head = new Node(value,null);
        //2.链表非空
        head = new Node(value, head);
    }

    /**
     * 遍历链表:while循环
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历方法2:for循环
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类-》带名字的内部类
        return new NodeIterator();
    }

    /**
     * 这个内部类，使用了外部类的成员变量head，所以不能加static，因为这个类和外部类的实例相关了
     */
    private class NodeIterator implements Iterator<Integer> {
        Node p = head;

        @Override
        public boolean hasNext() {//(是否有下一个元素)当p！=null时，有下一个元素
            return p != null;
        }

        @Override
        public Integer next() {//返回当前值，并指向下一个元素
            int t = p.value;
            p = p.next;
            return t;
        }
    }

    /**
     * 遍历方法3，增强for循环
     *
     * @return
     */
//    @Override
//    public Iterator<Integer> iterator() {
//        //匿名内部类-》带名字的内部类
//        return new Iterator<Integer>() {
//            Node p = head;
//
//            @Override
//            public boolean hasNext() {//(是否有下一个元素)当p！=null时，有下一个元素
//                return p != null;
//            }
//
//            @Override
//            public Integer next() {//返回当前值，并指向下一个元素
//                int t = p.value;
//                p = p.next;
//                return t;
//            }
//        };
//    }
    public void addLast(int value) {

        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);


    }

    private Node findLast() {
//        Node pre = null;
//        Node pointer = head;
//        while (pointer != null) {//使用指针寻找最后一个Node节点
//            pre = pointer;
//            pointer = pointer.next;
//        }
//        //如果p为null,则应该返回它的上一个节点
//        return pre;
        //链表尾空时
        if (head == null) {
            return null;
        }
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        return pointer;
    }

    /**
     * 链表没有索引，只有在遍历的时候才会知道
     */
    private void test() {
        //获取索引的值
        /**
         * p!=null,但是p.next可能等于null,所以p此时指向的元素为null
         * p!=null,p.next!=null，所以p此时指向的元素为最后一个节点，该节点！=null
         */
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            System.out.println(p.value + "，索引是：" + i);
        }
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        return node.value;
    }

    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            //System.out.println(p.value + "，索引是：" + i);
            if (i == index) {
                return p;
            }
        }
        return null;//没有找到
    }
}

