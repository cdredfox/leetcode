/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import com.xuyao.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author fei.yang
 * @date 2022/7/7 - 14:17
 */
public class L23 {

    /**
     * 23. 合并K个升序链表 分治合并
     *
     *  首先定义最基础的，对两个链表进行排序，
     *  然后每次合并两个链接，直到全部合并完成
      * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        //调用合并
        return merge(lists,0,lists.length-1);
    }

    /**
     * 合并一定范转的链表
     * @param lists
     * @param l
     * @param r
     * @return
     */
    public ListNode merge(ListNode[] lists,int l,int r){
        //如果左右边界相等了，那代表只有一个链表了，到了最底下，直接返回当前的链表
        if(l==r){
            return lists[l];
        }
        //不可能出现的情况，防出错
        if(l>r){
            return null;
        }
        //取中间节点
        int mid=(r+l)/2;
        //合并两个结点，递归处理
        //每次合并的两个链表是从左边界到中间节点的 和 从中间结点+1到右边界的，递归到最低下
        return mergeTwoList(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    /**
     * 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoList(ListNode list1,ListNode list2){
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
            list1.next=mergeTwoList(list1.next,list2);
            //返回头结点为list1
            return list1;
        }else{
            //如果list2<list1的值，则list2的下一个节点开始和list1的节点计算了来的最小值，递 归
            list2.next=mergeTwoList(list2.next,list1);
            //返回头结点为list2
            return list2;
        }
    }

    /**
     * 23. 合并K个升序链表 优先级队列方法
     * 首先循环链表数组，将链表都放到优先级队列中（最小堆）
     * 优先级队列，默认会进行排序
     * 然后循环弹出队列的元素，由于之前放的是链表头进去，弹出后，判断该节点是否还有下一个结点，如果有继续弹出。构造新的链表即可
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        //定义优先级队列
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(final ListNode o1, final ListNode o2) {
                return o1.val-o2.val;
            }
        });

        //循环将链表数组中的链表头节点都放到优先级队列中，能够这么做的前提是每个链表是有序的
        for(ListNode list: Arrays.asList(lists)){
            if(list==null){
                continue;
            }
            pq.offer(list);
        }

        //定义一个头节点，方便返回
        ListNode dummy=new ListNode();
        //定义一个当前节点
        ListNode current=dummy;
        //如果队列中有值，就一至往下走
        while(!pq.isEmpty()){
            //弹出当前的队列中的节点
            ListNode nextNode=pq.poll();
            //将当前节点的下一个节点指向弹出的节点
            current.next=nextNode;
            //当前节点往后移
            current= current.next;
            //如果弹出的结点还有一个节点（由于前面循环放入的是头结点）
            if(nextNode.next!=null){
                //继续放到优先级队列里面，下次处理
                pq.offer(nextNode.next);
            }

        }
        return dummy.next;
    }
    public static void main(String[] args) {
        L23 demo=new L23();
        Print.print(demo.mergeKLists(new ListNode[]{new ListNode(1,new ListNode(4,new ListNode(5))),new ListNode(1,new ListNode(3,new ListNode(4))),new ListNode(2,new ListNode(6))}));
        System.out.printf("\n");
        Print.print(demo.mergeKLists(new ListNode[]{new ListNode(1,new ListNode(4,new ListNode(5))),new ListNode()}));
        System.out.printf("\n");
        Print.print(demo.mergeKLists2(new ListNode[]{new ListNode(1,new ListNode(4,new ListNode(5))),new ListNode(1,new ListNode(3,new ListNode(4))),new ListNode(2,new ListNode(6))}));
    }

}
