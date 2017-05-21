package com.ankur.chapter3;

public class StackMin {
	
	private static java.util.Stack<Integer> elements = new java.util.Stack<>();
	private static java.util.Stack<Integer> minStack = new java.util.Stack<>();
	
	
	public static void main(String[] args) {
		push(4);
		push(18);
		push(2);
		push(6);
		push(1);
		System.out.println(min());
		System.out.println(min());
		pop();
		System.out.println(min());
		pop();
		System.out.println(min());
		pop();
		System.out.println(min());
	}
	
	public static void push(int e) {
		if (elements.isEmpty()) {
			minStack.push(e);
		} else if (e < minStack.peek()) {
			minStack.push(e);
		}
		
		elements.push(e);
	}
	
	public static int pop() {
		int data = elements.pop();
		if(!minStack.isEmpty() && minStack.peek() == data) {
			minStack.pop();
		}
		return data;
	}
	
	public static int min() {
		return minStack.peek();
	}

}
