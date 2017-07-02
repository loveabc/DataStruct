package com.imooc.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/1.
 * 邻接表实现稀疏图
 */
public class SparseGraph implements Graph{
    private int n;
    private int m;
    private boolean directed;
    private List[] graph;

    public SparseGraph(int n,boolean directed){
        this.n=n;
        this.m=0;
        this.directed=directed;
        graph=new List[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Integer>();
        }
    }
    public void addEdge(int v,int w) throws Exception{
        if(v>=n||w>=n){
            throw new Exception("下标越界");
        }
        if(this.hasEdge(v,w)){
            return;
        }
        graph[v].add(w);
        if(!directed){
            graph[w].add(v);
        }
        this.m++;
    }
    //判断是否已经有边
    public boolean hasEdge(int v,int w){
        int size=graph[v].size();
        for(int i=0;i<size;i++){
            if((int)graph[v].get(i)==w){
                return true;
            }
        }
        return false;
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
        return this.graph[v];
    }
}
