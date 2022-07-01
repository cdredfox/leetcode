/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/6/20 - 17:18
 */
public class L20220620 {


    /**
     * 有一个整型数组，数组元素不重复，数组元素先升序后降序，找出最大值 例如：1,3,5,7,9,8,6,4,2，请写一个函数找出数组最大的元素
     *
     * @param nums
     * @return
     */
    public int findMaxNum(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }


    public static void main(String[] args) {
        L20220620 demo = new L20220620();
        System.out.printf(demo.findMaxNum(new int[]{1, 3, 5, 7, 9, 8, 6, 4, 2}) + "");
    }

}
