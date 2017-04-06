package com.rudy.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rudy.collecion.Iterator;
import com.rudy.collecion.LinkedList;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list.get(4));
		assertEquals(3, list.get(3).intValue());
	}
	
	
	
	@Test
	public void test3() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);   
		list.remove(1);
		list.add(2);
		list.add(3);
		list.set(1, 4);
		assertEquals(4, list.get(1).intValue());
	}
	
	
	@Test
	public void test1() {
		java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
	}
	
	
	@Test
	public void iterator() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		
		for(Iterator<Integer> iterator = list.iterator();iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

}
