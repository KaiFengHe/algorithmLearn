package com.hekaifeng.tree;

import java.util.*;

public class InOrderTraverse {

    public static List<Integer> inorderTraversal(TreeNode treeNode) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(treeNode, res);
        return res;
    }


    private static void inorder(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }

        inorder(treeNode.getLeft(), res);
        res.add(treeNode.getVal());
        inorder(treeNode.getRight(), res);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.setLeft(new TreeNode(4));
        left.setRight(new TreeNode(5));
        treeNode.setLeft(left);
        TreeNode right = new TreeNode(3);
        right.setLeft(new TreeNode(6));
        right.setRight(new TreeNode(7));
        treeNode.setRight(right);
        List<Integer> integers = inorderTraversal(treeNode);
        System.out.println(integers.toString());
    }
}
