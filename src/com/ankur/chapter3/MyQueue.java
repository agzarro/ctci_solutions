package com.ankur.chapter3;

public class MyQueue<T> {
	
	private QueueNode first;
	private QueueNode last;
	
	private class QueueNode {
		private T data;
		private QueueNode next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	public MyQueue() {
		
	}
	
	public void add(T data) {
		QueueNode n = new QueueNode(data);
		if (last == null) {
			first = n;
		} else {
			last.next = n;
		}
		last = n;
	}
	
	public T remove() throws Exception {
		if (first == null) {
			throw new Exception("Queue empty");
		}
		T data = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() throws Exception {
		if (first == null) {
			throw new Exception("Queue empty");
		} else {
			return first.data;
		}
	}
	
	public boolean isEmpty() {
		return first == null;
	}

}
