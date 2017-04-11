package com.ankur.chapter1;

public class StringCompression {
	
	public static void main(String[] args) {
		System.out.println(getCompressedString("aaaabccdddeff"));
	}
	
	public static String getCompressedString(String s) {
		if(s == null || s.length() <= 2) {
			return s;
		}
		char prevChar = s.charAt(0);
		int charCount = 1;
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == prevChar) {
				charCount++;
			} else {
				sb.append(prevChar);
				sb.append(charCount);
				prevChar = s.charAt(i);
				charCount = 1;
			}
		}
		sb.append(prevChar);
		sb.append(charCount);
		if (sb.length() >= s.length()) {
			return s;
		} else {
			return sb.toString();
		}
	}

}
