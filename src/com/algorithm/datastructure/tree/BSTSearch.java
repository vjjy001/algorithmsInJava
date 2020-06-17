package com.algorithm.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.algorithm.datastructure.tree.BST.Node;

public class BSTSearch {

	Node root;	
	public void insertNode(int value) {
		// check is first node
		if (root == null) {
			root = new Node(value);
		} else {
			// using while to insert
			Node currentNode = root;

			while (true) {
				// left
				if (value < currentNode.value) {
					if (currentNode.leftNode == null) {
						currentNode.leftNode = new Node(value);
						break;
					}
					currentNode = currentNode.leftNode;
				} else {
					// right
					if (currentNode.rightNode == null) {
						currentNode.rightNode = new Node(value);
						break;
					}
					currentNode = currentNode.rightNode;
				}

			}
			
		}		
	}
	
	// BFS
	public void bfs() {
		
		Queue<Node> queue = new LinkedList<>();		
		queue.add(this.root);
		
		while(queue.size()>0) {
			Node node = queue.poll();
			System.out.println(String.format("Node Visited: %s", node.value));
			// put the child node to the queue
			if(node.leftNode != null) {
				queue.add(node.leftNode);
			}			
			if(node.rightNode != null) {
				queue.add(node.rightNode);
			}			
		}
	}
	
	/**
	 * Breath first traverse using recursive
	 */
	public void bfsR(Queue<Node> queue) {
		
		if(queue.size() <= 0) {
			return;
		}
		Node node = queue.poll();
		System.out.println(node.value);
		if(node.leftNode != null) {
			queue.add(node.leftNode);
		}
		if(node.rightNode != null) {
			queue.add(node.rightNode);
		}
		
		bfsR(queue);
		
	}
	
	class Node{
		Node leftNode;
		Node rightNode;
		int value;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTSearch bst = new BSTSearch();
		bst.insertNode(30);
		bst.insertNode(20);
		bst.insertNode(25);
		bst.insertNode(15);
		bst.insertNode(50);
		bst.insertNode(40);
		bst.insertNode(55);
		/*
		 	30
		  20  50
	   15  25  40 55	
		 */
		// traverse by bread first
		//bst.bfs();
		Queue<BSTSearch.Node> q = new LinkedList<BSTSearch.Node>();
		q.add(bst.root);
		bst.bfsR(q);
	}

}
