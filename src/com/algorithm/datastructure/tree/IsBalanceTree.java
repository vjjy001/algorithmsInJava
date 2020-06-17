package com.algorithm.datastructure.tree;

public class IsBalanceTree {

	/*
	 * https://leetcode.com/problems/balanced-binary-tree/
	 */	
	
	
	 public boolean isBalanced(TreeNode root) {	     
		
		 boolean isBalance = true;
		 
		 if( root != null) {
			 int subLeftHeight = getHeight(root.left);
			 int subRightHeight = getHeight(root.right);
			 
			 if(Math.abs(subLeftHeight - subRightHeight) >1 ) {
				 isBalance=false;
			 }
			 else {
				 isBalance = isBalanced(root.left) && isBalanced(root.right);
			 }
		 }
		 
		 return isBalance;

	 }
	
	 public int getHeight(TreeNode node) {
		 
		 if(node == null) return 0;		 
		 // height from sub left
		 int subLeft = getHeight(node.left)+1;
		 int subRight = getHeight(node.right)+1;
		 
		 return Math.max(subLeft, subRight);

	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsBalanceTree t = new IsBalanceTree();
		
		/**
		 * 				3
		 * 			9      20
		 *                15  7
		 *                		50  
		 */						
		TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9); 
        tree.right = new TreeNode(20); 
        tree.left.left = null; 
        tree.left.right = null; 
        tree.right.left = new TreeNode(15); 
        tree.right.right = new TreeNode(7);
        tree.right.left.left = null;
        tree.right.left.right = null;
        tree.right.right.left= null;
        tree.right.right.right = new TreeNode(50);
        tree.right.right.right.right = null;
        tree.right.right.right.left = null;

        //tree.right.right.right.right = new TreeNode(52);
		
		boolean result = t.isBalanced(tree);
		System.out.println(result);
	}

}
