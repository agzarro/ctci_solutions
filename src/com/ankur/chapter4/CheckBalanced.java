package com.ankur.chapter4;

public class CheckBalanced {
	
	public static void main(String[] args) {
		
		int[] elements = new int[]{1,2,3,4,5,6,7,8,9};
		Node root = MinimalTree.createBST(elements, 0, elements.length-1);
		System.out.println(isBalanced(root));
		
	}
	
	public static boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}
		
		int left = depth(node.left, 1);
		int right = depth(node.right, 1);
		return Math.abs(left-right) < 2 && isBalanced(node.left) && isBalanced(node.right);
		
	}
	
	public static int depth(Node node, int depth) {
		if (node == null) {
			return depth;
		}
		
		int left = depth(node.left, depth+1);
		int right = depth(node.right, depth+1);
		return left > right ? left : right;
		
	}

}
