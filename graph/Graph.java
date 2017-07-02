package com.imooc.graph;

import java.util.List;

/**
 * Created by Administrator on 2017/7/1.
 */
public interface Graph {
    public void addEdge (int v,int w) throws Exception;
    public boolean hasEdge(int v,int w);
    public int N();
    public int M();
    public List<Integer> getTable(int v);
}
