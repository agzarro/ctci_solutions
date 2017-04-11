package com.ankur.chapter2;

import java.util.HashSet;
import java.util.Set;

class Node {
	public int data;
	public Node next;
	
	public Node(int d) {
		this.data = d;
	}
	
	public void print() {
		Node n = this;
		while(n!=null) {
			System.out.println(n.data);
			System.out.println("->");
			n = n.next;			
		}
	}
}

public class RemoveDupes {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);		
		Node n2 = new Node(1);
		n1.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		Node n4 = new Node(2);
		n3.next = n4;
		Node n5 = new Node(1);
		n4.next = n5;
		Node n6 = new Node(4);
		n5.next = n6;
		Node n7 = new Node(4);
		n6.next = n7;
		removeDupes(n1);
		Node n = n1;
		n1.print();
	}
		
	public static void removeDupes(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		
		Set<Integer> nums = new HashSet<>();
		
		Node prev = head;
		nums.add(prev.data);
		Node cur = head.next;
		while (cur != null) {
			if(nums.contains(cur.data)) {
				prev.next = cur.next;
				cur = cur.next;
				
			} else {
				nums.add(cur.data);
				prev = cur;
				cur = cur.next;
			}
		}
	}

}
