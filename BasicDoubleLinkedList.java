package com.example.linkedlist.BasicDoubleLinkedList.BasicDoubleLinkedList;

import java.util.*;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
    protected Node head;
    protected Node tail;
    protected int size;

    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addToFront(T data) {
        Node temp = new Node(data);

        if (getSize() == 0) {
            head = temp;
            tail = temp;
        }
        else {
            head.prevNode = temp;
            temp.nextNode = head;
            head = temp;
        }
        size++;
    }
    public void addToEnd(T data) {
        Node temp = new Node(data);

        if (getSize() == 0) {
            head = temp;
            tail = temp;
        }
        else {
            tail.nextNode = temp;
            temp.prevNode = tail;
            tail = temp;
        }
        size++;
    }

    public T getFirst() {
        if (getSize() == 0) {
            return null;
        }

        else return (T) head.data;
    }

    public T getLast() {
        if (getSize() == 0) {
            return null;
        }
        else return (T) tail.data;
    }

    public int getSize() {
        return size;
    }

    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    public Node remove(T targetData, Comparator<T> comparator) {
        Node currentNode = head;
        while (currentNode != null) {
            if (comparator.compare((T) currentNode.data, targetData) == 0) {
               Node tempNode = currentNode;
                if (currentNode == head) {
                    head = currentNode.nextNode;
                    head.prevNode = null;
                    size--;
                    return tempNode;
                }
                if (currentNode == tail) {
                    tail = currentNode.prevNode;
                    tail.nextNode = null;
                    size--;
                    return tempNode;
                }
                currentNode.prevNode.nextNode = currentNode.nextNode;
                currentNode.nextNode.prevNode = currentNode.prevNode;
                size--;
                return tempNode;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    public T retrieveFirstElement() {
        T temp = (T) head.data;
        if (getSize() == 0) {
            return null;
        }
        if (getSize() == 1) {
            head = null;
            tail = null;
            return temp;
        }

        head = head.nextNode;
        head.prevNode = null;
        return temp;
    }

    public T retrieveLastElement() {
        T temp = (T) tail.data;
        if (getSize() == 0) {
            return null;
        }
        if (getSize() == 1) {
            head = null;
            tail = null;
            return temp;
        }
        tail = tail.prevNode;
        tail.nextNode = null;
        return temp;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<T>();
        ListIterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    public class DoubleLinkedListIterator implements ListIterator<T> {

        protected Node current;
        protected Node prev;
        public DoubleLinkedListIterator() {
            current = head;
            prev = null;
        }

        @Override
        public boolean hasNext() {
            if (current.nextNode != null) return true;
            else return false;
        }

        @Override
        public boolean hasPrevious() {
            if (prev.prevNode != null) return true;
            else return false;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            prev = current;
            current = current.nextNode;
            return (T) current.data;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            current = prev;
            prev = prev.prevNode;
            return (T) prev.data;
        }

        @Override
        public int nextIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(Object o) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(Object o) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }

    public class Node<T> {

        protected T data;
        protected Node prevNode;
        protected Node nextNode;
        public Node(T dataNode) {
            data = dataNode;
        }
    }
}
