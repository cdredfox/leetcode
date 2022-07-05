/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/7/5 - 14:39
 */
public class L70 {

    /**
     * 70. 爬楼梯
     * 思路：典型的动态规划问题，可以将问题拆分成多个子问题。 第N阶楼梯的数量=N-1的数量+N-2的数量
     * 第1阶楼梯的方法有1种
     * 第2阶楼梯的方法有2种，（1+1，2）
     * 为了方便处理，我们把数组0下标设置为0阶楼梯，正好符合我们的方法，默认值为0，不用特别设置
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        //先定义数组
        int[] dp=new int[n+2];
        //将下标为0的元素这里写出来，是为了方便了解，相当于0阶楼梯，不需要爬
        //dp[0]=0;
        //1阶
        dp[1]=1;
        //2阶
        dp[2]=2;
        //然后从3开始，直到N阶楼递
        for(int i=3;i<=n;i++){
            //每次计算当前层的值，为 当前值-1 + 当前值-2
            dp[i]=dp[i-2]+dp[i-1];
        }
       //返回结果
        return dp[n];
    }

    public static void main(String[] args) {
        L70 demo=new L70();
        System.out.printf("%d",demo.climbStairs(35));
    }
}
