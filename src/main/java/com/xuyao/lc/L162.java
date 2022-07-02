/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
/**
 * @author yangfei
 * @date 2022/6/25 - 21:15
 */
public class L162 {

    public int findPeakElement(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<r){
            mid=l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        L162 demo=new L162();
        System.out.println(demo.findPeakElement(new int[]{1,2,3,1}));
    }
}
