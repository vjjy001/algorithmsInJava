package com.algorithm.datastructure.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleOne {

	/*
	 * https://leetcode.com/problems/pascals-triangle/
	 */
	
	// iterative
    public List<List<Integer>> generate(int numRows) {
     
    	List<List<Integer>> pascalList = new ArrayList<>();
    	if(numRows <= 0) {
    		return pascalList;
    	}
  
    	for(int i =0; i<numRows; i++) {
    		
    		List<Integer> colList = new ArrayList<>();
    		for(int j =0; j<=i; j++) {
    			
    			if(j==0 || j==i) {
    				colList.add(1);
    			}else {
    				Integer result = pascalList.get(i-1).get(j-1) + pascalList.get(i-1).get(j);
    				colList.add(result);
    			}
    		}
    		pascalList.add(colList);
    	}
    	
    	
    	return pascalList;
    }
    
    // recursive
    public List<List<Integer>> generateR(int numRows) {
    	
    	return null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PascalsTriangleOne p1 = new PascalsTriangleOne();
		List<List<Integer>> result = p1.generate(5);
		
		result.stream().forEach(row -> {
			System.out.println();
			row.stream().forEach(num -> {
				System.out.print(num+" ");
			});
		});
		
	}

}
