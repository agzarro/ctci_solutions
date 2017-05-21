package com.ankur.chapter4;

public class CommonAncestor {
	
	public static void main(String[] args) {
		int[] elements = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println("Creating BST...");
		Node root = MinimalTree.createBST(elements, 0, elements.length-1);
		System.out.println(root.left.val);
		System.out.println(root.left.left.val);
		System.out.println(getAncestor(root, root.right.right, root.right.left).val);
		
	}
	
	public static Node getAncestor(Node root, Node n1, Node n2) {
		if (n1 == n2 || n1 == null || n2 == null) {
			return n1;
		}				
		
		boolean n1FoundLeft = true;
		boolean n2FoundLeft = false;
		while (true) {
			if (n1 == root || n2 == root) {
				return root;
			}
			n1FoundLeft = findNode(root.left, n1);
			n2FoundLeft = findNode(root.left, n2);
			if (n1FoundLeft != n2FoundLeft) {
				return root;
			}
			if (n1FoundLeft == true && n2FoundLeft == true) {
				root = root.left;
			} 
			else {
				root = root.right;
			}			
		}
		
	}
	
	public static boolean findNode(Node node, Node searchNode) {
		if (node == null || searchNode == null) {
			return false;
		}
		if (node == searchNode) {
			return true;
		}
		return findNode(node.left, searchNode) || findNode(node.right, searchNode);
	}

}
