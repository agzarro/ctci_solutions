package com.ankur.chapter6;

public class RotatedSearch {
	
	public static void main(String[] args) {
		int[] x = new int[]{15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(search(x, 16));
		
	}
	
	private static int search(int[] nums, int x) {
		if (nums.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = nums.length - 1;
		int mid = (start + end ) / 2;
		while(nums[mid] != x && start<=end) {
			if (nums[start] <= nums[end]) {
				if (nums[mid] > x) {
					end = mid -1;
				} else {
					start = mid+1;
				}
			} else {
				if (x > nums[end]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			mid = (start + end ) / 2;
		}
		return nums[mid] == x ? mid : -1;
		
	}

}
