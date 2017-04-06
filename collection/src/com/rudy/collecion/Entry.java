package com.rudy.collecion;

public class Entry<K,V> {
	
	private K k;
	private V v;
	
	public Entry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Entry(K k, V v) {
		super();
		this.k = k;
		this.v = v;
	}
	public K getK() {
		return k;
	}
	public void setK(K k) {
		this.k = k;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
	
	
	
	
	
}
