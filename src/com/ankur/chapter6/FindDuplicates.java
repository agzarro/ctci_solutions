package com.ankur.chapter6;

public class FindDuplicates {
	
	public static void main(String[] args) {
		int[] n = new int[]{1,2,3,1,3,1,5,1,54,7,8,9,98,9,54,32000,32000};
		printDupes(n);
	}
	
	private static void printDupes(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		byte[] bitSet = new byte[4001];
		for (int i = 0; i < nums.length; i++) {
			if (((bitSet[nums[i]/8] & (1 << nums[i] % 8)) != 0)) {
				System.out.println(nums[i]);
			} else {
				bitSet[nums[i]/8] |= 1 << (nums[i] % 8);
			}
		}
		
	}

}
