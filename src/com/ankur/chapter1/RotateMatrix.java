package com.ankur.chapter1;

import java.util.Arrays;

public class RotateMatrix {
	
	public static void main(String[]rgs) {
		int[][] m = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}; 
		rotateMatrix(m);
		 Arrays.stream(m)
	        .forEach(
	            (row) -> {
	                System.out.print("[");
	                Arrays.stream(row)
	                .forEach((el) -> System.out.print(" " + el + " "));
	                System.out.println("]");
	            }
	        );	}
	
	public static void rotateMatrix(int[][] matrix) {
		
		for (int layer = 0; layer < matrix.length/2; ++layer) {
			int first = layer;
			int last = matrix.length - 1 - layer;
			
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i];
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				// bottom -> right
				matrix[last-offset][first] = matrix[last][last-offset];
				// right -> top
				matrix[last][last-offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top;
			}
		}
	}

}
