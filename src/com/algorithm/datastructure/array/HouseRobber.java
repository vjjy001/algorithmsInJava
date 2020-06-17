package com.algorithm.datastructure.array;

public class HouseRobber {

	/*
	 * leecode 198
	 * https://leetcode.com/problems/house-robber/
	 */
	
	/*
	 * Input: nums = [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2),
	 * rob house 3 (money = 9) and rob house 5 (money = 1). Total amount you can rob
	 * = 2 + 9 + 1 = 12.
	 */
	 public int rob(int[] nums) {
	    
		 // using dynamic programming to save pre-max, cur-max in array
		 int[] dp = new int[nums.length];
		 
		 if(nums.length == 0) return 0;
		 
		 if(nums.length ==1 ) return nums[0];
		 
		 if(nums.length ==2 ) return Math.max(nums[0], nums[1]);
		 
		 dp[0] = nums[0];
		 dp[1] = Math.max(nums[0], nums[1]);
		 
		 for(int i =2; i <nums.length; i++) {
			 
			 dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
			 
		 }
		 
		 return dp[nums.length-1];
		 
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber hr = new HouseRobber();
		int[] testArray = new int[] {1,2,3,1};
		//int[] testArray = new int[] {2,7,9,3,1};
		System.out.println(hr.rob(testArray));
		
	}

}
