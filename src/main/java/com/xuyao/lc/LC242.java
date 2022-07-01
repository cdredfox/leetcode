/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/6/27 - 13:32
 */
public class LC242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            table[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int index = ch - 'a';
            table[index]--;
            if (table[index] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC242 demo = new LC242();
        System.out.println(demo.isAnagram("rat", "car"));
    }

}
