/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc.tree;

import com.xuyao.lc.TreeNode;

/**
 * @author fei.yang
 * @date 2022/8/1 - 11:23
 */
public class TreeUtils {

    private static int idx=0;
    public static TreeNode buildTree(Integer[] treeNodes){
        TreeNode root=new TreeNode(treeNodes[0]);
        idx++;
        build(root,treeNodes);
        return root;
    }

    public static void build(TreeNode root,Integer[] treeNodes){
        if(root==null){
            return;
        }
        if(treeNodes.length > idx) {
            root.left = treeNodes[idx] == null ? null : new TreeNode(treeNodes[idx]);
        }

        if(treeNodes.length > idx+1) {
            root.right = treeNodes[idx + 1] == null ? null : new TreeNode(treeNodes[idx + 1]);
        }
        idx+=2;
        build(root.left,treeNodes);
        build(root.right,treeNodes);
    }

    public static void main(String[] args) {
        TreeNode root=TreeUtils.buildTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(root);
    }
}
