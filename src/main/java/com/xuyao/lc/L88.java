/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
/**
 * @author yangfei
 * @date 2022/6/18 - 10:19
 */

public class L88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx=m+n-1;
        int i=m-1;
        int j=n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[idx--]=nums1[i--];
            }else{
                nums1[idx--]=nums2[j--];
            }
        }
        while(j>=0){
            nums1[idx--]=nums2[j--];
        }
    }
    public static void main(String[] args) {
        L88 l88=new L88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        l88.merge(nums1,3,new int[]{2,5,6},3);
        Print.print(nums1);
    }
}
