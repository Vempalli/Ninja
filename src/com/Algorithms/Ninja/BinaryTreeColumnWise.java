package com.Algorithms.Ninja;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;


class TreeNode {
	  TreeNode left, right;
	  String value = "";
	  
	  public TreeNode(TreeNode left, TreeNode right, String value) {
	    this.left = left;
	    this.right = right;
	    this.value = value;
	  }
	  
	  public TreeNode getLeft() { return this.left; }
	  public TreeNode getRight() { return this.right; }
	}

public class BinaryTreeColumnWise {
	
	public static void main(String[] args) {
		TreeNode node6 = new TreeNode(null, null,"node6");
	    TreeNode node5 = new TreeNode(null, node6,"node5");
	    TreeNode node4 = new TreeNode(null, null,"node4");
	    TreeNode node3 = new TreeNode(null, null,"node3");
	    TreeNode node2 = new TreeNode(node4, node5,"node2");
	    TreeNode root = new TreeNode(node2, node3,"node1");
	    traverseColumnWise(root);
	}
	
	//For traversing use level order traversal first
	private static void traverseColumnWise(TreeNode root) {
		//store level by level nodes
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// levelnum as key list of nodes in that level as value
		Map<Integer,LinkedList<TreeNode>> columnMap = new HashMap<Integer,LinkedList<TreeNode>>();
		Map<TreeNode,Integer> positionMap = new HashMap<TreeNode,Integer>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			//poll retrieves and removes
			TreeNode temp = queue.poll();
			//first time add root node
			if(columnMap.isEmpty()){
				LinkedList<TreeNode> list = new LinkedList<TreeNode>();
				list.add(temp);
				columnMap.put(0, list);
				positionMap.put(temp,0);
			}
			int column = positionMap.get(temp);
			if(temp.left != null){
				queue.add(temp.left);
				if(columnMap.containsKey(column-1)){
					LinkedList<TreeNode> list = columnMap.get(column-1);
					list.add(temp.left);
				}
				else{
					LinkedList<TreeNode> list = new LinkedList<TreeNode>();
					list.add(temp.left);
					columnMap.put(column-1, list);
				}
				positionMap.put(temp.left, column-1);
			}
			
			if(temp.right != null){
				queue.add(temp.right);
				if(columnMap.containsKey(column+1)){
					LinkedList<TreeNode> list = columnMap.get(column+1);
					list.add(temp.right);
				}
				else{
					LinkedList<TreeNode> list = new LinkedList<TreeNode>();
					list.add(temp.right);
					columnMap.put(column+1, list);
				}
				positionMap.put(temp.right, column+1);
			}
			
		}
		
		//Iterate map
		
		for (Entry<Integer, LinkedList<TreeNode>> entry: columnMap.entrySet()) {
	        System.out.println("Column - " + entry.getKey() + " : ");
	        LinkedList<TreeNode> list = entry.getValue();
	        for(int i = 0; i < list.size(); i++){
	        	System.out.println(list.get(i).value);
	        }
	    }
		
	}

}
