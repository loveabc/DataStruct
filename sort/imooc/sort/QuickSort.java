package com.imooc.sort;

import com.imooc.utils.SortUtils;

/**
 * Created by Administrator on 2017/6/17.
 */
public class QuickSort implements Sort{


    //计算本次排序的标定值,left,middle,right的中间值
    private int getMiddle(int[] nums,int left,int right){
        int middle=(left+right)/2;
        if(nums[left]>nums[middle]){
            SortUtils.swap(nums,left,middle);
        }
        if(nums[left]>nums[right]){
            SortUtils.swap(nums,left,right);
        }
        if(nums[middle]>nums[right]){
            SortUtils.swap(nums,middle,right);
        }
        return nums[middle];
    }
    private void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int e=this.getMiddle(nums,left,right);
        int i=left+1;
        int j=right;
        for(;;){
            while(nums[i]<e) i++;
            while(nums[j]>e) j--;
            if(i>j){
                break;
            }
            SortUtils.swap(nums,i,j);
            i++;
            j--;
        }
        SortUtils.swap(nums,left,j);
        this.quickSort(nums,left,j);
        this.quickSort(nums,i,right);
    }

    @Override
    public void sort(int[] nums) {
        this.quickSort(nums,0,nums.length-1);
    }
    public static void main(String[] args){
        int[] nums={10,2,1,9,0,9,8,0,9,8,7,6,4,32,56,54};
        new QuickSort().sort(nums);
        for(int num:nums)
            System.out.print(num+" ");
    }
}
