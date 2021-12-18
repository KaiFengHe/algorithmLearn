package com.hekaifeng.liner;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {

    private Node<T> head;
    private int N;


    private class Node<T> {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


    private class LIterator implements Iterator {

        private Node n;

        public LIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        head.next = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        Node<T> node = head.next;
        for (int index = 0; index < i; index++) {
            node = node.next;
        }
        return node.item;
    }

    public void insert(T t) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        Node newNode = new Node(t, null);
        n.next = newNode;
        N++;
    }

    public void insert(int i, T t) {
        Node pre = head;
        for (int index = 0; index < i - 1; index++) {
            pre = pre.next;
        }
        Node curNode = pre.next;
        Node newNode = new Node(t, curNode);
        pre.next = newNode;
        N++;
    }

    public T remove(int i) {
        Node<T> pre = head;
        for (int index = 0; index < i - 1; index++) {
            pre = pre.next;
        }
        Node<T> curNode = pre.next;
        pre.next = curNode.next;
        N--;
        return curNode.item;
    }

    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node curNode) {
        if (curNode.next == null) {
            head.next = curNode;
            return curNode;
        }
        Node pre = reverse(curNode.next);
        pre.next = curNode;
        curNode.next = null;
        return curNode;
    }

}
