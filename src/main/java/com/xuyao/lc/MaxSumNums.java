/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
/**
 * @author yangfei
 * @date 2022/4/28 - 12:26
 */
public class MaxSumNums {


    /***
     * 求数组中的最大子数组累加和
     */
    public static int maxSumNums(int[] nums){
        if(nums==null || nums.length<=0){
            return -1;
        }
        int n=nums.length;
        int pre=nums[0];
        int max=0;
        for(int i=1;i<n;i++){
            int p1=nums[i];
            int p2=nums[i]+pre;
            int cur=Math.max(p1,p2);
            max=Math.max(cur,max);
            pre=cur;
        }
        return max;
    }


    /**
     * 数组里有0和1，一定要翻转一个区间，翻转：0变1，1变0。 请问翻转后可以使得1个数最多的是多少
     *
     * 解法：
     * 转换为数组中的最大子数组和的方式来解，把0变成1,1变成-1，然后计算
     */
    public static int invertMaxSums(int[] nums){
        if(nums==null || nums.length<=0){
            return -1;
        }

        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]==0?1:-1;
        }
        return MaxSumNums.maxSumNums(nums);
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,1,-3,4,-1,2,1,-5,4};
        System.out.println(MaxSumNums.maxSumNums(nums)+"");
        int[] nums2=new int[]{1,1,0,0,1,0,1,0,0,0,1,1};
        System.out.println(MaxSumNums.invertMaxSums(nums2)+"");
    }
}
