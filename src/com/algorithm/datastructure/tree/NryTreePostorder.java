package com.algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NryTreePostorder {

	/*
	 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
	 */	
	
	static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
    public List<Integer> postorder(Node root) {
    	
    	List<Integer> resultList = new ArrayList<>();
    	
    	postorderR(root, resultList);
    	
    	return resultList;
    	    	
        }
	
    public void postorderR(Node node, List<Integer> resultList){
    	
    	if(node != null) {    	
	    	List<Node> childNodes = node.children;
	    		if(childNodes != null)
		    	for(int i =0;i< childNodes.size(); i++) {
		    		if(childNodes != null && Objects.nonNull(node.children.get(i))) {
		    			postorderR(node.children.get(i), resultList);
		    		}
		    	}
		    	resultList.add(node.val);
	    	
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// test data [1,null,3,2,4,null,5,6]
	
		NryTreePostorder.Node root = new NryTreePostorder.Node(1);
		
		root.children = new ArrayList<>();
		root.children.add(new NryTreePostorder.Node(3));
		root.children.add(new NryTreePostorder.Node(2));
		root.children.add(new NryTreePostorder.Node(4));
		
		root.children.get(0).children = new ArrayList<NryTreePostorder.Node>();
		root.children.get(0).children.add(new NryTreePostorder.Node(5));
		root.children.get(0).children.add(new NryTreePostorder.Node(6));

		NryTreePostorder p = new NryTreePostorder();
		List<Integer> result = p.postorder(root);
		result.forEach(i -> System.out.println(i));
		
	}

}
