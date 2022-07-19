/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import static java.util.Comparator.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author fei.yang
 * @date 2022/7/19 - 17:02
 */
public class L31 {

    /**
     * 31. 下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //取数组的最大坐标
        int n=nums.length-1;
        //从数组的最后一个元素，往前遍历
        for(int i=n;i>0;i--){
            //如果发现当前元素比前一个元素大
            if(nums[i]>nums[i-1]){
                //则把从当前位置到数组尾部的元素进行升序排度
                Arrays.sort(nums,i,nums.length);
                //从当前位置开始往后遍历，找第一个大于当前元素前一个元素大的值，因于已经升序排过序，所以一定是里面第一个大于前一个值的
                for(int j=i;j<=n;j++){
                    //如果当前遍历的值大于上一轮前一个元素的值
                    if(nums[j]>nums[i-1]){
                        //则将两个数字进行交换，并返回，这样就获得了比当前数大的第一个数
                        int temp=nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=temp;
                        return;
                    }
                }
            }
        }
        //如果遍历下来，走到这里倒序的，直接反转就可以了
        Arrays.sort(nums);
    }
    public static void main(String[] args) {
        L31 demo=new L31();
        int[] params=new int[]{1,2,8,5,7,6,4};
        demo.nextPermutation(params);
        Print.print(params);
    }

}
