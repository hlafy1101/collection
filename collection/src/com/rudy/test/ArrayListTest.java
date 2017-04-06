package com.rudy.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rudy.collecion.ArrayList;
import com.rudy.collecion.Iterator;
import com.rudy.collecion.List;

public class ArrayListTest {

	
	@Test
	public void remove() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list.size());
		list.remove(3);
		assertEquals(4, list.size());
	}
	
	@Test
	public void test() {
		int i = 8;
		i = i + (i>>1);   //(8+8)/2    二元运算符优先级大于一元
		assertEquals(12, i);
	}

	
	@Test
	public void testIterator() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	
	
	@Test
	public void testAdd() {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(3, list.size());
	}
	
	

	@Test
	public void testAdd2() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		int data = list.get(1);
		assertEquals(2, data);
		assertEquals(3, list.size());
	}
	
	@Test
	public void testAdd1() {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		assertEquals(16, list.size());
	}
	
	@Test
	public void testJavaList() {
		java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
		list.add(1);
		int data = list.get(0);
		list.iterator();
		System.out.println(data);
	}
	
	@Test
	public void testGet() {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		Object o = list.get(2);
		int data = (int) o;
		assertEquals(3, o);
	}
	
	
}
