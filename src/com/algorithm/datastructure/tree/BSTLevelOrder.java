package com.algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTLevelOrder {

	//https://leetcode.com/problems/binary-tree-level-order-traversal/
	
	// iterative by using queue to bst
	// 2^n+1 -1 = N
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        
//    	List<Integer> singleList =new ArrayList<>();
//    	Queue<TreeNode> queue = new LinkedList<>();
//    	
//    	if(root == null ) return null;
//    	
//    	queue.add(root);
//    	// loop the queue
//    	int n =1;
//    	List<List<Integer>> result = new ArrayList<>();
//    	while(!queue.isEmpty()) {
//    		
//    		TreeNode node = queue.poll();
//    		singleList.add(node.val);
//	    	double height = Math.log(n +  
//	    			1) / Math.log(2) - 1;
//	    	if(height %1 == 0) {
//	    	
//	    		result.add(singleList);
//	    		singleList = new ArrayList<>();
//
//	    	}
//	    	
//    		if(node.left != null) {
//    			queue.add(node.left);
//    			n++;
//    		}
//    		    		
//    		if(node.right != null) {
//    			queue.add(node.right);
//    			n++;
//    		}
//    		
//    		
//
//    	}
//    	    	
//    	return result;
//    }
	
	public List<List<Integer>> levelOrder(TreeNode root) {
    	
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
    	
    	if(root == null ) return result;
    	
    	queue.add(root);
    	
    	// each iteration is next level
    	while(!queue.isEmpty()) {
    		int levelTotoalNodeSize = queue.size();
    		List<Integer> levelList = new ArrayList<>();
    		// loop all the nodes in current level
    		for(int i=0;i<levelTotoalNodeSize;i++){
    			TreeNode node = queue.poll();
    			// add all the current level nodes to levelList
    			levelList.add(node.val);
    			
    			// insert the all the next level nodes into queue
    			if(node.left != null) queue.add(node.left);
    			
    			if(node.right != null) queue.add(node.right);
    			    			
    		}
    			
    		result.add(levelList);
    	}
    	
    	
    	return result;
    }
	
	// recursive way
	public List<List<Integer>> levelOrderR(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<>();
		levelOrderHelper(result,root,0);		
		return result;
		
	}

	private void levelOrderHelper(List<List<Integer>> result, TreeNode node, int level) {
		
		// using preorder to traversal tree and using height to add the
		// same level nodes back to the list
		if(node == null) return;
		// create new level list when height is greater than result size
		if(level >= result.size()) {
			List<Integer> levelList = new ArrayList<>();
			result.add(levelList);
		}
		// get current level list and add the node 
		result.get(level).add(node.val);
		
		levelOrderHelper(result,node.left,level+1);
		levelOrderHelper(result,node.right,level+1);		
	}
	
	
	
    // solution
    // using queue 
    // https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/33450/Java-solution-with-a-queue-used
    
    // solution
    // recursive
    // https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/33445/Java-Solution-using-DFS
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTLevelOrder b = new BSTLevelOrder();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.left.left = new TreeNode(30);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		root.right.right.right = new TreeNode(71);
		//List<List<Integer>> r = b.levelOrder(root);
		List<List<Integer>> r = b.levelOrderR(root);
		r.forEach(list -> {
				
				list.forEach(System.out::print);
				System.out.println();
			});
	}

}
