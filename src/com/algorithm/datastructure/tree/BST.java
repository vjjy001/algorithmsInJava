package com.algorithm.datastructure.tree;

public class BST {

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

	public void preorder(Node node) {

		if (node != null) {
			System.out.println(node.value);
			preorder(node.leftNode);
			preorder(node.rightNode);
		} else {
			return;
		}

	}
	
	public void inorder(Node node) {
		if(node == null) return;
		inorder(node.leftNode);
		System.out.println(node.value);
		inorder(node.rightNode);
	}

	public void postorder(Node node) {
		if( node == null) return;
		postorder(node.leftNode);
		postorder(node.rightNode);
		System.out.println(node.value);
	}
	class Node {
		int value;
		Node leftNode;
		Node rightNode;

		public Node(int value) {
			this.value = value;
			this.leftNode = null;
			this.rightNode = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test with 30 20 25 15 50 40 55
		/* 			30 
		 * 	
		 * */
		BST bst = new BST();
		bst.insertNode(30);
		bst.insertNode(20);
		bst.insertNode(25);
		bst.insertNode(15);
		bst.insertNode(50);
		bst.insertNode(40);
		bst.insertNode(55);

		bst.preorder(bst.root);
		System.out.println("----");
		bst.inorder(bst.root);
		System.out.println("----");
		bst.postorder(bst.root);
//		System.out.println(bst.root.value);
//		System.out.println(bst.root.leftNode.value);
//		System.out.println(bst.root.rightNode.value);

	}

}
