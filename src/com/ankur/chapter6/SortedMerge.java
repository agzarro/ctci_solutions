package com.ankur.chapter6;

import java.util.Arrays;

public class SortedMerge {
	
	public static void main(String[] args) {
		int[] a = new int[]{1,3,5,7,9,1,1,1,1};
		int[] b = new int[]{2,4,7,8};
		merge(a, 5, b, 4);
		System.out.println(Arrays.toString(a));
	}
	
	private static void merge(int[] a, int lenA, int[] b, int lenB) {
		if (a.length == 0 || b.length == 0) {
			return;
		}
		
		int i = lenA-1;
		int j = lenB-1;
		int index = a.length - 1;
		while(i >= 0 && j >= 0) {
			if (a[i] >= b[j]) {
				a[index] = a[i];
				i--;
			} else {
				a[index] = b[j];
				j--;
			}
			index--;
		}
		
		while (i >= 0) {
			a[index] = a[i];
			i--;
			index--;
		}
		
		while (j >= 0) {
			a[index] = b[j];
			j--;
			index--;
		}
	}

}
