/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangfei
 * @date 2022/6/30 - 19:12
 */
public class L163 {

    /**
     * 求缺失的区间 163题，是收费题
     *  给定一个排序的整型数组，其中元素范围在 闭区间[lower,upper]当中，返回不包含在数组中的缺失区间
     *  思路：
     *  循环这个数组，比较前一值和当前值中间的差值，将差值的区间记录下来即可，考虑到边界问题，从lower的前一个元素开始
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissRange(List<Integer> nums,int lower,int upper){
        List<String> result=new ArrayList<>();
        nums.add(upper+1); //将upper的上限加1，主要是为了把upper也包含进去
        int last=lower-1;
        for(int num:nums){
            if(num-last==2){
                result.add(last+1+"");
            }else if(num-last>2){
                result.add((last+1)+"->"+(num-1));
            }
            last=num;
        }
        return result;
    }
    public static void main(String[] args) {
        L163 demo=new L163();
        List<Integer> nums=new ArrayList<>();
        nums.add(0);
        nums.add(1);
        nums.add(3);
        nums.add(50);
        nums.add(75);
        Print.print(demo.findMissRange(nums,0,99));
    }
}
