/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/7/13 - 14:06
 */
public class L4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int left=(n+m+1)/2;
        int right=(n+m+2)/2;
        return (findKth(nums1,0,nums2,0,left) + findKth(nums1,0,nums2,0,right))/2;
    }

    public int findKth(int[] nums1,int i,int[] nums2,int j,int k){
        if(i>=nums1.length){
            return nums2[j+k-1];
        }
        if(j>=nums2.length){
            return nums1[i+k-1];
        }
        if(k==1){
            return Math.min(nums1[i],nums2[j]);
        }
        int m1=(i+k/2-1 < nums1.length ? nums1[i+k/2-1]:Integer.MAX_VALUE);
        int m2=(j+k/2-1 < nums2.length ? nums2[j+k/2-1]:Integer.MAX_VALUE);
        if(m1<m2){
            return findKth(nums1,i+k/2,nums2,j,k-k/2);
        }else{
            return findKth(nums1,i,nums2,j+k/2,k-k/2);
        }
    }

    public static void main(String[] args) {
        L4 demo=new L4();
        System.out.printf("%f",demo.findMedianSortedArrays(new int[]{1,3,4,9},new int[]{1,2,3,4,5,6,7,8,9}));
    }

}
