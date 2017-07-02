package com.imooc.uf;

/*
 * 并查集
 */
public class UnionFind {

	//并查集中的元素
	private int[] parents;
	//
	private int[] rank;
	private int count;
	
	public UnionFind(int n){
		parents=new int[n];
		count=n;
		for(int i=0;i<n;i++){
			parents[i]=i;
			rank[i]=1;
		}
	}
	public int find(int p) throws Exception{
		if(p<0||p>=count){
			throw new Exception("下标越界");
		}
		while(p!=parents[p]){
			p=parents[p];
		}
		return p;
	}
	public boolean isConnect(int p,int q) throws Exception{
		return this.find(p)==this.find(q);
	}
	public void union(int p,int q) throws Exception{
		if(this.isConnect(p, q)){
			return;
		}
		int pRoot=this.find(p);
		int qRoot=this.find(q);
		if(rank[pRoot]>rank[qRoot]){
			parents[qRoot]=pRoot;
		}else if(rank[pRoot]<rank[qRoot]){
			parents[pRoot]=qRoot;
		}else{
			parents[pRoot]=qRoot;
			rank[qRoot]=rank[qRoot]+1;
		}
	}
}
