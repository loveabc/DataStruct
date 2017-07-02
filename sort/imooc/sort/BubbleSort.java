package com.imooc.sort;

import com.imooc.utils.SortUtils;

/**
 * Created by Administrator on 2017/6/10.
 * 冒泡排序
 * O(n^2)
 * 对于冒泡排序,如果第i次排序之后已经有序,那么第(i+1)排序之后会直接退出,

 */
public class BubbleSort implements Sort{
    @Override
    public void sort(int[] nums) {
        int size=nums.length;
        for(int i=0;i<size-1;i++){
            boolean flag=false;
            for(int j=0;j<size-i-1;j++){
                if(nums[j]>nums[j+1]){
                    SortUtils.swap(nums,j+1,j);
                    flag=true;
                }
            }
            if(!flag){
                return;
            }
        }
    }
}
