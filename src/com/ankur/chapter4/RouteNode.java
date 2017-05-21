package com.ankur.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RouteNode {
	
	public static void main(String[] args) {
		GraphNode source = new GraphNode(1);
		GraphNode n1 = new GraphNode(2);
		source.addNeighbor(n1);
		GraphNode n2 = new GraphNode(3);
		source.addNeighbor(n2);
		GraphNode n3 = new GraphNode(4);
		n2.addNeighbor(n3);
		GraphNode n4 = new GraphNode(5);
		n3.addNeighbor(n4);
		GraphNode destination = new GraphNode(6);
		n3.addNeighbor(destination);

		List<GraphNode> path = new ArrayList<>();
		if (getPath(source, destination, path)) {
			for (GraphNode node : path) {
				System.out.println(node.val);
			}
		} else {
			System.out.println("Path not found");
		}
		

	}
	
	public boolean hasRoute(GraphNode source, GraphNode dest) {
		if (source == null || dest == null) {
			return false;
		}
		
		Queue<GraphNode> path = new LinkedList<>();
		path.add(source);
		while (!path.isEmpty()) {
			GraphNode n = path.remove();
			n.visited = true;
			if (n == dest) {
				return true;
			}
			for (GraphNode node : n.adjacent) {
				if (!n.visited) {
					path.add(node);
				}
			}
		}
		
		return false;
		
	}
	
	public static boolean getPath(GraphNode source, GraphNode dest, List<GraphNode> path) {
		if (source == null || dest == null) {
			return false;
		}
		if (source == dest) {
			return true;
		}
		for (GraphNode graphNode : source.adjacent) {
			if(!graphNode.visited) {
				graphNode.visited = true;
				if (getPath(graphNode, dest, path)) {
					path.add(graphNode);
					return true;
				}
			}
		}
		return false;		
	}
	
}
	
	 

