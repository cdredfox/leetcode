/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import com.xuyao.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fei.yang
 * @date 2022/6/22 - 14:50
 */
public class L54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, down = m - 1;
        int left = 0, right = n - 1;
        List<Integer> ans = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                ans.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L54 demo = new L54();
        List<Integer> result = demo.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        PrintUtils.printList(result);
    }
}
