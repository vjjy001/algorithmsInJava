package com.algorithm.datastructure.algorithms;

public class KthSymbolGrammer {

//	https://leetcode.com/problems/k-th-symbol-in-grammar/
	
	// recursive as tree model
    public int kthGrammar(int N, int K) {
        
    	if( N == 1 || K== 1) return 0;
    	if( K == 2 ) return 1;
    	
    	// if k is odd
    	// if parent is 0
    	if(K % 2 != 0) {
    		// parent is 0
    		 if (kthGrammar(N-1,(K+1)/2) == 0) {
    			 return 0;
    		 }else {
    			 // parent is 1
    			 return 1;
    		 }
    	}else {
        	// if k is even 1
    		if (kthGrammar(N-1,(K+1)/2) == 0) {
   			 return 1;
   		 }else {
   			 return 0;
   		 }
    	}    	
    }
	

    
	public static void main(String[] args) {
		KthSymbolGrammer k = new KthSymbolGrammer();
		int result = k.kthGrammar(2, 1);
		System.out.println(result);
		
		//System.out.println((5+1)/2);
	}
}
