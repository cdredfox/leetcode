/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/6/10 - 10:11
 */
public class L912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                print(nums);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        index--;
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println("" + nums[i]);
        }
    }

    public static void main(String[] args) {
        L912 l912 = new L912();
        int[] nums = {5, 4, 3, 2, 1};
        int[] result = l912.sortArray(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.printf(result[i] + " ");
        }
    }
}
