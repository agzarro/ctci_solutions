package com.ankur.chapter5;

public class BinaryToString {
	
	public static void main(String[] args) {
		System.out.println(convert(0.625));
		
	}
	
	private static String convert(double num) {
		StringBuilder sb = new StringBuilder(31);
		sb.append('.');
		double d = 1;
		for (int i = 1; i < 31; i++) {
			d = d/2;
			if (num >= d) {
				sb.append(1);
				num -= d;
				if (num == 0) {
					break;
				}
			} else {
				sb.append(0);
			}
			
		}
		if (num > 0) {
			return "ERROR";
		}
		return sb.toString();
		
	}

}
