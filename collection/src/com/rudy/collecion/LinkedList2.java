package com.rudy.collecion;

public class LinkedList2<T> implements List<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LinkedList2() {
		super();
		head = new Node<T>(null, null);
		tail = new Node<T>(null, null);
	}

	@Override
	public void add(T o) {
		Node<T> newNode = new Node<T>(o, null); // ������ת����һ���ڵ�
		if (head.getNext() == null) { // �жϳ����Ԫ�ؿ϶�Ϊ��һ��Ԫ��
			head.setNext(newNode); // ������ָ���µĽڵ�
		} else {
			tail.getNext().setNext(newNode); // �ҵ����һ���ڵ㣬���ڵ������ָ���µĽڵ�
		}
		size++;
		tail.setNext(newNode);
	}

	@Override
	public T get(int index) { // 3 3
		if (index < 0 || index >= size)
			throw new RuntimeException("�����±�Խ��" + index);
		// ����
		int temp = 0;
		Node<T> node = new Node<T>(null, null);
		node = head.getNext()==null ? head : head.getNext();   //������ײ�Ϊ�յĻ����ҵ���һ��Ԫ��
		while (node != null) {
			if (temp == index) {
				return node.getData();
			} else {
				temp++;
				node = node.getNext();
			}
		}
		return null;
	}

	@Override
	public void remove(T o) {
		//�ҵ���Ԫ��
		
		
		Node node = new Node();  //������ʱ�ڵ�
		Node pre = new Node();
		node = head.getNext()==null ? head : head.getNext(); //���ײ�Ϊ�յ�ʱ�򣬰ѵ�һ��Ԫ�ظ���node
		
		while(node!=null) {
			if(node.getData().equals(o)) {
				//�ҵ��ýڵ�
				pre.setNext(node.getNext());  //����һ���ڵ�����ø�����ǰ�ڵ����һ���ڵ�
				size--;
				if(pre != head) {    //��ֹɾ������Ԫ��
					node.setNext(null);   //  let gc do it work
					node.setData(null);
				}
				
				break;  //�ҵ��ڵ���˳�whileѭ��
			} else {
				pre = node;  //��ǰ�ڵ���Ϊ��һ���ڵ�
				node = node.getNext();//��ȡ����һ��
				
			}
			
			
			
			
		}
		

	}

	@Override
	public void set(int index, T o) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterator<T> {
		private int count;
		@Override
		public boolean hasNext() {
			if(count<size) return true;
			return false;
		}
		@Override
		public T next() {
			Node node=new Node<T>();
			node.getData();
			count++;
			return (T) node.getData();
		}
	}
}
