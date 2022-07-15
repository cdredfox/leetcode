/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * @author fei.yang
 * @date 2022/7/15 - 11:19
 */
public class L34 {

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 用二分法，分别找到左右节点，返回即可
     * 但为了解决要找的元素在数组的左右两侧外的情况，所以要设置ans的初始值
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
          //取左边的下标
          int left=getLeft(nums,target);
          //取右边的下标
          int right=getRight(nums,target);
          //如果这两个下标没有找到，则代表没出现过，返回 -1，-1
          if(left==-2 || right==-2){
              return new int[]{-1,-1};
          }
          //如果有区间，则返回区间值，左右指针都移出去了，所以需要分别+1，-1
          if(right-left>1){
              return new int[]{left+1,right-1};
          }
          //其它情况，返回-1，-1
           return new int[]{-1,-1};
    }

    /**
     * 取右边界的位置
     * @param nums
     * @param target
     * @return
     */
    public int getRight(int[] nums,int target){
        int l=0,r=nums.length-1;
        int ans=-2;
        while(l<=r){
            int mid=l+(r-l)/2;
            //当target值<mid值时，代表符合的值在左区间，所以这时候r移动
            if(nums[mid]>target){
                r=mid-1;
            }else{
                //target大于等于mid的时候，代表值在右区间，所以移动l
                //我们要取右边界，因为有=在里面，所以让l一至移动到不等于target的值提候，就代表到了右边界。左指针移到头就代表右边界
                l=mid+1;
                ans=l;
            }
        }
        return ans;
    }

    /**
     * 取左边界的位置
     * @param nums
     * @param target
     * @return
     */
    public int getLeft(int[] nums,int target){
        int l=0,r=nums.length-1;
        int ans=-2;
        while(l<=r){
            int mid=l+(r-l)/2;
            //如果target>mid则代表目标值在右边，所以移动左节点，又因为我们要取的是左指针移到底后，就代表右边界，所以在判断右边的时候，不能用=
            if(nums[mid]<target){
                l=mid+1;
            }else{
                //如果target<=mid,则代表目标值在左边，所以移动右节点，因为这边有等值，所以会一至移动到出等的边界，这样右指针移到头的时候，就是左边界，往前走了一位。
                r=mid-1;
                ans=r;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        L34 demo=new L34();
        Print.print(demo.searchRange(new int[]{5,7,7,8,8,10},8));
    }
}
