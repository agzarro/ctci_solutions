package com.ankur.chapter4;

public class Successor {
	
	public static void main(String[] args) {
		
		int[] elements = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println("Creating BST...");
		Node root = MinimalTree.createBST(elements, 0, elements.length-1);
		System.out.println("Get successfor for:" + root.val);
		System.out.println(getSuccessor(root).val);
		System.out.println("Get successfor for:" + root.left.val);
		System.out.println(getSuccessor(root.left).val);
		System.out.println("Get successfor for:" + root.left.right.val);
		System.out.println(getSuccessor(root.left.right).val);
		System.out.println("Get successfor for:" + root.right.left.val);
		System.out.println(getSuccessor(root.right.left).val);
		System.out.println("Get successfor for:" + root.right.right.val);
		System.out.println(getSuccessor(root.right.right).val);
		System.out.println("Get successfor for:" + root.left.left.val);
		System.out.println(getSuccessor(root.left.left).val);
		
		
	}
	
	public static  Node getSuccessor(Node searchNode) {
		if (searchNode == null) {
			throw new IndexOutOfBoundsException();
		}
		
		Node ans = searchNode.right;
		if (ans == null) {
			if (searchNode.parent.left == searchNode) {
				return searchNode.parent;
			}
			Node p = searchNode.parent;
			while (p != null && p.right == null) {
				p = p.parent;
			}
			ans = p;
		}		
		if (ans == null) {
			return null;
		}
		Node c = ans.left;
		while (c != null) {
			ans = c;
			c = c.left;
		}
		return ans;
	} 
		

}
