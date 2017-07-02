package com.imooc.sort;

/**
 * Created by Administrator on 2017/6/10.
 * 插入排序
 * O(n^2)
 * 对于插入排序,如果待排序的数据接近有序，那么会很快,如果已有序,则为O(n)
 */
public class InsertionSort implements Sort{
    @Override
    public void sort(int[] nums) {
        int size=nums.length;
        for(int i=1;i<size;i++){
            int e=nums[i];
            int j=0;
            for(j=i-1;j>=0;j--){
                if(nums[j]>e){
                    nums[j+1]=nums[j];
                }else{
                    break;
                }
            }
            nums[j+1]=e;
        }
    }
}
