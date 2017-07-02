package com.imooc.sort;

import com.imooc.utils.SortUtils;

/**
 * Created by Administrator on 2017/6/10.
 * 选择排序
 * O(n^2)
 */
public class SelectionSort implements Sort{
    @Override
    public void sort(int[] nums) {
        int size=nums.length;
        for(int i=0;i<size;i++){
            int minIndex=i;
            for(int j=i;j<size;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            SortUtils.swap(nums,i,minIndex);
        }
    }

}
