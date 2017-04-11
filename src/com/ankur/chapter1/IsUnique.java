package com.ankur.chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {
	
	public static void main(String[] args) {
		System.out.println(isUnique("abcd"));
		System.out.println(isUnique("abcdA"));
		System.out.println(isUnique("abcdAa"));
		System.out.println(isUniqueWithoutAdditionalDS("abcd"));
		System.out.println(isUniqueWithoutAdditionalDS("abcdA"));
		System.out.println(isUniqueWithoutAdditionalDS("abcdAa"));
		System.out.println(isUniqueUsingSorting("abcd"));
		System.out.println(isUniqueUsingSorting("abcdA"));
		System.out.println(isUniqueUsingSorting("abcdAa"));
		
	}
	
	public static boolean isUnique(String s) {
		Set<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(charSet.contains(s.charAt(i))) {
				return false;
			} else {
				charSet.add(s.charAt(i));
			}
		}
		return true;
	}
	
	public static boolean isUniqueWithoutAdditionalDS(String s) {
		for (int i = 0; i < s.length(); i++) {
			 for (int j = i + 1; j < s.length(); j++) {
				 if(s.charAt(j) == s.charAt(i)) {
					 return false;
				 }
			 }
		}
		return true;
	}
	
	public static boolean isUniqueUsingSorting(String s) {
		char[] stringChars = s.toCharArray();
		Arrays.sort(stringChars);
		String sortedString = new String(stringChars);
		for (int i = 0; i < sortedString.length() - 1; i++) {
			if (sortedString.charAt(i+1) == sortedString.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
