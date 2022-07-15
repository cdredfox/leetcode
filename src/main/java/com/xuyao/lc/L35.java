/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/7/14 - 13:11
 */
public class L35 {

    /**
     * 在指定位置插入数字
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target){
                l=mid+1;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                return mid;
            }
        }
        return r+1;
    }
    public static void main(String[] args) {
        L35 demo=new L35();
        System.out.printf("%d",demo.searchInsert(new int[]{1,3,5,6},5));
    }
}
