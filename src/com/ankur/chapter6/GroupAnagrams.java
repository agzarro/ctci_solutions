package com.ankur.chapter6;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
	
	public static void main(String[] args) {
		String[] s = new String[]{"iceman", "taco cat", "cinema", "cat taco"};
		System.out.println(Arrays.toString(sort(s)));
	}
	
	private static String[] sort(String[] s) {
		if (s.length == 0) {
			return null;
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String str : s)
		{
			addToMap(map, str);
		}
		List<String> sortedString = new ArrayList<>();
		for (Entry<String, List<String>> e : map.entrySet()) {
			sortedString.addAll(e.getValue());
		}
			
		return sortedString.toArray(new String[sortedString.size()]);
		}
	
	private static void addToMap(Map<String,List<String>> map, String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		String key = c.toString();
		if (map.containsKey(key)) {
			map.get(key).add(s);
		} else {
			List<String> list = new ArrayList<>();
			list.add(s);
			map.put(key, list);
		}
		
	}

}
