package com.ankur.chapter3;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUsingStacks<T> {
	
	Stack<T> insertStack = new Stack<>();
	Stack<T> removalStack = new Stack<>();
	
	public static void main(String[] args) {
		QueueUsingStacks<String> q = new QueueUsingStacks<>();
		q.add("a");
		q.add("b");
		q.add("C");
		System.out.println(q.remove());
		q.add("d");
		System.out.println(q.remove());
		
	}
	
	public void add(T data) {
		insertStack.push(data);
	}
	
	public T remove() {
		if (insertStack.isEmpty()) {
			throw new NoSuchElementException();
		}
		if (!removalStack.isEmpty()) {
			return removalStack.pop();
		}
		while (!insertStack.isEmpty()) {
			removalStack.push(insertStack.pop());
		}
		return removalStack.pop();
		
	}
	
}
