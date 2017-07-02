package com.imooc.heap;

import com.imooc.utils.SortUtils;

/**
 * Created by Administrator on 2017/6/18.
 * 最大堆
 *
 */
public class MaxHeap{

    //堆容量
    private int capacity;
    //堆中元素的数量
    private int count;
    private int[] elements;
    //
    public MaxHeap(){
    	
    }
    //根据元素数量初始化空堆
    public MaxHeap(int capacity){
        this.elements=new int[capacity];
        this.capacity=capacity;
        this.count=0;
    }
    //根据给定的元素初始化最大堆
    public MaxHeap(int[] nums){
    	this.adjustHeap(nums);
    }

    //获取堆中元素的数量
    public int size(){
        return this.count;
    }
    //判断堆是否满
    public boolean isFull(){
        return this.count==this.capacity;
    }
    //判断堆是否空
    public boolean isEmpty(){
        return this.count==0;
    }
    //添加元素
    public void add(int element) throws Exception{
        if(this.isFull()){
            throw new Exception("堆已满,不能添加新元素");
        }
        this.elements[this.count]=element;
        shiftUp(this.count);
        this.count++;
    }
    //移除元素
    public int remove() throws Exception{
        if(this.isEmpty()){
            throw new Exception("堆为空,不能移除元素");
        }
        int ret=this.elements[0];
        this.count--;
        this.elements[0]=this.elements[this.count];
        shiftDown(0);
        return ret;
    }
    //堆排序(原地排序)
    public void heapSort(int[] nums) throws Exception{
    	this.adjustHeap(nums);
    	for(;!this.isEmpty();){
    		nums[this.count-1]=this.remove();
    	}
    }
    //将数组调整为最大堆
    private void adjustHeap(int[] nums){
    	this.capacity=nums.length;
    	this.count=nums.length;
    	this.elements=nums;
    	//调整为最大堆
    	for(int i=this.count-1;i>=0;i--){
    		this.shiftDown(i);
    	}
    }
    //添加元素之后调整为最大堆
    private void shiftUp(int index){
        int e=this.elements[index];
        while(index>0&&this.elements[(index-1)/2]<e){
            this.elements[index]=this.elements[(index-1)/2];
            index=(index-1)/2;
        }
        this.elements[index]=e;
    }
    //移除元素之后调整为最大堆
    private void shiftDown(int index){
        int e=this.elements[index];
        while(2*index+1<=this.count-1){
            int init=2*index+1;
            if(2*index+2<=this.count-1&&this.elements[2*index+1]<this.elements[2*index+2]){
                init=2*index+2;
            }
            if(this.elements[init]<e){
            	break;
            }
            this.elements[index]=this.elements[init];
            index=init;
        }
        this.elements[index]=e;
    }
    public static void main(String[] args) throws Exception{
        int n=100;
        int[] nums=SortUtils.generateArray(n,0,n);
        MaxHeap heap=new MaxHeap();
        for(int num:nums){
     	   System.out.print(num+" ");
        }
        System.out.println();
        heap.heapSort(nums);
        for(int num:nums){
        	System.out.print(num+" ");
        }
//        System.out.println();
//        while(!heap.isEmpty()){
//        	System.out.print(heap.remove()+" ");
//        }
//    	int[] nums={7,6,7,0,3,1,3};
//    	MaxHeap heap=new MaxHeap(nums.length);
//    	heap.count=nums.length;
//    	heap.elements=nums;
//    	System.out.println(heap.remove());
//    	for(int i=0;i<heap.count;i++){
//          System.out.print(heap.elements[i]+" ");
//      }
    	
    }
}
