package com.Algorithms.Ninja;

import java.util.Iterator;
import java.util.Stack;

//source: http://n00tc0d3r.blogspot.com/2013/08/implement-iterator-for-binarytree-iii.html
public class BinaryTreePostOrderIterator implements Iterator<TreeNode>{
	private static Stack<TreeNode> stack = new Stack<TreeNode>();
	
	//constructor
	public BinaryTreePostOrderIterator(TreeNode root) {
		findLeaf(root);
	}
	
	private void findLeaf(TreeNode node) {
		while(node!=null){
			stack.push(node);
			if(node.left!=null){
				node = node.left;
			}
			else{
				node = node.right;
			}
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
		if(!stack.isEmpty()){
			TreeNode top = stack.peek();
			if(current==top.left){
				findLeaf(top.right);
			}
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
	    BinaryTreePostOrderIterator iterator = new BinaryTreePostOrderIterator(root);
		while (iterator.hasNext()) {
			System.out.println(iterator.next().value);
		}
	}
}
