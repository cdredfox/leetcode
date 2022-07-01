/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/6/8 - 14:05
 */
public class L875 {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 0, r = (int) 1e9;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public boolean check(int[] piles, int h, int mid) {
        int ans = 0;
        for (int x : piles) {
            ans += Math.ceil(x * 1.0 / mid);
        }
        return ans <= h;
    }

    public static void main(String[] args) {
        L875 test = new L875();
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 8;
        System.out.println(test.minEatingSpeed(piles, h));
    }
}
