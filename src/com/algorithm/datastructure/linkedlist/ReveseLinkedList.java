package com.algorithm.datastructure.linkedlist;

public class ReveseLinkedList {

	/*
	 * https://leetcode.com/problems/reverse-linked-list/
	 */
	
//	 ListNode headG;
//	 public ListNode reverseList(ListNode head) {
//	 
//		 if(head == null) return null;
//		 
//		 ListNode node = reverseList(head.next);
//		 if(node != null) {
//			 node.next = head;
//			 head.next = null;
//		 }else {
//			 headG = head;
//		 }
//		 return head;
//	 }
	 
	 public ListNode reverseList(ListNode head) {
	 
		 if(head == null || head.next == null) return head;
		 
		 ListNode node = reverseList(head.next);
	 	 head.next.next =head;
		 head.next = null;
				 
		 return node;
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		//head.next.next.next.next.next= new ListNode(6);
		
		ReveseLinkedList r = new ReveseLinkedList();
		ListNode newHead = r.reverseList(head);
		ListNode tmp = newHead;
		while(tmp != null) {
			System.out.println(tmp.val);
			tmp = tmp.next;
			
		}
		
	}

}
