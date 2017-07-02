package com.imooc.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2017/7/1.
 * 图路径处理
 */
public class GraphPath {
    private int source;//源头
    private int[] from;//from[1]=2  从节点1进入节点2
    private Graph graph;
    private boolean[] visited;//是否被访问过

    public GraphPath(Graph graph, int source){
        this.graph=graph;
        from=new int[graph.N()];
        visited=new boolean[graph.N()];
        from[source]=-1;
        this.def(source);
    }

    private void def(int v){
        visited[v]=true;
        List allPoints=graph.getTable(v);
        for(int i=0;i<allPoints.size();i++){
            int index=(int)allPoints.get(i);
            if(!visited[index]){
                from[index]=v;
                this.def(index);
            }
        }
    }

    public boolean hasPath(int v){
        return visited[v];
    }

    public void addPath(int v,List path){
        Stack stack=new Stack();
        int w=v;
        while(from[w]!=-1){
            stack.push(w);
            w=from[w];
        }
        stack.push(w);
        while(!stack.isEmpty()){
            path.add(stack.pop());
        }
    }
    public void showPath(int v){
        if(!this.hasPath(v)){
            return;
        }
        List<Integer> path=new ArrayList<>();
        this.addPath(v,path);
        int size=path.size();
        for(int i=0;i<size;i++){
            if(i==size-1){
                System.out.print(path.get(i));
            }else{
                System.out.print(path.get(i)+"-->");
            }
        }
    }
}
