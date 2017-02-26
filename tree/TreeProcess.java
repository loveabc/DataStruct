package com.imooc.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 二叉树的操作
 */
public class TreeProcess {

	// 创建二叉树
	public void createTree() {
		TreeNode node1 = new TreeNode("1");
		TreeNode node2 = new TreeNode("2");
		TreeNode node3 = new TreeNode("3");
		TreeNode node4 = new TreeNode("4");
		TreeNode node5 = new TreeNode("5");
		TreeNode node6 = new TreeNode("6");
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setRight(node4);
		node3.setLeft(node5);
		node3.setRight(node6);
		/*
		 * 				1
		 * 		2				3
		 * 			4		5		6
		 */
		
		this.firstOrder(node1);
		System.out.println();
		this.inOrder(node1);
		System.out.println();
		this.afterOrder(node1);
		System.out.println();
		this.ListOrder(node1);
	}

	// 先序遍历
	//1  2  4  3  5  6  
	public void firstOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getValue()+"  ");
		this.firstOrder(node.getLeft());
		this.firstOrder(node.getRight());
	}

	// 中序遍历
	//2  4  1  5  3  6 
	public void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		this.inOrder(node.getLeft());
		System.out.print(node.getValue()+"  ");
		this.inOrder(node.getRight());
	}

	// 后序遍历
	//4  2  5  6  3  1
	public void afterOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		this.afterOrder(node.getLeft());
		this.afterOrder(node.getRight());
		System.out.print(node.getValue()+"  ");
	}
	//层序遍历
	public void ListOrder(TreeNode node){
		if(node==null){
			return;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			TreeNode currentNode=queue.poll();
			TreeNode leftNode=currentNode.getLeft();
			TreeNode rightNode=currentNode.getRight();
			if(leftNode!=null){
				queue.add(leftNode);
			}
			if(rightNode!=null){
				queue.add(rightNode);
			}
			System.out.print(currentNode.getValue()+"  ");
		}
	}
	public static void main(String[] args) {
		TreeProcess tree=new TreeProcess();
		tree.createTree();
//		Queue<String> queue=new LinkedList<String>();
//		System.out.println(queue.isEmpty());
//		queue.add("1");
//		queue.add("2");
//		queue.add("3");
//		int size=queue.size();
//		for(int i=0;i<size;i++){
//			System.out.println(queue.poll());
//		}
//		Stack<String> stack=new Stack<String>();
//		stack.add("1");
//		stack.add("2");
//		stack.add("3");
//		size=stack.size();
//		for(int i=0;i<size;i++){
//			System.out.println(stack.pop());
//		}
	}
}
