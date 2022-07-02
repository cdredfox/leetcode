package com.xuyao.lc.list;/*
 * Copyright 2021-2022 www.xuyao.info
 */

/**
 * @author yangfei
 * @date 2022/5/8 - 10:00
 */
public class LoopNode {

    private static boolean existLoopNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    private static ListNode findLoopNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                fast=head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                    if(slow==fast){
                        return slow;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode one=new ListNode(2);
        ListNode two=new ListNode(3);
        ListNode three=new ListNode(4);
        ListNode four=new ListNode(5);
        ListNode five=new ListNode(6);
        ListNode six=new ListNode(7);
        head.next=one;
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        five.next=six;
        six.next=three;
        System.out.println("是否存在环形结点"+LoopNode.existLoopNode(head));
        System.out.println("找到的入环节点"+LoopNode.findLoopNode(head));
        System.out.println(9/3);
    }
}
