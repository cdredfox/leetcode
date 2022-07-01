/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fei.yang
 * @date 2022/6/14 - 10:38
 */
public class L155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.printf(minStack.getMin() + " ");
        minStack.pop();
        System.out.printf(minStack.top() + " ");
        System.out.printf(minStack.getMin() + " ");
    }
}

class MinStack {

    private Deque<Integer[]> deque = new ArrayDeque();

    public MinStack() {
    }

    public void push(int val) {
        if (deque.isEmpty()) {
            deque.push(new Integer[]{val, val});
        } else {
            deque.push(new Integer[]{val, Math.min(val, getMin())});
        }
    }

    public void pop() {
        deque.pop();
    }

    public int top() {
        return deque.peek()[0];
    }

    public int getMin() {
        return deque.peek()[1];
    }
}

