package com.ankur.chapter3;

import java.util.EmptyStackException;

public class ThreeStacks<T> {
	
	public static void main(String[] args) {
		ThreeStacks<String> myStack = new ThreeStacks<>(12);
		myStack.push(3, "ankur");
		System.out.println(myStack.pop(3));
		myStack.push(3, "ankur2");
		myStack.push(3, "ankur3");
		myStack.push(3, "ankur4");
		System.out.println(myStack.pop(3));
		System.out.println(myStack.pop(3));
		System.out.println(myStack.pop(3));

	}

	T[] stack;
	private  int topPosition[];		
	private int stackCapacity;
	
	public ThreeStacks(int capacity) {
		stack = (T[]) new Object[capacity];
		topPosition = new int[3];
		stackCapacity = capacity / 3;
		topPosition[0] = 0;
		topPosition[1] = stackCapacity;
		topPosition[2] = stackCapacity * 2;
	}
		
	public void push(int stackNum, T data) {
		if (stackNum > 3) {
			throw new IndexOutOfBoundsException();
		}
		if (!isStackFull(stackNum)) {
			topPosition[stackNum-1]++;
			stack[topPosition[stackNum-1]] = data;			
		} else {
			throw new StackOverflowError();
		}		
	}
	
	public T pop(int stackNum) {
		if (stackNum > 3) {
			throw new IndexOutOfBoundsException();
		}
		if (topPosition[stackNum-1] == stackCapacity * (stackNum-1)) {
			throw new EmptyStackException();
		}
		T data = stack[topPosition[stackNum-1]];
		topPosition[stackNum-1]--;
		return data;
	}
	
	public T peek(int stackNum) {
		if (stackNum > 3) {
			throw new IndexOutOfBoundsException();
		}
		return stack[topPosition[stackNum-1]];
	}
	public boolean isStackFull(int stackNum) {
		if (stackNum > 3) {
			throw new IndexOutOfBoundsException();
		}
		
		return ((stackCapacity * stackNum) - 1 - topPosition[stackNum-1]) == 0;			
	}
		

}
