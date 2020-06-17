package com.algorithm.datastructure.sorting;

public class MergeSort {

	/**
	 * method to sort the array
	 */
	public void sort(int[] array, int l, int r) {
		
		if (l < r) {
		// get the middle index of the array
		int mid = (l+r)/2;
		
		// divide the array into left and right array
		sort(array, l, mid);
		sort(array,mid+1, r);
		
		// merge array back		
		merge(array, l, mid, r);
		}
	}
	
	/**
	 * method to merge the two arrays
	 */
	public void merge(int[] array, int l, int m, int r) {
		
		int llen = m-l+1;
		int rlen = r-m;
		int[] lArray = new int[llen];
		int[] rArray = new int[rlen];
		
		// copy left array
		for(int i = 0;i < llen; i++) {
			lArray[i] = array[l+i]; 
		}
		
		// copy right array
		for(int j =0;j <rlen; j++) {
			rArray[j] = array[m+j+1]; 
		}
		
		// merge back to original array 
		int lcnt =0, rcnt = 0;
		int k = l;
		while(lcnt<llen && rcnt<rlen) {			
			if( lArray[lcnt] <= rArray[rcnt] ) {
			 array[k] = lArray[lcnt];
			 lcnt++;
			}else {			
			 array[k] = rArray[rcnt];
			 rcnt++;
			}
			k++;
		}
		
		// merge remaining of left array
		while(lcnt <llen) {
			array[k] = lArray[lcnt];
			lcnt++;
			k++;
		}
				
		// merge remaining of right array
		while(rcnt <rlen ) {
			array[k] = rArray[rcnt];
			rcnt++;
			k++;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergeSort ms = new MergeSort();
		
		int[] testArray ={4, 7, 10, 5};
		
		ms.sort(testArray, 0, testArray.length-1);
		
		for(int r : testArray) {
			System.out.println(r);
		}
	}

}
