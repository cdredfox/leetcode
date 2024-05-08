/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;


import com.xuyao.ListNode;

/**
 * @author yangfei
 * @date 2022/6/12 - 08:09
 */
public class L143 {

    public void reorderList(ListNode head){
        //找到中间节点
        ListNode midNode=findMidNode(head);
        //中间节点以后的结点进行反转
        ListNode next=reverseListNode(midNode);
        midNode.next=null;
        //合并两个结点
        mergeListNode(head,next);
    }

    public ListNode findMidNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode reverseListNode(ListNode head){
        ListNode current=head;
        ListNode prev=null;
        while(current!=null){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
    }

    public ListNode mergeListNode(ListNode l1,ListNode l2){
        while(l1 !=null && l2!=null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
        return l1;
    }

    public static void main(String[] args) {
        L143 l143=new L143();
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))));
        l143.reorderList(head);
        Print.print(head);
    }
}
