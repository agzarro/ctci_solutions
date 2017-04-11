package com.ankur.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsPermutation {
	
	public static void main(String[] args) {
		System.out.println(isPermutation("abcd", "dbca"));
		System.out.println(isPermutation("Abcd", "abcd"));
		System.out.println(isPermutationLinearTime("abcd", "dbca"));
		System.out.println(isPermutationLinearTime("Abcd", "abcd"));
		
	}
	
	public static boolean isPermutation(String s1, String s2) {
		if(s1 == null || s2 == null)
			return false;
		if (s1.length() != s2.length()) 
			return false;
		String s1Sorted = sortString(s1);
		String s2Sorted = sortString(s2);
		for (int i = 0; i < s1Sorted.length(); i++) {
			if (s1Sorted.charAt(i) != s2Sorted.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPermutationLinearTime(String s1, String s2) {
		Map<Character, Integer> s1CharCount = getCharCount(s1);
		Map<Character, Integer> s2CharCount = getCharCount(s2);
		for (Map.Entry<Character, Integer> entry : s1CharCount.entrySet())
		     if(s2CharCount.get(entry.getKey()) != entry.getValue()){
		    	 return false;
		     }
		 return true;
	}
	
	private static Map<Character, Integer> getCharCount(String s) {
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if(charCount.containsKey(s.charAt(i))){
				charCount.put(s.charAt(i), charCount.get(s.charAt(i))+1);
			} else {
				charCount.put(s.charAt(i), 1);
			}
		}
		return charCount;
	}
	
	private static String sortString(String s) {
		char[] stringChars = s.toCharArray();
		Arrays.sort(stringChars);
		return new String(stringChars);
		
	}
}
