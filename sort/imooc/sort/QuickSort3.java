package com.imooc.sort;

import com.imooc.utils.SortUtils;

/*
 * 三路快速排序
 */
public class QuickSort3 implements Sort {

	@Override
	public void sort(int[] nums) {
		this.quickSort(nums, 0, nums.length-1);
		
	}
	
	private void quickSort(int[] nums,int left,int right){
		if(left>=right){
			return;
		}
		int mid=this.getMiddle(nums, left, right);
		int lt=left-1;
		int gt=right+1;
		int i=left;
		while(i<gt){
			if(nums[i]>mid){
				SortUtils.swap(nums, i, gt-1);
				gt--;
			}else if(nums[i]<mid){
				SortUtils.swap(nums, i, lt+1);
				lt++;
				i++;
			}else{
				i++;
			}
		}
		
		this.quickSort(nums, left, lt);
		this.quickSort(nums, i, right);
	}
	
	private int getMiddle(int[] nums,int left,int right){
		int mid=(left+right)/2;
		if(nums[mid]<nums[left]){
			SortUtils.swap(nums, mid, left);
		}
		if(nums[right]<nums[left]){
			SortUtils.swap(nums, left, right);
		}
		if(nums[right]<nums[mid]){
			SortUtils.swap(nums, right, mid);
		}
		
		return nums[mid];
	}

}
