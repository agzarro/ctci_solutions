package com.ankur.chapter5;

public class FlipBit {
	
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(24685));
		System.out.println(flip(24685));
		
	}
	
	private static int flip(int n) {
		
		int set1 = 0;
		int set2 = 0;
		int ans = 1;
		while (n > 0) {
			if ((n & 1) == 1) {
				set1++;
			} else {
				
				set2 = set1;
				set1 = 0;
			}
			ans = Math.max(ans, set1+set2+1);
			n >>>= 1;
		}
		return ans;
	}
	
	

}
