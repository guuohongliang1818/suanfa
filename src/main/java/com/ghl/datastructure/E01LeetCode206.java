package com.ghl.datastructure;

public class E01LeetCode206 {

    public static ListNode reverseList(ListNode head) {
        return head;
    }


    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = reverseList(o1);
        System.out.println(n1);


    }


}
