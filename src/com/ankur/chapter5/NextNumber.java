package com.ankur.chapter5;

public class NextNumber {
	
	public static void main(String[] args) {
		System.out.println(next(17));
	}
	
	private static int next(int n) {
		int sum = n;
		int c0 = 0;
		while (c0 < 32 && (n & (1 << c0)) != 0) {
			c0++;
		}
		int c1 = c0 + 1;
		while (c1 < 32 && (n & (1 << c1)) > 0) {
			c1++;
		}
		// Set first non-trailing zero bit to 1
		sum = flipIthBit(sum, c0);
		
		// Set last c1 bits to 0;
		sum &= ~((1 << c1) - 1);
		
		// Add c1-c0-1 1s at the end
		sum |= (1 << (c1-c0-1)) - 1;
		return sum;
		
	}
	

	
	private static int flipIthBit(int n, int i) {
		if ((n & (1 << i)) >= 1) {
			return n &= ~(1 << i);
		}
		return n |= (1 << i);
	}

}
