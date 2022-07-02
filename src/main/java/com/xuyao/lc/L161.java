/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
/**
 * @author yangfei
 * @date 2022/6/21 - 20:30
 */
public class L161 {

    public boolean isOneEditDistance(String s,String t){
        int n=s.length();
        int m=t.length();
        if(n<m){
            return isOneEditDistance(t,s);
        }
        if(n-m>1){
            return false;
        }

        for(int i=0;i<m;i++){
            if(s.charAt(i)!=t.charAt(i)){
                if(m==n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }else{
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        return n==m+1;
    }
    public static void main(String[] args) {
        L161 demo=new L161();
        System.out.println(demo.isOneEditDistance("ab","acb")+"");
        System.out.println(demo.isOneEditDistance("cab","ad")+"");
    }
}
