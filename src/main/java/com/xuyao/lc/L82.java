/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;

import com.xuyao.ListNode;

/**
 * @author yangfei
 * @date 2022/7/11 - 19:55
 */
public class L82 {

    /**
     * L82 82. 删除排序链表中的重复元素 II
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }

        //定义一个虚拟结点，用来操作指针，主要为了避免第1个元素就是重复的情况
        ListNode dummy=new ListNode(-1,head);
        //定义一个current指针，用来移动
        ListNode current=dummy;
        //如果第一个指针不为空，并且第一个指针的下一个指针也不为空，则进入循环
        while(current.next!=null && current.next.next!=null){
            //如果第一个指针和下一个指针的值相等，则代表当前进入了值相等的情况
            if(current.next.val==current.next.next.val){
                //将值给记下来
                int val=current.next.val;
                //循环处理，如果第一个针对不为空，并且值也等于记录的值，就开始循环
                while(current.next!=null && current.next.val==val){
                    //相等的话，current.next 往下移一位，下一次继续处理current.next
                    current.next=current.next.next;
                }
            }else{
                //如果值不相等，则把current指针往下移
                current=current.next;
            }
        }
        //返回值
        return dummy.next;

    }

    public static void main(String[] args) {
        L82 demo=new L82();
        Print.print(demo.deleteDuplicates(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5)))))))));
    }
}
