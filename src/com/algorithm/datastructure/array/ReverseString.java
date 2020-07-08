package com.algorithm.datastructure.array;

public class ReverseString {

	
	//https://leetcode.com/problems/reverse-string/
	
	// solution
	// https://leetcode.com/articles/reverse-string/
		 
	
	// recursive print the string
	 public void reverseString(char[] s) {
	    
		 reverseHelper(s, 0 , s.length-1);
	 }
	 
	 private void reverseHelper(char[] s , int start, int end) {
		 
		 // base case
		 if(start >= end ) return;
		 
		 char tmp = s[start];
		 s[start] = s[end];
		 s[end] = tmp;
		 		 
		 reverseHelper(s, ++start, --end);
		 
	 }
	
	 // iterative
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseString r = new ReverseString();
		char[] strs = new char[] {'a','b','c'};
		char[] strs1 = new char[] {'a'};
		r.reverseString(strs1);
		
		for(char c: strs1) {
			System.out.print(String.format("%s ", c));
		}
	}

}
