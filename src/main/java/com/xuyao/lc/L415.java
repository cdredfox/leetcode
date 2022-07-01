/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/6/7 - 17:05
 */
public class L415 {

    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuffer res = new StringBuffer();
        while (i >= 0 || j >= 0) {
            int n = i >= 0 ? num1.charAt(i) - '0' : 0;
            int m = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = m + n + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(carry);
        }
        return res.reverse().toString();

    }

    public static void main(String[] args) {
        L415 demo = new L415();
        System.out.printf(demo.addStrings("51", "5"));
    }
}
