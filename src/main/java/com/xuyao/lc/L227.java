/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
import java.util.Stack;

/**
 * @author yangfei
 * @date 2022/6/26 - 15:22
 */
public class L227 {

    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int num=0;
        char preSign='+';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+ch-'0';
            }
            if(!Character.isDigit(ch) && ch!=' ' || i==s.length()-1){
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-1*num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    default:
                        stack.push(stack.pop()/num);
                        break;
                }
                preSign=s.charAt(i);
                num=0;
            }
        }
        int ans=0;
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        L227 demo=new L227();
        System.out.println(demo.calculate("3+2*2"));
    }
}
