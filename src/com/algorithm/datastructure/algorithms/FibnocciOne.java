package com.algorithm.datastructure.algorithms;

import java.util.HashMap;
import java.util.Map;

public class FibnocciOne {

	
	/*
	 * https://leetcode.com/problems/fibonacci-number/
	 */	
	
	// solution 1
	public int fib(int N) {
    
		if(N == 0 ) return 0;
		if(N == 1) return 1;
		
		return fib(N-1) + fib(N-2);
		
    }
	
	// solution 2 with memoriaion
	public int fib2(int N) {
		Map<Integer, Integer> cacheMap = new HashMap<>();
		
		return fibR(N, cacheMap);
	}
	
	public int fibR(int n, Map<Integer, Integer> cache) {
		
		if(cache.containsKey(n)) {
			return cache.get(n);
		}else {
			if(n == 0) {
				cache.put(n, 0);
				return 0;
			}
			else if(n == 1) {
				cache.put(n,1);
				return 1;
			}
		}
		
		int result = fibR(n-1, cache) + fibR(n-2, cache);
		cache.put(n, result);
				
		return cache.get(n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FibnocciOne f = new FibnocciOne();
		int r = f.fib(4);
		System.out.println(r);
		
		System.out.println(f.fib2(4));
		
	}

}
