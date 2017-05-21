package com.ankur.chapter6;

public class SparseSearch {
	
	public static void main(String[] args) {
		String[] s = new String[]{"", "", "", "a", "", "ab", "bg", "", "", "", "c", "", "", "d", "e"};
		System.out.println(search(s, "ab"));
		
	}
	
	private static int search(String[] allStrings, String searchString) {
		if (allStrings.length == 0 || searchString.length() == 0) {
			return -1;
		}
		
		int start = 0;
		int end = allStrings.length - 1;
		int mid = (start + end) / 2;
		while (start <= end) {
			mid = (start + end) / 2;
			if (allStrings[mid].length() == 0) {
				int leftSearch = mid - 1 < start ? start : mid -1;
				int rightSearch = mid + 1 > end ? end : mid + 1;
				while (true) {
					if (allStrings[leftSearch].length() != 0) {
						mid = leftSearch;
						break;
					}
					if (allStrings[rightSearch].length() != 0) {
						mid = rightSearch;
						break;
					}
					leftSearch--;
					rightSearch++;		
					if (leftSearch < start || rightSearch > end) {
						return -1;
					}
				}
				
			}
			if (allStrings[mid].equals(searchString)) {
				return mid;
			}
			if (allStrings[mid].compareTo(searchString) > 0) {
				end = mid - 1;
			} else {

				start = mid + 1;
			}
			
		}
		return -1;

	}

}
