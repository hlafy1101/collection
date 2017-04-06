package com.rudy.collecion;

public class HashMap<K,V> implements Map<K, V>{
	
	
	
	//数组的链表
	private LinkedList<Entry<K,V>>[] data = (LinkedList<Entry<K, V>>[]) new LinkedList<?>[100];
	private int count;
	private int size;
	
	@Override
	public void put(K k, V v) {
		Entry entry = new Entry<K, V>(k, v);
		
	}

	@Override
	public V get(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
