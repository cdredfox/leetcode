/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import com.xuyao.ListNode;
import com.xuyao.PrintUtils;

/**
 * @author fei.yang
 * @date 2022/6/15 - 14:22
 */
public class L25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;

        while (true) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode startNext = start.next;
            ListNode endNext = end.next;
            end.next = null;
            ListNode next = reverse(start);
            start.next = next;
            startNext.next = endNext;
            start = end = startNext;
        }
        return dummy.next;

    }

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        L25 l25 = new L25();
        ListNode node = l25.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        PrintUtils.print(node);
    }

}


