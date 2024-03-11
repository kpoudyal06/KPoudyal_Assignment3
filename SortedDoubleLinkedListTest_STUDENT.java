package com.example.linkedlist.BasicDoubleLinkedList.BasicDoubleLinkedList;
/**
 * You must implement the following test case methods
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class SortedDoubleLinkedListTest_STUDENT {
	SortedDoubleLinkedList<String> linkedStringList1;
	SortedDoubleLinkedList<String> linkedStringList2;
	StringComparator stringComparator = new StringComparator();

	@Before
	public void setUp() throws Exception {
		linkedStringList1 = new SortedDoubleLinkedList<>(stringComparator);
		linkedStringList1.add("First");
		linkedStringList1.add("Second");


		linkedStringList2 = new SortedDoubleLinkedList<>(stringComparator);
		linkedStringList2.add("Ali");
		linkedStringList2.add("Kyle");
		linkedStringList2.add("Bob");
	}

	@After
	public void tearDown() throws Exception {
		linkedStringList1 = null;
		linkedStringList2 = null;
		stringComparator = null;
	}

	@Test
	public void testIterator() {
		assertEquals(true, linkedStringList1.iterator().hasNext());
	}

	@Test
	public void testRemove() {
		BasicDoubleLinkedList.Node temp = linkedStringList1.remove("First", stringComparator);
		assertEquals("First", temp.data);
	}

	@Test
	public void testAdd() {
		linkedStringList1.add("Hi");
		linkedStringList2.add("Hello");
		assertEquals(3, linkedStringList1.getSize());
		assertEquals(3, linkedStringList2.getSize());
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}

}