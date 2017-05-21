package com.ankur.chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks<T> {
	
	private int stackCapacity;
	List<Stack<T>> stackSet = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		SetOfStacks<String> stackSet = new SetOfStacks<>(2);
		stackSet.push("a");
		stackSet.push("b");
		stackSet.push("c");
		stackSet.push("d");
		stackSet.push("e");
		stackSet.push("f");
		stackSet.push("g");
		System.out.println(stackSet.popAt(1));
		System.out.println(stackSet.popAt(2));
		System.out.println(stackSet.pop());
		System.out.println(stackSet.pop());
		System.out.println(stackSet.pop());
		stackSet.push("g");
		System.out.println(stackSet.pop());
		System.out.println(stackSet.pop());


	}
	
	public SetOfStacks(int capacity) {
		this.stackCapacity = capacity;
		Stack<T> stack = new Stack<>();
		stackSet.add(stack);
		
	}
	
	public void push(T data) {
		int stackNum = stackSet.size() - 1;
		if (stackSet.get(stackNum).size() == stackCapacity) {
			Stack<T> stack = new Stack<>();
			stack.push(data);
			stackSet.add(stack);
		} else {
			stackSet.get(stackNum).push(data);
		}		
		
	}
	
	public T pop() throws Exception {
		if (stackSet.isEmpty()) {
			throw new EmptyStackException();
		}
		int stackNum = stackSet.size()-1;
		T data = stackSet.get(stackNum).pop();
		if (stackSet.get(stackNum).isEmpty()) {
			stackSet.remove(stackNum);
		}
		return data;
	}
	
	public T peek() throws Exception {
		if (stackSet.isEmpty()) {
			throw new EmptyStackException();
		}
		return stackSet.get(stackSet.size()-1).peek();
	}
	
	public T popAt(int stackNum) {
		if (stackNum > stackSet.size()) {
			throw new EmptyStackException();
		}
		int stackSize = stackSet.size();
		int currentStack = stackNum-1;
		T data = stackSet.get(currentStack).pop();
		while (stackNum < stackSize) {
			int nextStack = currentStack+1;
			Stack<T> r = reverseStack(stackSet.get(nextStack));
			stackSet.get(currentStack).push(r.pop());
			stackSet.get(nextStack).clear();
			while (!r.isEmpty()) {
				stackSet.get(nextStack).push(r.pop());
			}
			stackNum++;
			currentStack++;			
		}
		if (stackSet.get(stackNum-1).isEmpty()) {
			stackSet.remove(stackNum-1);
		}
		
		return data;
	}
	
	private Stack<T> reverseStack(Stack<T> s) {
		Stack<T> r = new Stack<>();
		while (!s.isEmpty()) {
			r.push(s.pop());
		}
		return r;
	}

}
