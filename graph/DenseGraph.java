package com.imooc.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/1.
 * 邻接矩阵实现稠密图
 */
public class DenseGraph implements Graph{
    private int n;//顶点个数
    private int m;//边个数
    private boolean directed;//是否有向图
    private boolean[][] graph;//

    public DenseGraph(int n,boolean directed){
        this.n=n;
        this.m=0;
        this.directed=directed;
        graph=new boolean[n][n];
    }

    //添加一条边
    public void addEdge(int v,int w) throws Exception{
        if(v>=n||w>=n){
            throw new Exception("下标越界");
        }
        if(this.hasEdge(v,w)){
            return;
        }
        graph[v][w]=true;
        if(!this.directed){
            graph[w][v]=true;
        }
        this.m++;

    }
    //判断是否已经有边
    public boolean hasEdge(int v,int w){
        return graph[v][w];
    }
    //顶点的个数
    public int N(){
        return this.n;
    }
    //边的个数
    public int M(){
        return this.m;
    }
    //获取指定节点的所有邻接点
    public List<Integer> getTable(int v){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=v&&graph[v][i]){
                list.add(i);
            }
        }
        return list;
    }

}
