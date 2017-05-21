package com.ankur.chapter5;

public class Insertion {
	
	public static void main(String[] args) {
		System.out.println(insert(19, 1024, 2, 6));
	}
	
	public static int insert(int m, int n, int i, int j) {
		
		int clearBitMask = (1 << j+1) - 1;
		clearBitMask &= ~((1 << i+1) - 1);
		n &= ~clearBitMask;
		return n |(m << i);
		
	}

}
