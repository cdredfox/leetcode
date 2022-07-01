/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/6/29 - 15:07
 */
public class L69 {

    private int s;

    public int mySqrt(int x) {
        s = x;
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return x;
        }

        return (int) sqrt(x);
    }

    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public double sqrt(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res);
        }
    }

    public static void main(String[] args) {
        L69 demo = new L69();
        System.out.println(demo.mySqrt(4));
    }

}
