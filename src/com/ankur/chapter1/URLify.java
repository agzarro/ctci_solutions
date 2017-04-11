package com.ankur.chapter1;

public class URLify {
	
	public static void main(String[] args) {
		System.out.println(generateURL("Mr John Smith    ".toCharArray(), 13));
	}
	
	public static String generateURL(char[] c, int length) {
		int j = c.length-1;
		for (int i = length-1; i >= 0; i--) {
			if(c[i] == ' ') {
				c[j] = '0';
				j--;
				c[j] = '2';
				j--;
				c[j] = '%';
				j--;
			} else {
				c[j] = c[i];
				j--;
			}
		}
		return new String(c);
	}

}
