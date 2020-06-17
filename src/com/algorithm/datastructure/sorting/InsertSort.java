package com.algorithm.datastructure.sorting;

public class InsertSort {

	public static int[] sort(int[] sortArray) {
		
		int curKey = 0;
		int insertPos = 0;
		for(int i = 1; i < sortArray.length; i++) {
			System.out.println("curkey"+sortArray[i]);
			curKey = sortArray[i];
			// loop the sort index
			for(int j = i-1; j>=0; j-- ) {
				//System.out.println("key:"+curKey);				
				if(curKey < sortArray[j]) {
					System.out.println("swap"+sortArray[j]);
					sortArray[j+1] = sortArray[j];										
				}else {
					insertPos = j+1;
					break;
				}
			}
			System.out.println("pos"+insertPos);
			sortArray[insertPos] = curKey; 
			
		}
		
		
		return sortArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArray = {15,3, 5, 7, 9};
				
		int[] result = InsertSort.sort(testArray);
		
		for(int j: result) {
			System.out.println(j);
		}
	
	}

}
