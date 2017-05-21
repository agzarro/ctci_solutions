package com.ankur.chapter6;

public class StreamRank {
		
	private static Node root;
		
	
	public static void main(String[] args) {
		track(5);
		track(3);
		track(3);
		track(1);

		track(7);
		track(2);
		System.out.println(getRankOfNumber(3));
		System.out.println(getRankOfNumber(5));
		System.out.println(getRankOfNumber(7));
		System.out.println(getRankOfNumber(4));


	}
	
	private static int getRankOfNumber(int x) {
		if (root == null) {
			return -1;
		}
		return getRank(root, x);
	}
	
	private static int getRank(Node n, int x) {
		if (n == null) {
			return -1;
		}
		if (n.val == x) {
			return n.left.size;
		}
		if (x < n.val) {
			return getRank(n.left, x);
		} else {
			return n.left.size + 1 + getRank(n.right, x);
		}
	}
	
	private static void track(int x) {
		if (root == null) {
			root = new Node(x);
		} else {
			insert(root, x);
		}
		
	}
	
	private static void insert(Node n, int x) {
		if (n == null) {
			return;
		}
		
		if (n.val == x) {
			return;
		}  
		if (x < n.val) {
			n.size++;
			if (n.left != null) {				
				insert(n.left, x);
			} else {
				n.left = new Node(x);
			}
		} else {
			if (n.right != null) {
				insert(n.right, x);
			} else {
				n.right = new Node(x);
			}
			
		}
	}

}

class Node {
	public int val;
	public Node left;
	public Node right;
	public int size;
	
	public Node(int x) {
		this.val = x;
	}
}