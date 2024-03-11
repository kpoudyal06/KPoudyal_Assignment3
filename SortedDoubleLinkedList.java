package com.example.linkedlist.BasicDoubleLinkedList.BasicDoubleLinkedList;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparableObject) {
        super();
        comparator = comparableObject;
    }

    public void add(T data) {
        Node tempNode = new Node(data);
        Node currentNode = head;
        if (size == 0) {
            head =  tempNode;
            tail = tempNode;
            size++;
        }
        else if (size == 1) {
            if (comparator.compare(data,(T)currentNode.data) < 0 || comparator.compare(data,(T)currentNode.data) == 0) {
                super.addToFront(data);
            }
            if (comparator.compare(data,(T)currentNode.data) > 0) {
                super.addToEnd(data);
            }
            size++;
        }
        else {
            while (comparator.compare((T)currentNode.data, data) < 0) {
                if (currentNode.nextNode == null) {
                    currentNode.nextNode = tempNode;
                    tempNode.prevNode = tail;
                    tail = tempNode;
                    size++;
                }
                if (comparator.compare(data,(T)currentNode.data) < 0) {
                    tempNode.nextNode = currentNode;
                    tempNode.prevNode = currentNode.prevNode;
                    currentNode.prevNode.nextNode = tempNode;
                    currentNode.prevNode = tempNode;
                    size++;
                }
                currentNode = currentNode.nextNode;
            }
        }
    }

    public void addToFront(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    public void addToEnd(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    public ListIterator<T> iterator() {
        return super.iterator();
    }

    public Node remove(T data, Comparator<T> comparator) {
        return super.remove(data, comparator);
    }
}
