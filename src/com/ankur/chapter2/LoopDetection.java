package com.ankur.chapter2;

public class LoopDetection {
	
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
		n7.next = n3;
		System.out.println(getFirstNodeInLoop(n1).data);
		
	}
	
	public static Node getFirstNodeInLoop(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) 
				break;
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
