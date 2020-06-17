package com.algorithm.datastructure.tree;

public class SortedArrayToBST {

	/*
	 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	 */	
	
	// approach one (my solution)
    public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = null;		
 
    	if(nums.length>0) {
    		root = getValFromArray(nums, 0, nums.length, root );    	
    	}
    	
    	return root;
    }
	
    public TreeNode getValFromArray(int[] nums, int start, int end, TreeNode root) {
    	
    	if(start >= end) return root;
    	
    	int midPos = (start+end)/2;
    	
    	root = insertNode(root, nums[midPos]);
    	    	
    	getValFromArray(nums,start,midPos,root);
    	
    	getValFromArray(nums,midPos+1, end,root);
    	
    	return root;
    	
    }
    
    private TreeNode insertNode(TreeNode currentParent, int val) {

        if (currentParent == null) {
            return new TreeNode(val);
        } else if (val> currentParent.val) {
            currentParent.right = insertNode(currentParent.right, val);
        } else if (val < currentParent.val) {
            currentParent.left = insertNode(currentParent.left, val);
        }

        return currentParent;
    }
    
	/*
	 * public void insertNode(TreeNode node, int val) {
	 * 
	 * if (val < node.val) { if (node.left != null) { insertNode(node.left, val); }
	 * else { node.left = new TreeNode(val); } } else if (val > node.val) { if
	 * (node.right != null) { insertNode(node.right, val); } else { node.right = new
	 * TreeNode(val); } } }
	 */
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedArrayToBST s = new SortedArrayToBST();
		int[] nums = new int[] {-10,-3,0,5,9};
		TreeNode node = s.sortedArrayToBST(nums);
		System.out.println(node.val);
		System.out.println(node.left.val);
		System.out.println(node.right.val);
	}

}
