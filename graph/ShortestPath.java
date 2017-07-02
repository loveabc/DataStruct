package com.imooc.graph;

import java.util.*;

/**
 * Created by Administrator on 2017/7/2.
 * 广度优先遍历寻找最短路径
 */
public class ShortestPath {

    private Graph graph;//要处理的图
    private int source;//源点
    private int[] from;//
    private boolean[] vistied;
    private int[] minLen;//最短路径
    private Queue queue;

    public ShortestPath(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        queue = new LinkedList();
        from = new int[graph.N()];
        vistied = new boolean[graph.N()];
        minLen = new int[graph.N()];
        this.bfs(source);
    }

    private void bfs(int v) {
        queue.offer(v);
        vistied[v] = true;
        from[v] = -1;
        minLen[v] = 0;
        while (!queue.isEmpty()) {
            int w = (int) queue.poll();
            List<Integer> points = graph.getTable(w);
            for (int point : points) {
                if (!vistied[point]) {
                    queue.offer(point);
                    vistied[point] = true;
                    from[point] = w;
                    minLen[point] = minLen[w] + 1;
                }
            }
        }
    }

    public boolean hasPath(int w) {
        return vistied[w];
    }

    public void addPath(int v, List path) {
        Stack stack = new Stack();
        int w = v;
        while (from[w] != -1) {
            stack.push(w);
            w = from[w];
        }
        stack.push(w);
        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }
    }

    public void showPath(int v) {
        if (!this.hasPath(v)) {
            return;
        }
        List<Integer> path = new ArrayList<>();
        this.addPath(v, path);
        int size = path.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(path.get(i));
            } else {
                System.out.print(path.get(i) + "-->");
            }
        }
    }

    public int minPath(int w){
        return minLen[w];
    }
}
