package com.imooc.utils;

import com.imooc.sort.Sort;

import java.util.Random;

/**
 * Created by Administrator on 2017/6/10.
 * 排序算法工具类
 */
public class SortUtils {
    //交换元素
    public static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    //生成元素位于[lowNum,highNum]之间的个数为n的随机数组
    public static int[] generateArray(int n,int lowNum,int higNum){
        Random random=new Random();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=random.nextInt(higNum-lowNum)+lowNum;
        }
        return nums;
    }
    //生成一个近乎有序的数组
    public static int[] generateSortedArray(int n,int swapTime){
        Random random=new Random();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i;
        }
        for(int i=0;i<swapTime;i++){
            int posx=random.nextInt(n);
            int posy=random.nextInt(n);
            SortUtils.swap(nums,posx,posy);
        }
        return nums;
    }
    //判断数组是否有序
    public static boolean isSorted(int[] nums){
        int size=nums.length;
        for(int i=0;i<size-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void testSort(Sort sort, int[] nums){
        System.out.print("排序方式为:"+sort.getClass().getSimpleName());
        long startTime=System.currentTimeMillis();
        sort.sort(nums);
        long endTime=System.currentTimeMillis();
        if(!SortUtils.isSorted(nums)){
            System.out.print(" 排序方法有误.");
        }

        System.out.println("    排序耗时:"+(endTime-startTime)+"ms");
        for(int i=0;i<100;i++){
            System.out.print(nums[i]+" ");
        }
    }

}
