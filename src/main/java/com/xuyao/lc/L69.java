/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/6/29 - 15:07
 */
public class L69 {

    public int mySqrt(int x) {
        int l=0,r=x,ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if((long)mid*mid<=x){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L69 demo = new L69();
        System.out.println(demo.mySqrt(8));
    }

}
