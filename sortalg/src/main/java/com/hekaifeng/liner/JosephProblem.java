package com.hekaifeng.liner;

public class JosephProblem {

    public static void main(String[] args) {
        Node<Integer> first = null;
        Node<Integer> pre = null;
        for (int i = 1; i <= 41; i++) {
            if (i == 1) {
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            Node<Integer> newNode = new Node<Integer>(i, null);
            pre.setNext(newNode);
            pre = newNode;
            if (i == 41) {
                pre.setNext(first);
            }
        }

        int count = 0;
        Node<Integer> tmpNode = first;
        Node<Integer> before = null;
        while (tmpNode != tmpNode.getNext()) {
            count++;
            if (count == 3) {
                before.setNext(tmpNode.getNext());
                System.out.println("删除元素:" + tmpNode.getItem());
                count = 0;
            } else {
                before = tmpNode;
            }
            tmpNode = tmpNode.getNext();
        }
        System.out.println("最后元素:"+tmpNode.getItem());
    }

}
