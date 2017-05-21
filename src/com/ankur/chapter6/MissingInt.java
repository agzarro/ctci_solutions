package com.ankur.chapter6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

public class MissingInt {
	
	public static void main(String[] args) {
		try {
			System.out.println(generateMissingInt("res/nums.txt"));
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	private static int generateMissingInt(String filename) throws IOException {
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String num;
		BitSet set = new BitSet(Integer.MAX_VALUE);
		while ((num = br.readLine()) != null) {
			set.set(Integer.parseInt(num));
		}
		br.close();
		int search = 0;
		while (search <= Integer.MAX_VALUE) {
			if (!set.get(search)) {
				return search;
			}
			search++;
		}
		return -1;
	}
	
	private static int getMissingIntLimitedMemory(String filename, int memoryMB) throws IOException {
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		int buckets = (1000000000 / memoryMB) / 4;
		int bucketWidth = 1000000000 / buckets;
		int[] bucketCount = new int[buckets];
		String num;
		while((num = br.readLine()) != null) {
			int bucket = Integer.parseInt(num) / bucketWidth;
			bucketCount[bucket]++;
		}
		br.close();
		int missingBucket = 0;
		while (missingBucket <= buckets) {
			if (bucketCount[missingBucket] < bucketWidth) {
				break;
			}
			missingBucket++;
		}
		// Now use above approach to find missing int using bit vector
		return generateMissingInt(filename);
	}

}


