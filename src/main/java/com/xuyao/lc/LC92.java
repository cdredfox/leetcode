/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import com.xuyao.ListNode;
import com.xuyao.PrintUtils;

/**
 * @author fei.yang
 * @date 2022/6/28 - 13:42
 */
public class LC92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode startPre = dummy;
        ListNode end = dummy;
        for (int i = 0; i < left - 1; i++) {
            startPre = startPre.next;
            end = end.next;
        }
        for (int i = 0; i < right - left + 1; i++) {
            end = end.next;
        }

        ListNode start = startPre.next;
        ListNode next = end.next;
        end.next = null;
        ListNode node = reverse(start);
        startPre.next = node;
        start.next = next;
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        LC92 demo = new LC92();
        //ListNode node = demo.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
        ListNode node = demo.reverseBetween(new ListNode(3, new ListNode(5)), 1, 2);
        PrintUtils.print(node);
    }

}
