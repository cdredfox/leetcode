/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import com.xuyao.ListNode;

/**
 * @author fei.yang
 * @date 2022/7/4 - 15:36
 */
public class L19 {

    /**
     * 快慢指针来解决，
     * 先让快指针走N步，然后慢指针和快指针同时移动，如果快指针的下一个节点为空，则当前slow节点指向的是目标节点的上一个节点
     * 然后将slow的next节点指向下下个节点，那么倒数n的节点即被删除了
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个虚拟节点，方便操作
        ListNode dummy=new ListNode();
        //将dummy的下一个节点指向头节点
        dummy.next=head;
        //定义快慢节点指向dummy
        ListNode slow=dummy;
        ListNode fast=dummy;
        //先将快指针往下走N步
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        //如果快节点的下一个指针不为空，则快慢节点同时向下移动，当快指针的下一个元素为空时，慢节点就指向了目标结点的上一个结点
        while(fast!=null && fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        //然后将慢指针的下一个节点（即原先指向目标节点）的指向目标节点的下一个节，即实现了目标节点的删除
        slow.next=slow.next.next;
        //返回头节点
        return dummy.next;
    }

    public static void main(String[] args) {
        L19 demo=new L19();
        Print.print(demo.removeNthFromEnd(new ListNode(1,new ListNode(2)),1));
        System.out.printf("====");
        Print.print(demo.removeNthFromEnd(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),2));
    }

}
