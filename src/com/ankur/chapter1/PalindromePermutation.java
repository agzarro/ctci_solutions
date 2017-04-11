package com.ankur.chapter1;

import java.util.Arrays;

public class PalindromePermutation {
	
	public static void main(String[] args) {
		System.out.println(isPalindromePermutation("Tact C oa"));
		System.out.println(isPalindromePermutation("Tact Coa"));
		System.out.println(isPalindromePermutation("Tact C oaz"));
		System.out.println(isPalindromePermutation("Tact C oazz"));

	}
	
	public static boolean isPalindromePermutation(String s) {
		char[] stringChars = s.toLowerCase().toCharArray();
		Arrays.sort(stringChars);
		String sortedString = new String(stringChars);
		int oddCharCount = 0;
		int i = 0;
		while(i < sortedString.length() - 1) {
			if (sortedString.charAt(i) == ' ') {
				i++;
				continue;
			}
			if (sortedString.charAt(i) != sortedString.charAt(i+1)) {
				oddCharCount++;
				if (oddCharCount > 1){
					return false;
				}
			} else {
				i++;
			}
			i++;
		}
		if (i < sortedString.length()) {
			oddCharCount++;
		}
		return oddCharCount <= 1;
		
	}

}
