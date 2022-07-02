/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
/**
 * @author yangfei
 * @date 2022/5/24 - 13:09
 */
public class Palindrome {

    public static boolean isPalindrome(int x){
        if(x<0){
            return false;
        }
        if(x!=0 && x%10==0){
            return false;
        }

        int y=0;
        while(x>y){
            y=y*10+x%10;
            x=x/10;
        }
        return x==y || x==y/10;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(isPalindrome(123454321)));
        System.out.println(String.valueOf(isPalindrome(123)));
        System.out.println(String.valueOf(isPalindrome(-1)));
        System.out.println(String.valueOf(isPalindrome(1230)));
        System.out.println(String.valueOf(isPalindrome(55555)));
    }
}
