/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
import java.util.Arrays;

/**
 * @author yangfei
 * @date 2022/4/20 - 16:22
 */
public class QuickSort {


    public void sort(int[] nums,int left,int right){
        if(left>=right) return;
        int pivot=nums[right];
        int index=left;
        for(int i=left;i<right-1;i++){
            if(nums[i]<pivot){
                swap(nums,index,i);
                index++;
            }
        }
        swap(nums,index,right);
        sort(nums,left,index-1);
        sort(nums,index+1,right);

    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{5,7,2,3,6};
        new QuickSort().sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
