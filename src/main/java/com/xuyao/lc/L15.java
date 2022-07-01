/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fei.yang
 * @date 2022/6/8 - 14:42
 */
public class L15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum < 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {

    }
}
