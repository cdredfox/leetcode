/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/7/6 - 13:09
 */
public class L876 {

    /**
     * 876. 链表的中间结点
     * 通过快慢节点的方式来找快慢节点，当快节点走到最后的时候，慢节点所处的位置就是链表的中间节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        L876 demo=new L876();
        Print.print(demo.middleNode(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))))));
        System.out.printf("\n========\n");
        Print.print(demo.middleNode(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))))));
    }

}
