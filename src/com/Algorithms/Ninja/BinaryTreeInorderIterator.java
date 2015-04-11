package com.Algorithms.Ninja;

import java.util.Iterator;
import java.util.Stack;

class TreeNode_1 {
	  TreeNode_1 left, right;
	  String value = "";
	  
	  public TreeNode_1(TreeNode_1 left, TreeNode_1 right, String value) {
	    this.left = left;
	    this.right = right;
	    this.value = value;
	  }
	  
	  public TreeNode_1 getLeft() { return this.left; }
	  public TreeNode_1 getRight() { return this.right; }
	}

public class BinaryTreeInorderIterator implements Iterator<TreeNode_1>{
	private static Stack<TreeNode_1> stack;
	
	//constructor
	public BinaryTreeInorderIterator(TreeNode_1 root) {
		stack = new Stack<TreeNode_1>();
		pushNode(root);
	}
	private void pushNode(TreeNode_1 node) {
		while (node!=null) {
			stack.push(node);
			node = node.left;
		}
	}
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public TreeNode_1 next() {
		if(stack.isEmpty()){
			System.out.println("All nodes visited");
			System.exit(0);
		}
		TreeNode_1 current = stack.pop();
		pushNode(current.right);
		return current;
	}
	
	public static void main(String[] args) {
		TreeNode_1 node6 = new TreeNode_1(null, null,"node6");
		TreeNode_1 node5 = new TreeNode_1(null, node6,"node5");
	    TreeNode_1 node4 = new TreeNode_1(null, null,"node4");
	    TreeNode_1 node3 = new TreeNode_1(null, null,"node3");
	    TreeNode_1 node2 = new TreeNode_1(node4, node5,"node2");
	    TreeNode_1 root = new TreeNode_1(node2, node3,"node1");
	    BinaryTreeInorderIterator iterator = new BinaryTreeInorderIterator(root);
		while (iterator.hasNext()) {
			System.out.println(iterator.next().value);
		}
	}
}
