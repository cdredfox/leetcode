/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import com.xuyao.ListNode;
import com.xuyao.PrintUtils;

/**
 * @author fei.yang
 * @date 2022/6/24 - 14:25
 */
public class L24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //求出下一轮2个节点的头
        ListNode subHead = swapPairs(head.next.next);
        //暂时把head的next节点存下来
        ListNode headNext = head.next;
        //两两交换，并将后续节点指向一下轮的计算过的头
        headNext.next = head;
        head.next = subHead;
        //返回交换后的头节点
        return headNext;

    }

    public static void main(String[] args) {
        L24 demo = new L24();
        ListNode node = demo.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        PrintUtils.print(node);
    }
}
