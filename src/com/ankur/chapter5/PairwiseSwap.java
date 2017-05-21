package com.ankur.chapter5;

public class PairwiseSwap {
	
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(15485));
		System.out.println(Integer.toBinaryString(swap(15485)));
		System.out.println(Integer.toBinaryString(pairwiseSwap(15485)));

	}
	
	private static int swap(int n) {
		int x = 3;
		int count = 15;
		while (count > 0) {
			if ((n & x) != x || (n & x) != 0) {
				n ^= x;
			}
			x <<= 2;
			count--;
		}
		return n;
		
	}
	
	private static int pairwiseSwap(int n) {
		int evenMask = 0xaaaaaaaa;
		int oddMask = 0x55555555;
		return ((n & oddMask) << 1) | ((n & evenMask) >>> 1);
	}

}
