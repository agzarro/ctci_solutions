package com.ankur.chapter2;

public class DeleteMiddleNode {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);		
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		Node n4 = new Node(2);
		n3.next = n4;
		Node n5 = new Node(1);
		n4.next = n5;
		Node n6 = new Node(2);
		n5.next = n6;
		Node n7 = new Node(4);
		n6.next = n7;
		removeMiddleNode(n1);
		n1.print();
				
	}
	
	public static void removeMiddleNode(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		
		Node slow = head;
		Node fast = head.next;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
		
	}

}
