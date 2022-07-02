package com.xuyao.lc.list;/*
 * Copyright 2021-2022 www.xuyao.info
 */

/**
 * @author yangfei
 * @date 2022/4/29 - 09:39
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "list.ListNode{" +
                "val=" + val +
                '}';
    }
}
