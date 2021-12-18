package com.hekaifeng.liner;

/**
 * 快慢指针
 */
public class FastSlowPoint {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1, null);
        Node<Integer> node2 = new Node<>(2, null);
        Node<Integer> node3 = new Node<>(3, null);
        Node<Integer> node4 = new Node<>(4, null);
        Node<Integer> node5 = new Node<>(5, null);
        Node<Integer> node6 = new Node<>(6, null);
        Node<Integer> node7 = new Node<>(7, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Integer mid = getMid(node1);
        System.out.println(mid);
    }


    private static Integer getMid(Node<Integer> first) {
        Node<Integer> fast = first;
        Node<Integer> slow = first;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    private static class Node<T> {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
