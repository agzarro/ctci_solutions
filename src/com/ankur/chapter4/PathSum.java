package com.ankur.chapter4;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
	
	public static void main(String[] args) {
		int[] elements = new int[]{1,2,3,4,5,6,7};
		System.out.println("Creating BST...");
		Node root = MinimalTree.createBST(elements, 0, elements.length-1);
		System.out.println(getPathCount(root, 10));
	}
		
	public static int getPathCount(Node root, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		incrementHashMap(map, 0, 1);
		return traversePaths(root, map, 0, sum);
	}
	
	private static int traversePaths(Node node, Map<Integer, Integer> pathSum, int runningSum, int targetSum) {
		if (node == null) {
			return 0;
		}
		runningSum += runningSum + node.val;
		incrementHashMap(pathSum, runningSum, 1);

		int sum = runningSum - targetSum;
		int pathCount = pathSum.containsKey(sum) ? pathSum.get(sum) : 0;
		pathCount += traversePaths(node.left, pathSum, runningSum, targetSum);
		pathCount += traversePaths(node.right, pathSum, runningSum, targetSum);
		
		incrementHashMap(pathSum, runningSum, -1);
		return pathCount;
	}

	private static void incrementHashMap(Map<Integer, Integer> map, int key, int count) {
		if (!map.containsKey(key)) {
			map.put(key, 0);
		}
		map.put(key, map.get(key) + count);

	}
}
