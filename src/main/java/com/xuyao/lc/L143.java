/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/6/22 - 13:13
 */
public class L143 {

    /**
     * 重排链表
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode midNode = findMidNode(head);
        ListNode next = reverse(midNode);
        midNode.next = null;
        mergeList(head, next);
    }

    public void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }


    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        L143 demo = new L143();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        demo.reorderList(node);
        PrintUtils.print(node);
    }

}
