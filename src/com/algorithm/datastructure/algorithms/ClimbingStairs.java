package com.algorithm.datastructure.algorithms;

public class ClimbingStairs {

	
	/*
	 * https://leetcode.com/problems/climbing-stairs/
	 */	
	
	// https://leetcode.com/problems/climbing-stairs/solution/
	
	// solution 1 recurisive 2^n
	public int climbStairs(int n) {
        // formular f(i+1,n)+f(i+2,n)
		
		return climbStair(0, n);
		
    }
	
	private int climbStair(int totalStep, int n) {
		
		if(n == 0) return 0;
		if(n == totalStep ) return 1;
		if(totalStep > n) return 0;
		
		int qualifyCnt= climbStair(totalStep+1,n) + climbStair(totalStep+2,n);
		
		return qualifyCnt;
	}
	
	// solution 2 dynamic programming
	// formular f = f(n-1) + f(n-2)
	// f(0) = 0 f(1) =1 f(2) =2
	
	public int climbStairsDp(int n) {
		
		int[] dp = new int[n];
		
		if(n <= 1) return 1;
		else if(n >1) {
			
			dp[0] = 1;
			dp[1] = 2;
			
			for(int i = 2; i<n; i++) {
				dp[i] = dp[i-1] +dp[i-2];
			}			
		}
		
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs(3));
		System.out.println(c.climbStairsDp(30));
		
	}

}
