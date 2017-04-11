package com.ankur.chapter2;

public class KthToLast {
	
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

		System.out.println(getKthToLastElement(n1, 0).data);
		System.out.println(getKthToLastElement(n1, 1).data);
		System.out.println(getKthToLastElement(n1, 2).data);
		System.out.println(getKthToLastElement(n1, 3).data);
		System.out.println(getKthToLastElement(n1, 4).data);
		System.out.println(getKthToLastElement(n1, 5).data);
		System.out.println(getKthToLastElement(n1, 6).data);
		System.out.println(getKthToLastElement(n1, 7).data);
	}
	
	
	public static Node getKthToLastElement(Node head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node n = head;
		int listLength = 0;
		while (n != null) {
			listLength++;
			n = n.next;
		}
		int positionFromBeginning = listLength - k - 1;
		Node retVal = head;
		while (positionFromBeginning > 0) {
			retVal = retVal.next;
			positionFromBeginning--;
		}
		
		return retVal;
	}

}
