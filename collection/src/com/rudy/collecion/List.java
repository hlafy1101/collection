package com.rudy.collecion;


//����Java


//List list = new ArrayList();
//��ƽӿڣ�
//T  ��ʾ���ͻ����������������    A��B,C,D


//���еļ��϶��е�����

public interface List<T> {
	
	
	void add(T o);
	T get(int index);
	void remove(T o);
	void set(int index,T o);
	int size();
	Iterator<T> iterator();   //��ȡ������������
	
}
