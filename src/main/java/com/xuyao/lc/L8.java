/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/7/18 - 14:59
 */
public class L8 {


    /**
     * L8 字符串转换整数 (atoi)
     * 1,读入字符串并丢弃无用的前导空格
     * 2,检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 3,读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 4,将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 5,如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     * 6,返回整数作为最终结果。
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        //将字符串转换为字符数组，方便处理
        char[] chars=s.toCharArray();
        //取字符数组的长度
        int n=chars.length;
        //当前定位到字符数组的下标
        int idx=0;
        //正负标志
        boolean negative=false;
        //跳过前导的空格
        while(idx<n && chars[idx]==' '){
            idx++;
        }
        //如果发现全部是空格，直接返回
        if(idx==n){
            return 0;
        }
        //接下来处理符号
        //如果是-号，则将正负标志设为true,并且坐标加1
        if(chars[idx]=='-'){
            negative=true;
            idx++;
        }else if(chars[idx]=='+'){
            //如果是+号，则将正负标志设置为flase,并且坐标加1
            negative=false;
            idx++;
        }else if(!Character.isDigit(chars[idx])){
            //如果发现继不是+/-号，也不是数字，则直接返回0
            return 0;
        }
        //记录最终结果
        int ans=0;
        //如果下标还小于长度，并且是数字，进行数字拼装
        while(idx<n && Character.isDigit(chars[idx])){
            //将当前值置的字符转换为数字
            int digit=chars[idx]-'0';
            //如果当前已经累计算出来的数字 大于 （整数的最大值-本次的值）/10 则代表超出了整数的最大，因为下面会把
            //当前的ans*10再加上本次的值
            if(ans>(Integer.MAX_VALUE-digit)/10){
                //如果超过了数的范围，则就根据当前符号是正负，分别返回正整数最大值和的最小值
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            //将已经累加的值*10再加上本次的值
            ans=ans*10+digit;
            //坐标增加1
            idx++;
        }
        //根据符号返回对应的值
        return negative? -1*ans:ans;
    }
    public static void main(String[] args) {
        L8 demo=new L8();
        System.out.printf("%d",demo.myAtoi("21474836460"));
    }

}
