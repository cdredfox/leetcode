/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import java.util.List;

/**
 * @author fei.yang
 * @date 2022/7/7 - 13:22
 */
public class L2 {

    /**
     * 2. 两数相加
     * 循环两个链表，每次链表的两个结点的值相加，如果有一个结果已经结束，则将值设为0加，每次计算后，记录进位值，下次一起加入
     * 循环完成后，检查进位值是否为0，如果为0，则再增加一个结点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个辅助指针，方便进行移动处理
        ListNode dummy=new ListNode();
        //定义头指针，指向dummy,方便到时候直接返回链表的头结点
        ListNode head=dummy;
        //定义进位值
        int next=0;
        //开始循环，只要有一个链表不为空，就继续往下执行
        while(l1!=null || l2!=null){
            //取两个链表当前结点的值，如果当前结点已经为空，则将值设为0，方便统一处理
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            //计算两个结点相加的值，结点1+结点2+进位值
           int sum=val1+val2+next;
           //构造一个新的结点，加到当前指针的next节点。 结点的值是sum%10,解决进位问题
           dummy.next=new ListNode(sum%10);
           //求进位值
           next=sum/10;
           //l1,l2,dummy这三个结点都往后移，向后循环
           l1=l1==null?null:l1.next;
           l2=l2==null?null:l2.next;
           dummy=dummy.next;
        }
        //如果进位值有值
        if(next!=0){
            //构建一个新的结点，加到链表上去
            dummy.next=new ListNode(next);
        }
        return head.next;
    }
    public static void main(String[] args) {
        //System.out.printf("%d",19%10);
        L2 demo=new L2();
        Print.print(demo.addTwoNumbers(new ListNode(2,new ListNode(4,new ListNode(3))),new ListNode(5,new ListNode(6))));
        System.out.printf("\n");
        Print.print(demo.addTwoNumbers(new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))))),new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))));
    }
}
