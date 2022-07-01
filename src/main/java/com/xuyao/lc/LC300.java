/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import java.util.Arrays;

/**
 * @author fei.yang
 * @date 2022/6/28 - 15:56
 */
public class LC300 {

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] tail = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int left = 0, right = res;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tail[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tail[left] = num;
            if (right == res) {
                res++;
            }
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LC300 demo = new LC300();
        //System.out.println(demo.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(demo.lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
