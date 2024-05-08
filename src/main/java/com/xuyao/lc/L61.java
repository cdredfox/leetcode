/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import com.xuyao.ListNode;
import com.xuyao.PrintUtils;

/**
 * @author fei.yang
 * @date 2022/6/21 - 13:57
 */
public class L61 {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        //先计算出链表的节点个数
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        //避免K很大，做个取余，如果K 1000,而元素只有999个，则只需要移动一个即可
        k = k % size;
        //定义两个结点都指向head,former先往前走K步
        ListNode former = head;
        ListNode latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }

        //如果former.next不为空的话，就两个结点一起走
        while (former.next != null) {
            former = former.next;
            latter = latter.next;
        }
        //former走到最后一个元素后，将former的下一个结点指向头节点
        former.next = head;
        //这时候的头节点就是就是latter的位置
        ListNode newHead = latter.next;
        //latter的next置空，避免形成循环
        latter.next = null;
        return newHead;

    }

    public static void main(String[] args) {
        L61 demo = new L61();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        PrintUtils.print(demo.rotateRight(head, 2));
    }

}
