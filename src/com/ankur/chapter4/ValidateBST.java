package com.ankur.chapter4;

public class ValidateBST {
	
	public static void main(String[] args) {
		int[] elements = new int[]{1,2,3,4,5,6,7,8,9};
		Node root = MinimalTree.createBST(elements, 0, elements.length-1);
		System.out.println(isBST(root));
		int[] elements2 = new int[]{1,2,3,4,5,9,7,8,9};
		Node root2 = MinimalTree.createBST(elements2, 0, elements2.length-1);
		System.out.println(isBST(root2));
	}
	
	private static Integer c = null;
	
	public static boolean isBST(Node node) {
		if (node == null) {
			return true;
		}
		
		isBST(node.left);
		if (c == null) {
			c = node.val;
		} 
		if (node.val < c) {
			return false;
		}
		c = node.val;
		isBST(node.right);
		return true;
		
	}

}
