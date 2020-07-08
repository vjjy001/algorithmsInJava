package com.algorithm.datastructure.tree;

public class SearchBST {

	/*
	 * https://leetcode.com/problems/search-in-a-binary-search-tree/
	 */	
	
    public TreeNode searchBST(TreeNode root, int val) {
      
    	if(root == null) return root;
    	
    	// pre order search
    	TreeNode node = null;
    	if(val < root.val) {
    		node = searchBST(root.left, val);
    	}else if(val > root.val) {
    		node = searchBST(root.right,val);
    	}else {
    		node = root;
    	}
    	return node;
    	
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
