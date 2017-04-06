package com.rudy.collecion;


//仿照Java


//List list = new ArrayList();
//设计接口，
//T  表示类型还不清楚，任意类型    A，B,C,D


//所有的集合都有迭代器

public interface List<T> {
	
	
	void add(T o);
	T get(int index);
	void remove(T o);
	void set(int index,T o);
	int size();
	Iterator<T> iterator();   //获取到迭代器对象
	
}
