/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/7/1 - 13:52
 */
public class L209 {

    public int minSubArrayLen(int target, int[] nums) {
        //左指针置为0
        int left=0;
        //先将result设为数组的长度+1，为了避免 target = 11, nums = [1,1,1,1,1,1,1,1] 这种情况，在最后只要比较result的值就能判断
        int result=nums.length+1;
        int sum=0;
        //右指针开始从0开始往后遍历
        for(int right=0;right<nums.length;right++){
            //先累加当前的值
            sum=sum+nums[right];
            //如果累加的值>=target,但表有累加的各满足了条件
            while(sum>=target){
                //然后比较上一次计算的结果，取元素最小的记录下来。
                result=Math.min(result,right-left+1);
                //将当前左指针的值减去，方便往后计算
                sum=sum-nums[left];
                //左指针右移
                left++;
            }
        }
        //如果最终结果的长度=数组的长度+1，代表这个没有满足过当前的值，所以为0返回
        return result==nums.length+1?0:result;
    }

    public static void main(String[] args) {
        L209 demo=new L209();
        System.out.printf("%d",demo.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }

}
