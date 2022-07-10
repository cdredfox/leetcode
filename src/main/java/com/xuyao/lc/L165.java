/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;

/**
 * @author yangfei
 * @date 2022/7/9 - 15:13
 */
public class L165 {

    /**
     * 165. 比较版本号
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        //记录两个字符串的位置
        int i=0,j=0;
        //记录两个字符串的长度
        int n=version1.length();
        int m=version2.length();
        //只要两个字符串没有越界，就一至比较下去
        while(i<n || j<m){
            //记录两个字符串各自加起来的值
            int a=0,b=0;
            //如果第一个字符串的指针小于字符串的长度，并且当前指针指向的不是.号
            while(i<n && version1.charAt(i)!='.'){
                //将a*10并加上当前值
                a=a*10+version1.charAt(i)-'0';
                i++;
            }
            i++;
            while(j<m && version2.charAt(j)!='.'){
                b=b*10+version2.charAt(j)-'0';
                j++;
            }
            j++;
            if(a!=b){
                return a>b?1:-1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        L165 demo=new L165();
        System.out.printf("%d",demo.compareVersion("1.003.1","1.002.1"));

    }
}
