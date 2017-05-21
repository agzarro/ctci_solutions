package com.ankur.chapter4;

public class CheckSubtree {
	
	public static void main(String[] args) {
		int[] elements = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println("Creating BST...");
		Node root = MinimalTree.createBST(elements, 0, elements.length-1);
		System.out.println(checkSubtree(root, root.left));
		System.out.println(checkSubtree(root.left, root));
	}
	
	public static boolean isSubtree(Node t1, Node t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		
		if (t1 != null && t2 != null && t1.val == t2.val) {
			return isSubtree(t1.left, t2.left) && isSubtree(t1.right, t2.right);
		} else {
			return false;
		}
		
	}
	
	public static boolean checkSubtree(Node t1, Node t2) {		
		if (t1 == null || t2 == null) {
			return false;
		}
		
		if (t1.val == t2.val) {
			if(isSubtree(t1, t2)) {
				return true;
			}
		}
		return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);				
	}

}
