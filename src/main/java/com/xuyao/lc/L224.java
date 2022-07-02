/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
import jdk.internal.dynalink.beans.StaticClass;

import java.util.Stack;

/**
 * @author yangfei
 * @date 2022/6/26 - 14:55
 */
public class L224 {
    /**
     * 具体操作如下：
     * 1、使用栈来储存字符串表达式中的数字，设置变量 res 保存计算的结果，一开始可以认为 res = 0，作为左表达式，同时当前的运算符为 + ，接下来去变量字符数组，先去寻找出右表达式出来。
     * 2、获取字符串里面的每个字符
     * 3、如果当前字符是数字的话，需要去查看当前字符的后一位是否存在，如果后一位依旧是数字，那么就需要把后面的数字累加上来，比如下图中的 12，查看到 1 时，继续查看后面的数字是 2 ，于是和 1 组成了 12，再向后看发现是字符，自此，这个数字 12 就形成了。
     * 4、一旦确定了一个数字，需要把这个数字进行一个计算， res = res + sign * value。
     * 5、如果遇到的是运算符 + 或者 - ，那么为了方便计算，所有的操作都视为加法操作，即原先的减法操作就相当于是加一个负数。
     * 6、如果遇到的是 （ ，根据数学计算规则，需要先计算括号里面的数字，而什么时候计算呢？遇到 ) 为止，所以，在遇到 ) 之前需要把之前计算好的结果存储起来再计算。
     * 7、如果遇到的是 ），那么就需要把栈中存放的元素取出来了。
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        int sign=1;//默认都为加一个数，如果减一个数，也认为是加一个数，只是将该数变成一个负数
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int value=ch-'0';
                while(i+1<n && Character.isDigit(s.charAt(i+1))){
                    i++;
                    value=value*10+s.charAt(i);
                }
                res=res+sign*value;
            }else if(ch=='+'){
                sign=1;
            }else if(ch=='-'){
                sign=-1;
            }else if(ch=='('){
                //如果遇到(号，则将前面计算的结果存在堆栈中，并且将之前的操作符中也存下来，方便)结束的时候计算
                stack.push(sign);
                stack.push(res);
                sign=1;
                res=0;
            }else if(ch==')'){
                int fRes=stack.pop();
                int fSign=stack.pop();
                res=fRes+fSign*res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L224 demo=new L224();
        System.out.println(demo.calculate("2147483647"));
    }
}
