/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/7/12 - 15:13
 */
public class LO22 {

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     *
     * 思路：双指针方法
     * 先定义一个指针former往前走K步，然后 current指针和前一个former针对往下移动，直到former为空。这是current的位置，就是倒数第K个结点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
      ListNode former=head;
      ListNode current=head;
      for(int i=0;i<k;i++){
          former=former.next;
      }

      while(former!=null){
          former=former.next;
          current=current.next;
      }
      return current;

    }

    public static void main(String[] args) {
        LO22 demo=new LO22();

        Print.print(demo.getKthFromEnd(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),2));
    }

}
