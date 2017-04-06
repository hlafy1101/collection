package com.rudy.collecion;


//底层使用数组去实现
public class ArrayList<T> implements List<T>{
	private int capacity = 10;
	private Object[] data;
	private int index;   //下标
	public ArrayList() {
		super();
		data = new Object[capacity];
	}
	@Override
	public void add(T o) {
		if(index>=capacity) {   //capacity超出
			capacity = capacity+(capacity>>1);  //扩容一半
			Object[] newArray = new Object[capacity];
			System.arraycopy(data, 0, newArray, 0, data.length);
			data = newArray;   //将引用改变
		}
		data[index] = o;
		index++;
	}
	@Override
	public T get(int index) {
		if(0>index || index>capacity) throw new RuntimeException("下标越界"+index);   //
		return (T) data[index];
	}
	@Override
	public void remove(T o) {
		//查看是否有该元素
		for (int i = 0; i < data.length; i++) {
			if(data[i].equals(o)) {
				fastRemove(i);				//删除
				break;
			}
		}
	}
	
	public void fastRemove(int index) {
		System.arraycopy(data, index+1, data, index, data.length-index-1);
		this.index--;  //保证size减少一个
	}
	
	@Override
	public void set(int index, T o) {
		data[index] = o;
	}
	@Override
	public int size() {
		return index;
	}
	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}
	
	
	
	//对外屏蔽具体细节
	private class ArrayListIterator implements Iterator<T> {
		private int count;
		@Override
		public boolean hasNext() {
			if(count<index) return true;
			return false;
		}
		@Override
		public T next() {
			T t = (T) data[count];
			count++;
			return t;
		}
	}
	
	
	
	
	
}
