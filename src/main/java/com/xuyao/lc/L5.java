/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/6/21 - 10:46
 */
public class L5 {

    /**
     * 核心思路： 找到某个节点，往左和往右扩展，循环完后，找最大的字符串即可
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return "";
        }
        String maxLenStr = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expend(s, i, i);
            String s2 = expend(s, i, i + 1);
            maxLenStr = maxLenStr.length() > s1.length() ? maxLenStr : s1;
            maxLenStr = maxLenStr.length() > s2.length() ? maxLenStr : s2;
        }
        return maxLenStr;
    }

    public String expend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        L5 demo = new L5();
        System.out.println(demo.longestPalindrome("32122145"));
    }
}
