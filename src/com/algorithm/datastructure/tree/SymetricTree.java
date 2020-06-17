package com.algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SymetricTree {
	
	TreeNode root;
	//https://leetcode.com/problems/symmetric-tree/

	
	// insertNode
	
	public void insertNode(int value) {
		// check is first node
		if (root == null) {
			root = new TreeNode(value);
		} else {
			// using while to insert
			TreeNode currentNode = root;

			while (true) {
				// left
				if (value < currentNode.val) {
					if (currentNode.left == null) {
						currentNode.left = new TreeNode(value);
						break;
					}
					currentNode = currentNode.left;
				} else {
					// right
					if (currentNode.right == null) {
						currentNode.right = new TreeNode(value);
						break;
					}
					currentNode = currentNode.right;
				}

			}
			
		}		
	}
	
	// iterative
	/* 
	 *  this is the failed practice
	public boolean isSymmetricTree(TreeNode node) {
		
		// using binary tree bfs 
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 boolean isMirror = true;
		 
		 if(node != null) {
		 queue.add(node);
		 List<Integer> dp = new ArrayList<>();
		 List<Integer> sizeQ = new ArrayList<>();
		 while(queue.size()>0) {
		
			 TreeNode deNode = queue.poll();
			 sizeQ.add(queue.size());
			 			 
			 // add left and right node if the node is not null
			 if(deNode.left != null ) {
				 queue.add(deNode.left);
			 }
			 
			 if(deNode.right != null ) {
				 queue.add(deNode.right);
			 }
			
 			 if(isMirror(queue,dp) == false ) {
				isMirror = false;
				break;
			}
 			 
 			 if(sizeQ.size()>=2 ) {
 				 int diff = sizeQ.get(sizeQ.size()-1) -sizeQ.get(sizeQ.size()-2);
 				 if(Math.abs(diff) == 0) {
 					 isMirror = false;
 				 }
 			 }
		 }
		 }
		
		return isMirror;
	}
	
	public boolean isMirror(Queue<TreeNode> queue,List<Integer> list) {
		boolean isM = true;
		int size = queue.size();
		
		 double n  = Math.log(size) / Math.log(2); 
		if(queue.size() >1 
				&& n%1 ==0 
				) {
			if(list.size() == 0 || (int)n > list.get(list.size()-1)) {
			TreeNode[] tArray = queue.toArray(new TreeNode[queue.size()]);
			int halfLen = tArray.length/2;
			for(int i = 0; i<halfLen; i++) {
				if(tArray[i].val != tArray[tArray.length-i-1].val) {
					isM = false;
					break;
				}
			}
			list.add((int) n);
			}
			
		}
		return isM;
		
	}
	*/
	public boolean isSymmetricTree(TreeNode node) {
		boolean isM = true;
		Queue<TreeNode> queue = new LinkedList<>();
		
		if(node != null) {
			queue.add(node.left);
			queue.add(node.right);
		}
		
		while(!queue.isEmpty()) {
			
			TreeNode leftNode = queue.poll();
			TreeNode rightNode = queue.poll();
			
			if(leftNode == null && rightNode == null) continue;
			
			if(leftNode !=null && rightNode ==null 
		      || leftNode == null && rightNode !=null) {
				isM  =false;
				break;
			}
			
			if(leftNode.val != rightNode.val) {
				isM = false;
				break;
			}
			
			queue.add(leftNode.left);
			queue.add(rightNode.right);
			queue.add(leftNode.right);
			queue.add(rightNode.left);
		}
		
		
		return isM;
	}
	
	
	// recursive
	public boolean isSymmetricTreeR(TreeNode node) {
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SymetricTree tree = new SymetricTree();
//        tree.root = new TreeNode(1); 
//        tree.root.left = new TreeNode(2); 
//        tree.root.right = new TreeNode(2); 
//        tree.root.left.left = new TreeNode(3); 
//        tree.root.left.right = new TreeNode(4); 
//        tree.root.right.left = new TreeNode(4); 
//        tree.root.right.right = new TreeNode(3); 
        
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(2); 
        tree.root.left.left = null; 
        tree.root.left.right = new TreeNode(3); 
        tree.root.right.left = null; 
        tree.root.right.right = new TreeNode(3); 
        
        
        boolean b = tree.isSymmetricTree(tree.root);
        System.out.println(b);
		
	}

}
