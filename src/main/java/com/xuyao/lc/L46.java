/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fei.yang
 * @date 2022/6/20 - 13:30
 */
public class L46 {

    //存储结果
    private List<List<Integer>> ans = new ArrayList<>();
    //存储单行的数据
    private LinkedList<Integer> row = new LinkedList<>();
    //标识数据是否使用
    private boolean useList[];

    public List<List<Integer>> permute(int[] nums) {
        //初始化使用数组
        useList = new boolean[nums.length];
        //开始遍历
        dfs(nums);
        return ans;
    }

    public void dfs(int[] nums) {
        //如果当前的数据已经满了，则加到结果中
        if (row.size() == nums.length) {
            ans.add(new ArrayList<>(row));
            return;
        }
        //开始循环
        for (int i = 0; i < nums.length; i++) {
            if (!useList[i]) {
                row.add(nums[i]);
                useList[i] = true;
                dfs(nums);
                row.removeLast();
                useList[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        L46 l46 = new L46();
        List<List<Integer>> result = l46.permute(new int[]{1, 2, 3});
        PrintUtils.print(result);
    }

}
