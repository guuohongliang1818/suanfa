package com.ghl.datastructure;

public class E01LeetCode206 {

    public static ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }


    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }
    }

    /**
     * 构造一个新链表，从旧链表头部移除节点添加到新链表头部，即可完成新链表即是倒序的
     *
     * @param
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        while (true) {
            ListNode first = list1.removeFirst();
            if (first == null) {
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }

    /**
     * 方法三使用递归，完成反转
     *
     * @param
     */
    public static ListNode reverseList3(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode last = reverseList3(p.next);
        p.next.next = p;
        p.next = null;
        return last;
    }


    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = reverseList3(o1);
        System.out.println(n1);


    }


}
