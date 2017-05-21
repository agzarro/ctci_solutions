package com.ankur.chapter2;

public class SumLists {
	
	static int carry = 0;
	
	public static void main(String[] args) {
		Node n1 = new Node(9);		
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		
		Node n4 = new Node(2);		
		Node n5 = new Node(1);
		n4.next = n5;
		Node n6 = new Node(9);
		n5.next = n6;
		Node n7 = new Node(4);
		n6.next = n7;
		sum(n1, n4).print();
	}
	
	public static Node sum(Node n1, Node n2) {
		if (n1 == null || n2 == null) {
			return n1 == null ? n2 : n1;
		}
		Node sumHead = null;
		Node cur = null;
		while (n1 != null && n2 != null) {
			Node n = getNodeSum(n1, n2);
			if (cur == null) {
				cur = n;
				sumHead = n;
				
			} else {
				cur.next = n;
				cur = n;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		
		while (n1 != null) {
			cur.next = getNodeSum(null, n2);;
			cur = cur.next;
			n1 = n1.next;
		}
		while (n2 != null) {
			cur.next = getNodeSum(null, n2);;
			cur = cur.next;
			n2 = n2.next;
		}
		if (carry > 0) {
			cur.next = new Node(1);
			carry = 0;
		}
		return sumHead;
		
	}
	
	private static Node getNodeSum(Node n1, Node n2) {
		int p1 = n1 == null ? 0: n1.data;
		int p2 = n2 == null ? 0 : n2.data;
		int sum = carry + p1 + p2;
		carry = sum / 10;
		sum = sum % 10;
		return new Node(sum);		
	}

}
