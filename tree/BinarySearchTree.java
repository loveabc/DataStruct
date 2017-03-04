package com.imooc.tree;

/*
 * 二叉搜索树
 */
public class BinarySearchTree {

	// 创建二叉搜索树
	public TreeNode createTree(Integer number) {
		return new TreeNode(number);
	}

	// 添加节点
	//返回值是根节点
	public TreeNode addNode(TreeNode tree, Integer number) {
		if (tree == null || tree.getValue() == null) {
			return new TreeNode(number);
		}
		if (tree.getValue() == number) {
			// 节点值已存在,不添加
			return tree;
		} else if (tree.getValue() > number) {
			TreeNode node = this.addNode(tree.getLeft(), number);
			tree.setLeft(node);
		} else {
			TreeNode node = this.addNode(tree.getRight(), number);
			tree.setRight(node);
		}
		return tree;
	}

	// 查找节点
	public TreeNode queryNode(TreeNode tree, Integer number) {
		if (tree == null || tree.getValue() == null) {
			return null;
		}
		// 尾递归使用循环代替递归
		while (tree != null) {
			if (tree.getValue() == number) {
				return tree;
			}
			if (tree.getValue() > number) {
				tree = tree.getLeft();
			} else {
				tree = tree.getRight();
			}
		}
		return null;
	}

	// 删除节点
	//返回值是根节点
	public TreeNode deleteNode(TreeNode tree, Integer number) {
		if (tree == null || tree.getValue() == null) {
			return null;
		}
		if (tree.getValue() > number) {
			TreeNode node = this.deleteNode(tree.getLeft(), number);
			tree.setLeft(node);
		} else if (tree.getValue() < number) {
			TreeNode node = this.deleteNode(tree.getRight(), number);
			tree.setRight(node);
		} else {
			if (tree.getLeft() != null && tree.getRight() != null) {
				// 删除带有两子树的节点有问题
				TreeNode node = this.getMax(tree.getLeft());
				tree.setValue(node.getValue());
				TreeNode lNode = this.deleteNode(tree.getLeft(), node.getValue());
				tree.setLeft(lNode);
			} else {
				//如果只有左子树,就用左子树代替需要删除的节点
				//如果只有右子树,就用右子树代替需要删除的节点
				//如果是叶子节点,使用左子树或右子树代替需要删除的节点(因为左子树和右子树都是null)
				tree = tree.getRight()==null?tree.getLeft():tree.getRight();
			}
		}
		return tree;
	}

	// 求最大值
	public TreeNode getMax(TreeNode tree) {
		if (tree == null || tree.getValue() == null) {
			return null;
		}
		while (tree.getRight() != null) {
			tree = tree.getRight();
		}
		return tree;
	}

	// 求最小值
	public TreeNode getMin(TreeNode tree) {
		if (tree == null || tree.getValue() == null) {
			return null;
		}
		while (tree.getLeft() != null) {
			tree = tree.getLeft();
		}
		return tree;
	}

	public static void main(String[] args) {
		BinarySearchTree btree = new BinarySearchTree();
		TreeNode tree = btree.createTree(20);
		btree.addNode(tree, 10);
		btree.addNode(tree, 30);
		btree.addNode(tree, 5);
		btree.addNode(tree, 56);
		btree.addNode(tree, 9);
		btree.addNode(tree, 1);
		btree.addNode(tree, 25);
		btree.addNode(tree, 22);
		btree.addNode(tree, 57);
		TreeProcess tp = new TreeProcess();
		tp.inOrder(tree);
		TreeNode node=btree.deleteNode(tree, 20);
		System.out.println(node.getValue());
		tp.inOrder(tree);
	}
}
