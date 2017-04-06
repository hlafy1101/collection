package com.rudy.collecion;

public interface Map<K,V> {
	
	void put(K k,V v);
	
	
	V get(K k);
	
	V remove(K key);
	
	boolean containsKey(K key);
	
	int size();
	
}
