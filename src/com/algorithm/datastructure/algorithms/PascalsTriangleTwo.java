package com.algorithm.datastructure.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleTwo {

	/*
	 * https://leetcode.com/problems/pascals-triangle-ii/
	 */	
	/*
	List<List<Integer>> dp = new ArrayList<>();

    public List<Integer> getRow(int rowIndex) {
    	pascals(rowIndex,rowIndex);
    	return dp.get(rowIndex);
    }
    
    public Integer pascals(int row, int col){
    	   
    	if(row == 0 && col == 0) {
    		if(dp.isEmpty() || dp.get(row) == null) {
    			List<Integer> colList =new ArrayList<Integer>();
    			colList.add(1);
    			dp.add(colList);
    		}else if(dp.get(row).get(col) == null) {    			
    			dp.get(row).add(1);
    		}
    		return 1;
    	}
    	Integer cal =  pascals(row-1,col-1) + pascals(row-1,col);
    	
    	if(col == 0 || col== row ) {
    		if(dp.isEmpty() || dp.get(row) == null) {
    			List<Integer> colList =new ArrayList<Integer>();
    			colList.add(1);
    			dp.add(colList);
    		}else if(dp.get(row).get(col) == null) {    			
    			dp.get(row).add(1);
    		}    		
    		return 1;
    	}
    	dp.get(row).add(cal);
    	
    	return cal;
    	
    }
    */
    // solution
    
    //https://leetcode.com/problems/pascals-triangle-ii/discuss/685064/0ms-RECURSIVE-Java-solution-with-memoization!!!-Explained.
    
    public List<Integer> getRow(int rowIndex) {
    	
    	int[][] mem = new int[rowIndex+1][];
    	List<Integer> list = new ArrayList<>();
    	// init the size of mem
    	for(int i =0; i<= rowIndex; i++) {
    		mem[i] = new int[i+1];
    	}
    	for(int i=0;i<=rowIndex;i++) {
    		list.add(pascalsr(rowIndex, i, mem));
    	}
    	
    	return list;
    }
    
    public int pascalsr(int row, int col, int[][] mem) {
    	
    	// mem not assigned yet
    	// check mem first
    	if(mem[row][col] == 0) {
    		if(col == 0 || col == row) {
        		mem[row][col] = 1;
        		return mem[row][col];
        	}
    	}else {
    		return mem[row][col];
    	}
    	
    	mem[row][col] = pascalsr(row-1,col-1,mem) + pascalsr(row-1,col,mem);
    	
    	return mem[row][col]; 
    	
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangleTwo p2 = new PascalsTriangleTwo();
		p2.getRow(3);
	}

}
