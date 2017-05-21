package com.ankur.chapter2;

public class ListIntersection {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);		
		Node n2 = new Node(2);
		n1.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		Node n4 = new Node(4);
		n3.next = n4;
		Node n5 = new Node(5);
		n4.next = n5;
		Node n6 = new Node(6);
		n5.next = n6;
		Node n7 = new Node(7);
		n6.next = n7;
		
		Node n8 = new Node(8);		
		Node n9 = new Node(9);
		n8.next = n9;
		Node n10 = new Node(10);
		n9.next = n1;
		Node n11 = new Node(11);
		n10.next = n11;
		Node n12 = new Node(12);
		n11.next = n12;
		Node n13 = new Node(13);
		n12.next = n2;
		
		System.out.println(getIntersectingNode(n1, n8).data);
		
		
	}
	
	public static Node getIntersectingNode(Node n1, Node n2) {
		if (n1 == null || n2 == null) {
			return null;
		}
		
		int len1 = 0;
		Node t1 = n1;
		while (t1 != null) {
			t1 = t1.next;
			len1++;
		}
		
		int len2 = 0;
		Node t2 = n2;
		while (t2 != null) {
			t2 = t2.next;
			len2++;
		}
		
		while (len1 > len2) {
			n1 = n1.next;
			len1--;
		}
		while (len2 > len1) {
			n2 = n2.next;
			len2--;
		}
		
		while (n1 != null && n2 != null) {
			if (n1 == n2) {
				return n1;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return null;
	}

}
