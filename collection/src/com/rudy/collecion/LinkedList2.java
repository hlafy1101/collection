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
		Node<T> newNode = new Node<T>(o, null); // 把数据转换成一个节点
		if (head.getNext() == null) { // 判断出这个元素肯定为第一个元素
			head.setNext(newNode); // 将链首指向新的节点
		} else {
			tail.getNext().setNext(newNode); // 找到最后一个节点，将节点的引用指向新的节点
		}
		size++;
		tail.setNext(newNode);
	}

	@Override
	public T get(int index) { // 3 3
		if (index < 0 || index >= size)
			throw new RuntimeException("数组下标越界" + index);
		// 查找
		int temp = 0;
		Node<T> node = new Node<T>(null, null);
		node = head.getNext()==null ? head : head.getNext();   //如果链首不为空的话，找到第一个元素
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
		//找到该元素
		
		
		Node node = new Node();  //创建临时节点
		Node pre = new Node();
		node = head.getNext()==null ? head : head.getNext(); //链首不为空的时候，把第一个元素赋给node
		
		while(node!=null) {
			if(node.getData().equals(o)) {
				//找到该节点
				pre.setNext(node.getNext());  //把上一个节点的引用赋给当前节点的下一个节点
				size--;
				if(pre != head) {    //防止删除链首元素
					node.setNext(null);   //  let gc do it work
					node.setData(null);
				}
				
				break;  //找到节点后，退出while循环
			} else {
				pre = node;  //当前节点作为上一个节点
				node = node.getNext();//获取到下一个
				
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
