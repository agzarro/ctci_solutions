package com.ankur.chapter4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BuildOrder {
	
	public static void main(String[] args) {
		
	}
	
	public Iterable<GraphNode> getBuildOrder(Iterable<GraphNode> projects, Iterable<GraphNode> dependencies) {
		if (projects == null) {
			
		}
		Queue<GraphNode> buildOrder = new LinkedList<>();
		Stack<GraphNode> stack = new Stack<>(); 
		for (GraphNode g : projects) {
			if (g.visited && g.adjacent != null) {
				return null;
			}
			if (g.adjacent == null) {
				buildOrder.add(g);
			} else {
				for (GraphNode neighbor : g.adjacent) {
					stack.push(neighbor);
				}
				while(!stack.isEmpty()) {
					stack.pop();
				}
			}
			if (!g.visited) {
				visit(g, buildOrder);
			}		
		}
		return buildOrder;
	}
	
	private void visit(GraphNode g, Queue<GraphNode> buildOrder) {
		if (g != null) {
			g.visited = true;
			buildOrder.add(g);
			for (GraphNode neighbor : g.adjacent) {
				visit(neighbor, buildOrder);
			
			}
			g.adjacent = null;
		}
	}

}
