/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fei.yang
 * @date 2022/7/20 - 13:37
 */
public class L22 {
    List<String> result=new ArrayList<>();

    /**
     * 22，生成有效的括号
     * 使用DFS方式来做:当前括号序列中左括号数量小于N，可以继续添加左括号； 当前括号序列中右括号数量小于左括号数量，可以继续添加右括号。
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return result;
    }

    public void dfs(int left,int right,String curror){
        // 左右括号都不剩余了，递归终止
        if(left==0 && right==0){
            result.add(curror);
            return;
        }
        // 如果左括号还剩余的话，可以拼接左括号
        if(left >0 ){
            dfs(left-1,right,curror+"(");
        }
        // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
        if(right>left){
            dfs(left,right-1,curror+")");
        }
    }
    public static void main(String[] args) {
        L22 demo=new L22();
        Print.print(demo.generateParenthesis(3));
    }

}
