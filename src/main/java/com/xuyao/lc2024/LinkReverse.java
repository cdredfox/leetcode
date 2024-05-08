/*
 * Copyright 2021-2024 www.xuyao.info
 */
package com.xuyao.lc2024;

import com.xuyao.ListNode;
import com.xuyao.PrintUtils;

/**
 * @author yangfei
 * @date 2024/5/9 - 07:17
 */
public class LinkReverse {


     public static ListNode reverseList(ListNode head) {
         ListNode prev=null;
         ListNode curr=head;
         while(curr!=null){
             ListNode temp=curr.next;
             curr.next=prev;
             prev=curr;
             curr=temp;
         }
         return prev;
     }

    public static ListNode reverseList1(ListNode head) {
         if(head==null || head.next==null){
             return head;
         }
        ListNode newHead = reverseList1(head.next);
         head.next.next=head;
         head.next=null;
         return newHead ;
    }

    public static void main(String[] args) {
        ListNode node5=new ListNode(5,null);
        ListNode node4=new ListNode(4,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode node1=new ListNode(1,node2);
        //PrintUtils.print(reverseList(node1));
        PrintUtils.print(reverseList1(node1));
    }
}
