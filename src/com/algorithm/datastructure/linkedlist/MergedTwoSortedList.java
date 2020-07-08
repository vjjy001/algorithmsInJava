package com.algorithm.datastructure.linkedlist;

public class MergedTwoSortedList {

//	https://leetcode.com/problems/merge-two-sorted-lists/
	
	
	// iterative solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
		/* 
		 * two pointer time: o(n) 
		 * 
		 * */
    	
    	ListNode mergedHead = null;
    	ListNode l1Node = l1;
    	ListNode l2Node = l2;
    	ListNode mNode = null;
    	//mNode.val = Integer.MIN_VALUE;
    	while(l1Node != null && l2Node != null) {
    		if(l1Node.val <l2Node.val) {
    			if(mNode == null) {
    				mNode = new ListNode(l1Node.val);
    				mergedHead = mNode;
    			}else {
    				mNode.next = new ListNode(l1Node.val);
    				mNode = mNode.next;
    			}
    			
    			l1Node = l1Node.next;
    		}else if(l1Node.val > l2Node.val){
    			if(mNode == null) {
    				mNode = new ListNode(l2Node.val);
    				mergedHead = mNode;

    			}else {
    				mNode.next = new ListNode(l2Node.val);
    				mNode = mNode.next;
    			}
    			l2Node = l2Node.next;
    		}else {
    			if(mNode == null) {
    				 mNode = new ListNode(l1Node.val);
    				 mergedHead = mNode;
    				 mNode.next = new ListNode(l2Node.val);
    				 mNode = mNode.next;
    			}else {    				
    				mNode.next = new ListNode(l1Node.val);
    				mNode = mNode.next;
    				mNode.next = new ListNode(l2Node.val);
    				mNode = mNode.next;
    			}
    			l1Node = l1Node.next;
    			l2Node = l2Node.next;
    		}
    		
    	}
    	
		// merged remain left
		while(l1Node != null) {
			
			if(mNode == null) {
				mNode = new ListNode(l1Node.val);
				mergedHead = mNode;
			}else {
				mNode.next = new ListNode(l1Node.val);
				mNode = mNode.next;

			}
			l1Node = l1Node.next;
		}
		
		// merged remain right
		while(l2Node != null) {
			if(mNode == null) {
				mNode = new ListNode(l2Node.val);
				mergedHead = mNode;
			}else {
				mNode.next = new ListNode(l2Node.val);
				mNode = mNode.next;
			}
			l2Node = l2Node.next;

		}
		
    	return mergedHead;
    }
	
    // recursive solution    
    public ListNode mergedList(ListNode l1, ListNode l2, ListNode tailNode, ListNode head) {
    	
    	// l1 not null l2 null
    	if(l1 != null && l2 == null) {
    		if(tailNode == null) {
    			tailNode = new ListNode(l1.val);
    			head = tailNode;
    		}else {
        		tailNode.next = new ListNode(l1.val);
        		tailNode = tailNode.next;
    		}
    		 mergedList(l1.next, l2, tailNode,head);
    	}else if( l1 != null && l2 != null) {
        	// l1 l2 not null

    		if(l1.val < l2.val) {
        		if(tailNode == null) {
        			tailNode =  new ListNode(l1.val);
        			head = tailNode;
        		}else {
        			tailNode.next = new ListNode(l1.val);
        			tailNode = tailNode.next;
        		}

        		 mergedList(l1.next, l2, tailNode,head);
    		}else if(l1.val >l2.val) {
        		if(tailNode == null) {
        			tailNode = new ListNode(l2.val);
        			head = tailNode;
        		}else {
        			tailNode.next = new ListNode(l2.val);
        			tailNode = tailNode.next;
        		}

        		 mergedList(l1, l2.next, tailNode,head);
    		}else {
        		if(tailNode == null) {
        			tailNode = new ListNode(l1.val, new ListNode(l1.val));
        			head = tailNode;
        			tailNode = tailNode.next;
        		}else {
        			for(int i=0;i <2; i++) {
    	    			tailNode.next = new ListNode(l2.val);
    	    			tailNode = tailNode.next;
        			}
        		}
    			

        		 mergedList(l1.next, l2.next, tailNode,head);

    		}    		
    	}else if(l1 == null && l2 != null){
        	// l1 null l2 not null
    		if(tailNode == null) {
    			tailNode =  new ListNode(l2.val);
    			head = tailNode;
    		}else {
    			tailNode.next = new ListNode(l2.val);
        		tailNode = tailNode.next;
    		}
    		
    		  mergedList(l1, l2.next, tailNode, head);

    	}
    	else if(l1 == null && l2 == null) return head;
    	
    	return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {   	    	
    	return mergedList(l1,l2, null,null);    	    	
    }
    
    // online solution
    // recursive no need to use new list
    // https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using-recursion
    
    // online iterative way
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergedTwoSortedList m = new MergedTwoSortedList();
// 		test 1
//		ListNode l1 = new ListNode(2);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(5);
//		
//
//
//		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(3);
//		l2.next.next = new ListNode(4);
		
		// test2
//		ListNode l1 = null;
//		ListNode l2 = null;
		
		// test 3
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		//ListNode result = m.mergeTwoLists(l1, l2);
		ListNode result = m.mergeTwoLists2(l1, l2);
		
		ListNode tmp = result;
		while(tmp != null) {
			System.out.println(tmp.val);
			tmp = tmp.next;
			
		}
	}

}
