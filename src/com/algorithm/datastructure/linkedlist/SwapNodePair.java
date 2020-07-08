package com.algorithm.datastructure.linkedlist;

public class SwapNodePair {

	/*
	 * https://leetcode.com/problems/swap-nodes-in-pairs/
	 */
	
    public ListNode swapPairs(ListNode head) {
        
    	if(head == null || head.next == null) return head;
   	
    	return swapNode(head);
    	
    }
	public ListNode swapNode(ListNode head) {
		if(head == null ) return null;
    	
		if(head.next == null) return head;
		
    	ListNode node = swapNode(head.next.next);
    	ListNode nextNode = head.next;
	    nextNode.next = head;
	    head.next = node;
	  
    	
    	return nextNode;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwapNodePair s = new SwapNodePair();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		
		ListNode newHead = s.swapPairs(head);
		ListNode tmp = newHead;
		while(tmp != null) {
			System.out.println(tmp.val);
			tmp = tmp.next;
			
		}
	}

}
