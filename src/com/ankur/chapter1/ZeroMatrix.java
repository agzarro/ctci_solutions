package com.ankur.chapter1;

import java.util.Arrays;

public class ZeroMatrix {
	
	public static void main(String[] args) {
		int[][] m = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,0,12},{13,14,15,16}}; 
		zeroMatrix(m);
		 Arrays.stream(m)
	        .forEach(
	            (row) -> {
	                System.out.print("[");
	                Arrays.stream(row)
	                .forEach((el) -> System.out.print(" " + el + " "));
	                System.out.println("]");
	            }
	        );	
	}
	
	public static void zeroMatrix(int[][] matrix) {
		boolean rowHasZero = false;
		boolean columnHasZero = false;
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				rowHasZero = true;
			}			
		}
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				columnHasZero = true;
			}			
		}
		
		if (rowHasZero || columnHasZero) {
			matrix[0][0] = 0;
		}
		
		for (int i = 1; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for (int i = 1; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
	}

}
