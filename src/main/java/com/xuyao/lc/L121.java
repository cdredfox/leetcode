/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
/**
 * @author yangfei
 * @date 2022/6/12 - 08:55
 */
public class L121 {


    /**
     * 循环，每次取到当前价格为值最小值，每次计算收益（当前价格-当前小值）和最大值取最大值，循环完，即得到最大的收益
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1){
            return 0;
        }
        int min=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        L121 l121=new L121();
        System.out.printf(l121.maxProfit(new int[]{7,1,5,3,6,4})+"");
    }


}
