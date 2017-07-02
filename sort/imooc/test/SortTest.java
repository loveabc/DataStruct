package com.imooc.test;

import com.imooc.sort.BubbleSort;
import com.imooc.sort.InsertionSort;
import com.imooc.sort.SelectionSort;
import com.imooc.sort.Sort;
import com.imooc.utils.SortUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/10.
 * 测试排序
 */
public class SortTest {
    public static void main(String[] args){
        int n=100000;
        int[] nums=SortUtils.generateArray(n,1,n);
        nums=SortUtils.generateSortedArray(n,1000);
        int[] nums2= Arrays.copyOf(nums,n);
        int[] nums3=Arrays.copyOf(nums,n);
        Sort sort=null;
        sort=new SelectionSort();
        SortUtils.testSort(sort,nums2);
        sort=new InsertionSort();
        SortUtils.testSort(sort,nums3);
        sort=new BubbleSort();
        SortUtils.testSort(sort,nums);
    }
}
