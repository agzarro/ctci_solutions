package com.ankur.chapter2;

public class Palindrome {
	
	public static void main(String[] args) {
			Node n1 = new Node(1);		
			Node n2 = new Node(3);
			n1.next = n2;
			Node n3 = new Node(3);
			n2.next = n3;
			Node n4 = new Node(2);
			n3.next = n4;
			Node n5 = new Node(3);
			n4.next = n5;
			Node n6 = new Node(3);
			n5.next = n6;
			Node n7 = new Node(1);
			n6.next = n7;
			System.out.println(isPalindrome(n1));
			
			Node n8 = new Node(1);		
			Node n9 = new Node(3);
			n8.next = n9;
			Node n10 = new Node(3);
			n9.next = n10;
			Node n11 = new Node(3);
			n10.next = n11;
			Node n12 = new Node(3);
			n11.next = n12;
			Node n13 = new Node(1);
			n12.next = n13;
			System.out.println(isPalindrome(n8));
	}
	
	public static boolean isPalindrome(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		Node slow = head;
		Node fast = head.next;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node middle = slow;
		Node prev = slow;
		Node cur = slow.next;
		while(cur != null) {
			Node nxt = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nxt;
		}
		while (head!=middle) {
			if(head.data != prev.data)
				return false;
			head = head.next;
			prev = prev.next;
			
		}
		return true;
	}

}
