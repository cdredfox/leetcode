/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
/**
 * @author yangfei
 * @date 2022/6/19 - 15:45
 */
public class L5 {

    public String longestPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
//            int l=i-1;
//            int r=i+1;
//            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
//                l--;
//                r++;
//            }
//            if(ans.length()<r-l-1){
//                ans=s.substring(l+1,r-l-1);
//            }

           int l=i;
           int r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(ans.length()<r-l-1){
                ans=s.substring(l+1,r-l-1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L5 l5=new L5();
        //System.out.println(l5.longestPalindrome("babad"));
        System.out.println(l5.longestPalindrome("cbbd"));
    }
}
