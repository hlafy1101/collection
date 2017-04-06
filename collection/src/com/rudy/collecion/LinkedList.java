package com.rudy.collecion;

public class LinkedList<T> implements List<T> {

	// 链首和链尾不在是具体的节点了

	private Node<T> head;

	private Node<T> tail;

	private int size;

	@Override
	public void add(T o) {
		Node node = new Node<T>(o, null); // 当前节点
		if (head == null) {
			head = node;
		} else {
			// 后序添加的元素，相当于给链尾去添加元素
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
		if (pre == head) { // 如果删除的刚好是第一个元素，那则将改变head的指针
			head = head.getNext();
			if (size == 1)
				tail = head; // let GC do it work,当只有一个元素时，做删除时，保证尾部指针释放
		} else if (node == tail) { // 如果是尾部的话
			pre.setNext(null);
			tail = pre;
		} else {
			pre.setNext(node.getNext());// 改变元素指针
			node.setNext(null);// 解除所占用的引用
		}
		size--;
	}

	@Override
	public void remove(T o) {
		// 找到这个元素
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
