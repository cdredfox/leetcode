/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;

import com.xuyao.ListNode;

/**
 * @author yangfei
 * @date 2022/7/10 - 19:12
 */
public class L148 {

    /**
     * 148 链表的排序
     * 思路：自顶向下归并排序
     * 首先找到中间节点（通过快慢指针）
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return sort(head,null);
    }

    public ListNode sort(ListNode start,ListNode end){
        if(start==end){
            return start;
        }
        ListNode slow=start,fast=start;
        while(fast!=end && fast.next!=end){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode left=sort(slow.next,end);
        slow.next=null;
        ListNode right=sort(start,slow);
        return mergeList(left,right);
    }

    public ListNode mergeList(ListNode l1,ListNode l2){
        if(l1==null || l2==null){
            return l1==null ? l2:l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeList(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeList(l2.next,l1);
            return l2;
        }


    }

    public static void main(String[] args) {
        L148 demo=new L148();
        Print.print(demo.sortList(new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3))))));
    }
}
