package com.ankur.chapter5;

public class DrawLine {
	
	public static void main(String[] args) {
		
	}
	
	private static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int index = (width/8) * y;
		int bitsToSet = x2 - x1;
		int startIndex = index + (x1/8);
		int endIndex = index + (x2/8);
		screen[startIndex] |= (1 << (8 - (x1 % 8)) -1);
		screen[endIndex] &= (1 << (8 - (x1 % 8)) -1);

	}

}
