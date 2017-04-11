package com.ankur.chapter1;

public class OneAway {
	
	public static void main(String[] args) {
		System.out.println(isOneAway("ple", "pale"));
		System.out.println(isOneAway("pales", "pale"));
		System.out.println(isOneAway("pale", "bale"));
		System.out.println(isOneAway("pale", "bake"));
		System.out.println(isOneAway("sale", "ale"));		
	}
	
	public static boolean isOneAway(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		int edits = Math.abs((s1.length() - s2.length()));
		if (Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}
		String shorterString = s1;
		String longerString = s2;
		if (s1.length() > s2.length()) {
			shorterString = s2;
			longerString = s1;
			
		}
		boolean skip = edits > 0;
		int j = 0;
		for (int i = 0; i < shorterString.length(); i++) {
			if(shorterString.charAt(i) != longerString.charAt(j)) {				
				if (skip) {
					i--;
					skip = false;
				} else {
					edits++;
				}
			}			
			j++;		
		}
		
		return edits <= 1;
		
	}

}
