package com.ankur.chapter5;

public class Conversion {

	public static void main(String[] args) {
		System.out.println(conversionBits(1600, 8));
	}
	
	private static int conversionBits(int n, int m) {
		int x = n ^ m;
		int count = 0;
		while (x > 0) {
			count += (x & 1);
			x >>>= 1;
		}
		return count;
	}
}
