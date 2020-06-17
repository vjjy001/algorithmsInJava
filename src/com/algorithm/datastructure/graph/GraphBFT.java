package com.algorithm.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFT {

	class Vertix{
		String vertixName;
		List<Vertix> adjVertixs;
		boolean visited;
		
		public Vertix(String name) {
			this.vertixName = name;
			this.adjVertixs = new ArrayList<>();
		}
	}
	
	List<Vertix> graph;
	Queue<Vertix> visitedQueue;
	
	public GraphBFT() {
		//init graph
		init();
	}
	
	void init() {
		Vertix s = new Vertix("S");
		Vertix a = new Vertix("A");
		Vertix b = new Vertix("B");
		Vertix c = new Vertix("C");
		Vertix d = new Vertix("D");
		
		this.graph = new ArrayList<>();
		visitedQueue = new LinkedList<>();
		
		s.adjVertixs.add(a);
		s.adjVertixs.add(b);
		s.adjVertixs.add(c);
		
		a.adjVertixs.add(s);
		a.adjVertixs.add(d);
		
		b.adjVertixs.add(s);
		b.adjVertixs.add(d);
		
		c.adjVertixs.add(s);
		c.adjVertixs.add(d);
		
		d.adjVertixs.add(a);
		d.adjVertixs.add(b);
		d.adjVertixs.add(c);
		
		graph.add(s);
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);		
	}
	
	public void bft(int pos) {
		
		Vertix start = graph.get(pos);
		
		
		start.visited= true;
		System.out.println(String.format("Vertix %s", start.vertixName));
		visitedQueue.add(start);
		
		while(visitedQueue.size() >0) {
			
			// poll vertix from queue;
			Vertix cv = visitedQueue.poll();
			List<Vertix> adjs = cv.adjVertixs;
			// add vertix to queue if not visited
			for(Vertix v : adjs) {
				if( !v.visited) {
					visitedQueue.add(v);
					v.visited = true;
					System.out.println(String.format("Vertix %s", v.vertixName));
				}
			}
			// enqueue all the unvisted node
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphBFT graph = new GraphBFT();
		// start from  s node
		graph.bft(1);
	}

}
