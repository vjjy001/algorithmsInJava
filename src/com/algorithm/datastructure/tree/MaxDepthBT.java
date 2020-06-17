package com.algorithm.datastructure.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MaxDepthBT {

	/*
	 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
	 */	
	
    public int maxDepth(TreeNode root) {
        
    	// using dfs iterative
    	int maxDepth = Integer.MIN_VALUE;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Set<TreeNode> visitedNode = new HashSet<>();
    	
    	if(root == null) return 0;
    	if(root != null) {
    		stack.push(root);	
    		
    		while(stack.size() >0 ) {
    			
    			if(maxDepth < stack.size()) {
    				maxDepth = stack.size();
    			}
    			
    			TreeNode node = stack.peek();
    			
    			// find the first node and add to the stack
    			visitedNode.add(node);
    			// if the child has node keep adding to stack
    			if(node.left != null && !visitedNode.contains(node.left)) {
    				stack.push(node.left);
    				continue;
    			}else if(node.right != null && !visitedNode.contains(node.right)) {
    				stack.push(node.right);
    				continue;
    			}
    			
    			// only pop if not any child
    			stack.pop();
    			    			
    		}
    	
    	}
    	
    	return maxDepth;
    }
	
    public int maxDepthR(TreeNode root) {
    	
    	if(root == null) return 0;
    	
    	int leftSubDepth = maxDepthR(root.left)+1;
    	int rightSubDepth = maxDepthR(root.right)+1;
    	
    	return Math.max(leftSubDepth, rightSubDepth);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDepthBT t = new MaxDepthBT();
		
			/**
			 * 				3
			 * 			9      20
			 *                15  7  
			 */
			TreeNode tree = new TreeNode(3);
	        tree.left = new TreeNode(9); 
	        tree.right = new TreeNode(20); 
	        tree.left.left = null; 
	        tree.left.right = null; 
	        tree.right.left = new TreeNode(15); 
	        tree.right.right = new TreeNode(7);
	        // iterative
	        //System.out.println(String.format("iterative %d", t.maxDepth(tree)));
	        // recurisive
	        System.out.println(String.format("recursive %d", t.maxDepthR(tree)));

	}

}
