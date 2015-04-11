package com.Algorithms.Ninja;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTreePreOrderIterator implements Iterator<TreeNode>{
	private static Stack<TreeNode> stack;
	
	//constructor
	public BinaryTreePreOrderIterator(TreeNode root) {
		//can improve performance by using stack of deque type bwcause of constant push pop poll operations. i.e., new ArrayDeque<TreeNode>(); 
		//source: http://n00tc0d3r.blogspot.com/2013/08/implement-iterator-for-binarytree-ii.html
		
		stack = new Stack<TreeNode>();
		if (root!=null) {
			stack.push(root);
		}
	}
	
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public TreeNode next() {
		if(stack.isEmpty()){
			System.out.println("All nodes visited");
			System.exit(0);
		}
		TreeNode current = stack.pop();
		if(current.right!=null){
			stack.push(current.right);
		}
		if(current.left!=null){
			stack.push(current.left);
		}
		return current;
	}
	
	public static void main(String[] args) {
		TreeNode node6 = new TreeNode(null, null,"node6");
		TreeNode node5 = new TreeNode(null, node6,"node5");
		TreeNode node4 = new TreeNode(null, null,"node4");
	    TreeNode node3 = new TreeNode(null, null,"node3");
	    TreeNode node2 = new TreeNode(node4, node5,"node2");
	    TreeNode root = new TreeNode(node2, node3,"node1");
	    BinaryTreePreOrderIterator iterator = new BinaryTreePreOrderIterator(root);
		while (iterator.hasNext()) {
			System.out.println(iterator.next().value);
		}
	}
}