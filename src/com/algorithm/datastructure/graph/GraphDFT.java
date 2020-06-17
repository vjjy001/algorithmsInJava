package com.algorithm.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphDFT {

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
	Stack<Vertix> visitedStack;
	
	public GraphDFT() {
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
		visitedStack = new Stack<>();
		
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
	// insert vertix to graph	
	public void insert(Vertix vertix) {
		
	}
	
	// search vertix
	
	
	// depth first travers
	
	public void dfs(int vertixPos) {
		
		if(graph != null && graph.size()>0) {
			
			Vertix start = graph.get(vertixPos);
			start.visited = true;
			System.out.println(String.format("Vertix %s", start.vertixName));
			visitedStack.push(start);
			
			while(visitedStack.size()>0) {
				
				Vertix v = visitedStack.peek();
				List<Vertix> childs = v.adjVertixs;
				// find any adj not visited yet if all visit return null
				v = findFirstNotVisited(childs);
				// all the adj vertix are visited then pop from stack
				if(v == null) {
					visitedStack.pop();
				}
				else  { 
						// find adj v is not visisted
						System.out.println(String.format("Vertix %s", v.vertixName));
						v.visited= true;
						visitedStack.push(v);

					}
					
					
				}
			}
					
	}
	
	public Vertix findFirstNotVisited(List<Vertix> list) {
		Vertix vx = null;
		for(Vertix v: list) {
			if(!v.visited) {
				vx = v;
				break;
			}
		}
		return vx;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphDFT graph = new GraphDFT();
		graph.dfs(0);
	}

}
