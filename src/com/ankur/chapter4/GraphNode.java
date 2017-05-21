package com.ankur.chapter4;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	
	public int val;
	public Iterable<GraphNode> adjacent;
	private List<GraphNode> neighbors;
	public boolean visited;
	
	public GraphNode(int val) {
		this.val = val;
		this.neighbors = new ArrayList<>();
		adjacent = neighbors;
	}
	
	public void addNeighbor(GraphNode e) {
		neighbors.add(e);		
	}
	

}
