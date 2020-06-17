package com.algorithm.datastructure.tree;

public class ValidateBST {

	/*
	 * https://leetcode.com/problems/validate-binary-search-tree/
	 */	
	
	 public boolean isValidBST(TreeNode root) {
	 
		 
		 return isBST(root); 
		 
		 
	 }
	
	public boolean isBST(TreeNode root) {
		
		boolean isBstl=true,isBstr=true;
		
		if(root == null) return true;
		
			if( root.left != null && root.left.val <root.val
					|| root.left == null && root.right == null
					|| root.left == null && root.right != null) {
				isBstl = isBST(root.left) ;
			}else {
				return false;
			}
			
			if(root.right != null && root.right.val >root.val 
					|| root.right == null && root.right == null
					|| root.left != null && root.right == null) {
				isBstr = isBST(root.right);
			}else {
				return false;
			}
			
			return isBstl&&isBstr;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		TreeNode root = new TreeNode(20); 
//	      root.left = new TreeNode(10); 
//	      root.right = new TreeNode(30); 
//	      root.left.left = new TreeNode(5); 
//	      root.left.right = new TreeNode(13); 
//	      root.right.left = new TreeNode(27); 
//	      root.right.right = new TreeNode(50);

//		TreeNode root = new TreeNode(20); 
//	      root.left = new TreeNode(30); 
//	      root.right = new TreeNode(29); 
//	      root.left.left = new TreeNode(5); 
//	      root.left.right = new TreeNode(13); 
//	      root.right.left = new TreeNode(27); 
//	      root.right.right = new TreeNode(50);

//		  TreeNode root = new TreeNode(5);
//	      root.left = new TreeNode(1); 
//	      root.right = new TreeNode(4); 
//	      root.left.left = null; 
//	      root.left.right = null; 
//	      root.right.left = new TreeNode(3); 
//	      root.right.right = new TreeNode(6);
		
		  TreeNode root = new TreeNode(0);
	      root.left = null; 
	      root.right = new TreeNode(1); 

	      ValidateBST b = new ValidateBST();
	      boolean validate = b.isValidBST(root);
	      System.out.println(validate);
	}

}
