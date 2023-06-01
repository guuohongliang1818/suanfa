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

    /**
     * 构造一个新链表，从旧链表头部移除节点添加到新链表头部，即可完成新链表即是倒序的
     *
     * @param o1
     * @return
     */
    public static ListNode reverseList2(ListNode o1) {
        ListNode p = o1;
        ListNode n1 = null;
        while (p != null) {
            //不用创建新节点，获取旧链表的
            //将旧链表的next指针指向
            p.next = n1;
            //n1 = p.next;
            p = p.next;
        }


        return n1;
    }


    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = reverseList2(o1);
        System.out.println(n1);


    }


}
