package com.ankur.chapter3;

public class MyStack<T> {
	
	StackNode top;
	
	private class StackNode {
		private T data;
		private StackNode next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	public void add(T data) {
		StackNode n = new StackNode(data);
		n.next = top;
		top = n;
	}
	
	public T pop() throws Exception {
		if (top == null) {
			throw new Exception("Stack empty");
		}
		T data = top.data;
		top = top.next;
		return data;
	}
	
	public T peek() throws Exception {
		if (top == null) {
			throw new Exception("Stack empty");
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}

}
