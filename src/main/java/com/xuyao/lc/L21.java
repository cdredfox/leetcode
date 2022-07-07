/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import java.util.List;

/**
 * @author fei.yang
 * @date 2022/7/7 - 14:36
 */
public class L21 {

    /**
     * L21, 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //如果任何一个链表为空，则返回另一个链表
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        //如果list1的值<list2的值
        if(list1.val<list2.val){
            //将list1的下一个节点设置为 list1的下一个节点开始和list2的节点计算了来的最小值，递 归
            list1.next=mergeTwoLists(list1.next,list2);
            //返回头结点为list1
            return list1;
        }else{
            //如果list2<list1的值，则list2的下一个节点开始和list1的节点计算了来的最小值，递 归
            list2.next=mergeTwoLists(list2.next,list1);
            //返回头结点为list2
            return list2;
        }
    }
    public static void main(String[] args) {
        L21 demo=new L21();
        Print.print(demo.mergeTwoLists(new ListNode(1,new ListNode(2,new ListNode(4))),new ListNode(1,new ListNode(3,new ListNode(4)))));
    }

}
