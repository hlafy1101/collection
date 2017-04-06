package com.rudy.collecion;

public class LinkedList<T> implements List<T> {

	// ���׺���β�����Ǿ���Ľڵ���

	private Node<T> head;

	private Node<T> tail;

	private int size;

	@Override
	public void add(T o) {
		Node node = new Node<T>(o, null); // ��ǰ�ڵ�
		if (head == null) {
			head = node;
		} else {
			// ������ӵ�Ԫ�أ��൱�ڸ���βȥ���Ԫ��
			tail.setNext(node);
		}
		size++;
		tail = node;
	}

	@Override
	public T get(int index) {
		if (head == null)
			return null;
		Node temp = head;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return (T) temp.getData();
			} else {
				temp = temp.getNext();
			}
		}

		return null;
	}

	private void unlink(Node node, Node pre) {
		if (pre == head) { // ���ɾ���ĸպ��ǵ�һ��Ԫ�أ����򽫸ı�head��ָ��
			head = head.getNext();
			if (size == 1)
				tail = head; // let GC do it work,��ֻ��һ��Ԫ��ʱ����ɾ��ʱ����֤β��ָ���ͷ�
		} else if (node == tail) { // �����β���Ļ�
			pre.setNext(null);
			tail = pre;
		} else {
			pre.setNext(node.getNext());// �ı�Ԫ��ָ��
			node.setNext(null);// �����ռ�õ�����
		}
		size--;
	}

	@Override
	public void remove(T o) {
		// �ҵ����Ԫ��
		if (head == null)
			return;
		for (Node<T> pre = head, node = head; node != null; node = node.getNext()) {
			if (node.getData().equals(o)) {
				unlink(node, pre);
				return;
			}
			pre = node;
		}

	}

	@Override
	public void set(int index, T o) {
		if (head == null)
			return;
		Node temp = head;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				temp.setData(o);
				return;
			} else {
				temp = temp.getNext();
			}
		}
	}

	@Override
	public int size() {
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
			if (count < size)
				return true;
			return false;
		}

		@Override
		public T next() {
			T t = get(count);
			count++;
			return t;
		}

	}

}
