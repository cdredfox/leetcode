/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangfei
 * @date 2022/6/17 - 08:51
 */
public class L159 {

    /**
     * 至多包含两个不同字符的最长子串
     * 给定一个字符串s,找到至多包含两个不同学符的最长子串t,并返回该子串的长度
     *  如：eceba,3,ece;ccaabbb,5,aabbb
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s){
        //结果记数
      int ans=0;
      //map用来记录出现的字符以及次数
      Map<Character,Integer> map=new HashMap<>();
      //开始滑动，定义i,j都为0，i为滑动指针往后滑动，j做为左边界
      for(int i=0,j=0;i<s.length();i++){
          //获取当前滑动位置的字母
          char c=s.charAt(i);
          //如果该字符在map中不存在，则直接放入，如果存在，则直接将出现的次数+1
          map.put(c,map.get(c)==null?1:map.get(c)+1);
          //如果map中的key即字符大于2个的时候，要滑动左边界，用while因为一个字符在前面可能出多次，要把它处理完
          while(map.size()>2){
              //取出当前左边界字符出现的次数
              int count=map.get(s.charAt(j));
              //将次数减一
              count--;
              //将值放回到map中
              map.put(s.charAt(j),count);
              //如果次数已经小于等于0
              if(count<=0){
                  //移除当前的字符
                  map.remove(s.charAt(j));
              }
              //左边界向右移动
              j++;
          }
          //将当前的取得的结果和本次计算出来的长度来比较，取最大的放到结果变量中
          ans=Math.max(ans,i-j+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        L159 l159=new L159();
        System.out.println(l159.lengthOfLongestSubstringTwoDistinct("ccaabbb"));

    }
}
