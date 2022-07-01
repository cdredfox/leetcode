/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc;

/**
 * 上下翻转二叉树
 *
 * @author fei.yang
 * @date 2022/6/16 - 9:11
 */
public class L156 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode parent = null;
        TreeNode right = null;
        TreeNode current = root;
        while (current != null) {
            TreeNode currentLeft = current.left;
            TreeNode currentRight = current.right;
            current.left = right;
            current.right = parent;
            parent = current;
            right = currentRight;
            current = currentLeft;
        }
        return parent;
    }

    public static void main(String[] args) {
        L156 l156 = new L156();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        TreeNode result = l156.upsideDownBinaryTree(root);
        System.out.println(result);
    }
}
