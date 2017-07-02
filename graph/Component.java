package com.imooc.graph;

import java.util.List;

/**
 * Created by Administrator on 2017/7/1.
 * 图的相关操作(遍历,联通分量个数,判断两个点是否连接)
 */
public class Component {

    private Graph graph;//要操作的图
    private boolean[] visited;//是否被访问过
    private int ccount;//联通分量的个数
    private int[] parents;//图中的节点输入哪个联通分量

    public Component(Graph graph){
        this.graph=graph;
        visited=new boolean[graph.N()];
        parents=new int[graph.N()];
    }


    //邻接表深度优先遍历
    public void dfs(){
        for(int i=0;i<graph.N();i++){
            if(!visited[i]){
                ccount++;
                this.def(i);
            }

        }
    }
    private void def(int v){
        visited[v]=true;
        System.out.println(v);
        parents[v]=ccount;
        List allPoints=graph.getTable(v);
        for(int i=0;i<allPoints.size();i++){
            int index=(int)allPoints.get(i);
            if(!visited[index]){
                this.def(index);
            }
        }
    }

    public int getConmentCount(){
        return ccount;
    }

    public boolean isConnect(int v,int w){
        //需要验证下标越界
        return parents[v]==parents[w];
    }
}
