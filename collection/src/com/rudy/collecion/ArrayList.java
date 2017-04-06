package com.rudy.collecion;


//�ײ�ʹ������ȥʵ��
public class ArrayList<T> implements List<T>{
	private int capacity = 10;
	private Object[] data;
	private int index;   //�±�
	public ArrayList() {
		super();
		data = new Object[capacity];
	}
	@Override
	public void add(T o) {
		if(index>=capacity) {   //capacity����
			capacity = capacity+(capacity>>1);  //����һ��
			Object[] newArray = new Object[capacity];
			System.arraycopy(data, 0, newArray, 0, data.length);
			data = newArray;   //�����øı�
		}
		data[index] = o;
		index++;
	}
	@Override
	public T get(int index) {
		if(0>index || index>capacity) throw new RuntimeException("�±�Խ��"+index);   //
		return (T) data[index];
	}
	@Override
	public void remove(T o) {
		//�鿴�Ƿ��и�Ԫ��
		for (int i = 0; i < data.length; i++) {
			if(data[i].equals(o)) {
				fastRemove(i);				//ɾ��
				break;
			}
		}
	}
	
	public void fastRemove(int index) {
		System.arraycopy(data, index+1, data, index, data.length-index-1);
		this.index--;  //��֤size����һ��
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
	
	
	
	//�������ξ���ϸ��
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
