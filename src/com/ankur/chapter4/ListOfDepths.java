package com.ankur.chapter4;

import java.util.ArrayList;
import java.util.List;

public class ListOfDepths {
	
	public static void main(String[] args) {
		int[] elements = new int[]{1,2,3,4,5,6,7,8,9};
		Node root = MinimalTree.createBST(elements, 0, elements.length-1);
		List<List<Node>> list = getListOfDepths(root, new ArrayList<>(), 0);
		System.out.println(list.get(3).get(0).val);
		
	}
	
	public static List<List<Node>> getListOfDepths(Node node, List<List<Node>> list, int depth) {
		if (node == null) {
			return list;
		}
		if (list.size() == depth) {
			list.add(new ArrayList<>());
		}
		getListOfDepths(node.left, list, depth+1);
		list.get(depth).add(node);
		getListOfDepths(node.right, list, depth+1);
		return list;
		
	}

}
