/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fei.yang
 * @date 2022/6/10 - 13:23
 */
public class L20 {

    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deque.push(')');
            } else if (c == '{') {
                deque.push('}');
            } else if (c == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != c) {
                return false;
            } else {
                deque.pop();
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        L20 demo = new L20();
        demo.isValid("()[]{}");
    }

}
