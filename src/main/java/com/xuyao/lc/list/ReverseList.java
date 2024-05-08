package com.xuyao.lc.list;

import com.xuyao.ListNode;

/**
 * Definition for singly-linked list.
 * public class list.ListNode {
 *     int val;
 *     list.ListNode next;
 *     list.ListNode() {}
 *     list.ListNode(int val) { this.val = val; }
 *     list.ListNode(int val, list.ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseList {


    public static ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode current=head;
        while(current!=null){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        reverseList(node1);
        System.out.printf("node1: %d, node2: %d, node3: %d, node4: %d, node5: %d\n", node1.val, node2.val, node3.val, node4.val, node5.val);
    }
}


