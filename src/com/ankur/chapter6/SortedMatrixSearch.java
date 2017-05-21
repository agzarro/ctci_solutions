package com.ankur.chapter6;

public class SortedMatrixSearch {
	
	public static void main(String[] args) {
		int[][] m = new int[][]{{1,2,3,4},{3,5,7,9}};
		System.out.println(findElement(m, 1));
		System.out.println(findElement(m, 2));
		System.out.println(findElement(m, 3));
		System.out.println(findElement(m, 4));
		System.out.println(findElement(m, 5));
		System.out.println(findElement(m, 7));
		System.out.println(findElement(m, 9));

		System.out.println(findElement(m, 11));
		System.out.println(findElement(m, 8));
		System.out.println(findElement(m, 6));

	}
	
	private static boolean findElement(int[][] matrix, int x) {
		if (matrix.length == 0) {
			return false;
		}
		int row = 0;
		int col = matrix[0].length-1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == x) {
				return true;
			}
			if (matrix[row][col] > x) {
				col--;
			} else {
				row++;
			}
		}
		return false;
		
		
	}

}
