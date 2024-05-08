/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao;

import com.xuyao.ListNode;

import java.util.List;

/**
 * @author fei.yang
 * @date 2022/6/15 - 14:32
 */
public class PrintUtils {

    public static void print(ListNode head) {
        while (head != null) {
            System.out.printf(head.val + " ");
            head = head.next;
        }
    }

    public static void printList(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.printf(num + ",");
        }
    }

    public static void print(List<List<Integer>> nums) {
        for (List<Integer> rows : nums) {
            System.out.printf("[");
            for (Integer num : rows) {
                System.out.printf(num + ",");
            }
            System.out.printf("]");
        }
    }
}
