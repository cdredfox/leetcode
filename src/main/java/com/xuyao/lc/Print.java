/*
 * Copyright 2021-2022 www.xuyao.info
 */

package com.xuyao.lc;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangfei
 * @date 2022/6/12 - 08:26
 */
public class Print {

    public static void print(List list){
        for(Object element:list){
            System.out.printf("%s\n",element);
        }

    }

    public static void print(ListNode listNode){
        while(listNode!=null){
            System.out.printf(listNode.val+"");
            listNode=listNode.next;
        }
    }

    public static void print(int[][] nums){
        Arrays.stream(nums).forEach(num->{
            System.out.printf("[");
            Arrays.stream(num).forEach(n-> System.out.printf("%d ",n));
            System.out.printf("]");
        });
    }

    public static void print(int[] nums){
        Arrays.stream(nums).forEach(num-> System.out.println(num));
    }
}
