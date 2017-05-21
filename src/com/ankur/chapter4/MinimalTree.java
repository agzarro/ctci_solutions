package com.ankur.chapter4;



public class MinimalTree {
	
	public static void main(String[] args) {
		int[] elements = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println("Creating BST...");
		Node root = createBST(elements, 0, elements.length-1);
		System.out.println("Printing BST with root ..."+root.val);

		inOrderTraversal(root);

	}
	

	
	public static Node createBST(int[] elements, int start, int end) {
		if(elements.length == 0 || start > end) {
			return null;
		}		
		int mid = (end + start ) / 2;
		Node n = new Node(elements[mid]);
		n.left = createBST(elements, start, mid-1);
		if (n.left != null) {
			n.left.parent = n;
		}
		n.right = createBST(elements, mid+1, end);
		if (n.right != null) {
			n.right.parent = n;
		}
		return n;
	}
	
	public static void inOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.println(node.val);
		inOrderTraversal(node.right);		
	}

}

