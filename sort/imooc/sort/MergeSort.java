package com.imooc.sort;

/**
 * Created by Administrator on 2017/6/11.
 */
public class MergeSort implements Sort{


    //middle=4
    private void merge(int[] nums,int middleIndex,int startIndex,int endIndex) {
        int[] newnums=new int[endIndex-startIndex+1];
        for(int i=startIndex;i<=endIndex;i++){
            newnums[i-startIndex]=nums[i];
        }
        int left=0;
        int middle=middleIndex-startIndex;
        int right=middle+1;
        int pos=startIndex;
        while(left<=middle&&right<=newnums.length-1){
            if(newnums[left]<newnums[right]){
                nums[pos++]=newnums[left++];
            }else{
                nums[pos++]=newnums[right++];
            }
        }
        if(left<=middle){
            for(int i=left;i<=middle;i++){
                nums[pos++]=newnums[i];
            }
        }else{
            for(int i=right;i<=newnums.length-1;i++){
                nums[pos++]=newnums[i];
            }
        }
    }
    private void mergeSort(int[] nums,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int middle=(startIndex+endIndex)/2;
        this.mergeSort(nums,startIndex,middle);
        this.mergeSort(nums,middle+1,endIndex);
        this.merge(nums,middle,startIndex,endIndex);
    }

    @Override
    public void sort(int[] nums) {
        this.mergeSort(nums,0,nums.length-1);
    }
    public static void main(String[] args){
        int[] nums={10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,7};
        new MergeSort().sort(nums);
        for(int num:nums){
            System.out.print(num+" ");
        }
    }
}
