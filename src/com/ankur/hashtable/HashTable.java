package com.ankur.hashtable;


public class HashTable<K, V> {

	private int tableSize = 16;
	private V[] table =  (V[]) new Object[tableSize];

	public void insert(K key, V value) {
		table[hashIndex(key)] = value;
	}

	public boolean exists(K key) {
		return table[hashIndex(key)] != null;
	}

	public V get(K key) {
		if (exists(key)) {
			return (V) table[hashIndex(key)];
		} else {
			System.out.println("Key does NOT exist");
			return null;
		}
	}

	private int hashIndex(K key) {
		return hash(key) % tableSize;
	}

	private int hash(K key) {
		if(key == null)
			return -1;
		
		int hash = 7;
		String keyStr = (String) key;
		for (int i = 0; i < keyStr.length(); i++) {
    		hash = hash*31 + keyStr.charAt(i);
		}
		return hash;
	}

	public static void main(String[] args) {
		HashTable<String, String> myDict = new HashTable<String, String>();
		myDict.insert("100", "ankur");
		String out = myDict.get("100");
		System.out.println(out);
		System.out.println(myDict.get("15"));
	}

}

