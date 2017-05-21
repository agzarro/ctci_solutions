package com.ankur.chapter4;

import java.util.Random;

public class RandomNode {
	
	Node root;
	
	public static class Node {
		Node left;
		Node right;
		int val;
		int size;
	}
	
	public static void main(String[] args) {
		
	}
	
	
	public Node getRandomNode() {
		Random r = new Random();
		int index = r.nextInt(root.size);
		return selectRandomNode(root, index);
	}
	
	private Node selectRandomNode(Node node, int index) {
		
		if(index == node.left.size) {
			return node;
		} else if (node.left!=null && index < node.left.size) {
			return selectRandomNode(node.left, index);
		} else {
			return selectRandomNode(node.right, index-(node.left.size+1));
		}
	}

}
