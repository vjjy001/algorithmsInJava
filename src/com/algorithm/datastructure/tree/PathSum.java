package com.algorithm.datastructure.tree;

public class PathSum {

	//	https://leetcode.com/problems/path-sum/
	
	// solution using top to bottom
	// pre order logic sum the value for each possible path currenSum+ left or right until end of the path (both child is null)
	private boolean isPathSum;
	
    public boolean hasPathSum(TreeNode root, int sum) {
        
    	if(root == null) return false;
    	int calSum = 0;
    	pathSumHelper(root, sum, calSum);
    	return isPathSum;
    			
    }
	
    private void pathSumHelper(TreeNode node, int sum, int calSum) {
    	
    	if(node == null) return;
    	
    	if( node.left == null && node.right ==  null  && sum == calSum+node.val) isPathSum = true;
    	pathSumHelper(node.left, sum , calSum+node.val);
    	pathSumHelper(node.right, sum , calSum+node.val);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PathSum sum = new PathSum();
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		
		boolean ispath = sum.hasPathSum(root, 3);
		System.out.println(ispath);
	}

}
