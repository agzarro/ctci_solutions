package com.ankur.chapter3;

import java.util.Stack;

public class SortStack {
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> sort = new Stack<>();
	
	public static void main(String[] args) {
		
		SortStack s = new SortStack();
		s.push(4);
		s.push(41);
		s.push(14);
		s.push(13);
		s.push(1);
		s.push(7);
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(24);

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

		
	}
	
	public void push(int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}
		
		if (stack.peek() >= data) {
			stack.push(data);
			return;
		}
		
		sort.clear();
		while (!stack.isEmpty() && stack.peek() < data) {
			sort.push(stack.pop());
		}
		stack.push(data);
		while (!sort.isEmpty()) {
			stack.push(sort.pop());
		}
	}
	
	public int pop() {
		return stack.pop();
	}
	
	public int peek() {
		return stack.peek();
		
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
