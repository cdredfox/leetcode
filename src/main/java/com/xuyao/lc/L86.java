/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;

import com.xuyao.ListNode;

/**
 * @author yangfei
 * @date 2022/6/17 - 15:36
 */
public class L86 {

    public ListNode partition(ListNode head, int x) {
        ListNode lowNode=new ListNode(-1);
        ListNode hightNode=new ListNode(-1);
        ListNode hightHeadNode=hightNode;
        ListNode lowHeadNode=lowNode;
        while(head!=null){
            if(head.val<x){
                lowNode.next=head;
                lowNode=lowNode.next;
            }else{
                hightNode.next=head;
                hightNode=hightNode.next;
            }
            head=head.next;
        }
        lowNode.next=hightHeadNode.next;
        hightNode.next=null;
        return lowHeadNode.next;
    }

    public static void main(String[] args) {
        L86 l86=new L86();
        ListNode node=l86.partition(new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2)))))),3);
        Print.print(node);
    }
}
