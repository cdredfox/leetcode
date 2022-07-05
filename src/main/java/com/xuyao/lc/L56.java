/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author fei.yang
 * @date 2022/7/5 - 13:13
 */
public class L56 {

    /**
     * 56. 合并区间
     * 思路：先将数组按左边界就行排序，即二维数组中的数组按第一个元素排序，使得变成有序
     * 然后用一个结果来存储最终合并出来的结果
     * 如果前一个数组的右边界，第2个元素 >= 当前数组的左边界（第一个元素)，则代表这两个数组之前有重叠的部分，则将前一个数组的右边界进行更改，将大的值更改到前一个数组的右边界。
     * 这样两个数组就完成了合并；如果是小于，则代表这两个数组没有重叠，则放到新的结果集中，继续循环处理完即可
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        //先将二维数组按数组中的第一个元素进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //定义保存结果的对象
        List<int[]> mergeResult=new ArrayList<>();
        //循环二维数组
        for(int i=0;i<intervals.length;i++){
            //将当前二维数组中的元素，左，右边界给定义出来。
            int L=intervals[i][0];
            int R=intervals[i][1];
            //如果保存结果的对象为空，则代表是第一次，直接将本次的结果存进去
            //如果取的结果对象里面的上一个结果的右边界小于当前数组的左边界，则代表是个非重叠的区间，将当前数组存到结果中
            if(mergeResult.isEmpty() || mergeResult.get(mergeResult.size()-1)[1]<L){
                mergeResult.add(new int[]{L,R});
            }else{
                //如果取的结果对象里面的上一个结果的右边界大于等于当前数组的左边界，则代表这两个数组有重叠，则更新右边界。使两个数组合并
                mergeResult.get(i-1)[1]=Math.max(mergeResult.get(i-1)[1],R);
            }
        }
        //转换成二维数组返回
        return mergeResult.toArray(new int[mergeResult.size()][]);
    }


    public static void main(String[] args) {
        L56 demo=new L56();
        List<int[]> intervals=new ArrayList<>();
        intervals.add(new int[]{1,3});
        intervals.add(new int[]{2,6});
        intervals.add(new int[]{8,10});
        intervals.add(new int[]{15,18});

        Print.print(demo.merge(intervals.toArray(new int[intervals.size()][])));
    }

}
