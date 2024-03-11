package com.example.linkedlist.BasicDoubleLinkedList.BasicDoubleLinkedList;
/**
 * You must implement the following test case methods
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class BasicDoubleLinkedListTest_STUDENT {

	BasicDoubleLinkedList<String> linkedStringList;
	BasicDoubleLinkedList<Double> linkedDoubleList;
	StringComparator stringComparator = new StringComparator();

	@Before
	public void setUp() throws Exception {
		linkedDoubleList = new BasicDoubleLinkedList<>();
		linkedStringList = new BasicDoubleLinkedList<>();
		linkedDoubleList.addToFront(3.0);
		linkedDoubleList.addToFront(7.0);
		linkedStringList.addToEnd("Hello");
		linkedStringList.addToEnd("World");
	}

	@After
	public void tearDown() throws Exception {
		linkedStringList = null;
		linkedDoubleList = null;
		stringComparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedStringList.getSize());
		assertEquals(2,linkedDoubleList.getSize());

	}

	@Test
	public void testAddToEnd() {
		linkedStringList.addToEnd("Ali");
		linkedDoubleList.addToEnd(4.0);
		ArrayList<String> stringArrayList = linkedStringList.toArrayList();
		ArrayList<Double> doubleArrayList = linkedDoubleList.toArrayList();
		assertEquals(stringArrayList, linkedStringList.toArrayList());
		assertEquals(doubleArrayList, linkedDoubleList.toArrayList());
	}

	@Test
	public void testAddToFront() {
		linkedStringList.addToFront("First");
		linkedDoubleList.addToFront(1.0);
		ArrayList<String> stringArrayList = linkedStringList.toArrayList();
		ArrayList<Double> doubleArrayList = linkedDoubleList.toArrayList();
		assertEquals(stringArrayList, linkedStringList.toArrayList());
		assertEquals(doubleArrayList, linkedDoubleList.toArrayList());
	}

	@Test
	public void testGetFirst() {
		assertEquals("Hello", linkedStringList.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("World", linkedStringList.getLast());
	}

	@Test
	public void testIterator() {
		assertTrue("true", linkedStringList.iterator().hasNext());
	}

	@Test
	public void testRemove() {
		BasicDoubleLinkedList.Node temp = linkedStringList.remove("World", stringComparator);
		assertEquals("World", temp.data);
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("Hello", linkedStringList.retrieveFirstElement());
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("World", linkedStringList.retrieveLastElement());	}

	@Test
	public void testToArrayList() {
		ArrayList<String> stringArrayList = linkedStringList.toArrayList();
		ArrayList<Double> doubleArrayList = linkedDoubleList.toArrayList();
		assertEquals(stringArrayList, linkedStringList.toArrayList());
		assertEquals(doubleArrayList, linkedDoubleList.toArrayList());
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}

}
