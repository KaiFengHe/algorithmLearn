package com.hekaifeng.liner;

public class CycleListTest {

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
        // 构建环
        node7.next = node2;

        boolean isCycle = isCycle(node1);
        System.out.println(isCycle);

        Node entrance = getEntrance(node1);
        System.out.println(entrance.item);

    }

    private static boolean isCycle(Node<Integer> first) {
        Node fast = first;
        Node slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    private static Node getEntrance(Node<Integer> first) {
        Node fast = first;
        Node slow = first;

        // 首次相遇
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.equals(fast)) {
                break;
            }
        }

        // 慢指针和临时变量相同速度走
        Node tempNode = first;
        while (!tempNode.equals(slow)){
            tempNode = tempNode.next;
            slow = slow.next;
        }
        return tempNode;
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
