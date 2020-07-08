package com.algorithm.datastructure.algorithms;

import java.math.BigDecimal;

public class PowN {

	//https://leetcode.com/problems/powx-n/
	
	
	// easy solution
    public double myPow(double x, int n) {
        double result = 1;
        
        if(x == 1) return 1;
        
        int N = Math.abs(n);
    	for(int i=0;i<N; i++) {
    		result *= x;
    	}
    	if(n >=0) { 
    		return result;
    	}
    	
    	return 1/result;
    }
    
    // recursive
    
    public double myPowR(double x, int n) {
    	// for faster speed using even odd.
    	// 2*2*2*2 = (4*4)
    	if(n==0) return 1;
    	if(n ==1) return x;
    	
    	if(n >=0) {
    		
    		if( n%2 == 0) {
    			return myPowR(x*x,n/2);
    		}else {
    			return x* myPowR(x*x,(n-1)/2);
    		}   		     	
    	}else {
    		return 1 / (x *  myPowR(x,-(n+1)));
    	}
    }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowN p = new PowN();
		System.out.println(p.myPow(2, -10));
		System.out.println(p.myPowR(2, -10));
		//System.out.println(p.myPowR2(2, 10));
		
	}

}
