package com.ankur.chapter6;

public class SortedSearchNoSize {
	
	public static void main(String[] args) {
		Listy list = new Listy();
		System.out.println(search(list, 1));
		System.out.println(search(list, 2));
		System.out.println(search(list, 3));
		System.out.println(search(list, 4));
		System.out.println(search(list, 5));
		System.out.println(search(list, 6));
		System.out.println(search(list, 7));
		System.out.println(search(list, 8));
		System.out.println(search(list, 9));

	}
	
	private static int search(Listy list, int x) {
		int start = 0;
		int end = findSize(list);
		int mid = (start + end) / 2;
		while (start <= end) {
			mid = (start + end) /2 ;
			if (list.elementAt(mid) == x) {
				return mid;
			}
			if (list.elementAt(mid) < x) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
		
		
	}
	
	private static int findSize(Listy list) {
		if (list.elementAt(0) == -1) {
			return 0;
		}
		int size = 1;
		while(list.elementAt(size) != -1) {
			size *= 2;
		}
		int start = size/2;
		int end = size;
		while(start <= end) {
			int mid = (start + end) / 2;
			if (list.elementAt(mid) == -1) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

}

class Listy {
	
	private int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
	
	public Listy() {
		
	}
	
	public int elementAt(int i) {
		if (i < 0 || i >= nums.length) {
			return -1;
		}
		return nums[i];
	}
}