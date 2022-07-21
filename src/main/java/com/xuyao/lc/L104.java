/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;

import apple.laf.JRSUIUtils;

/**
 * @author yangfei
 * @date 2022/7/21 - 21:03
 */
public class L104 {

    private int maxDeep=0;

    /**
     * 104 二叉树的最大深度，使用dfs方法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //dfs计算
         dfs(root,0);
         return maxDeep;
    }

    public void dfs(TreeNode node,int deep){
        //如果结点为空，则直接返回
        if(node==null){
            return;
        }
        //将深度+1
        deep++;
        //如果左右结点都为空，则代表到了叶子结点，和已经记录过的最大深度比较，谁最大就更新成谁
        if(node.left==null && node.right==null){
            maxDeep=Math.max(maxDeep,deep);
            return;
        }
        //继续往下遍历，左右子树
        dfs(node.left,deep);
        dfs(node.right,deep);
    }
    public static void main(String[] args) {
        L104 demo=new L104();
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);

        TreeNode node1=new TreeNode(20);
        root.right=node1;
        TreeNode node2=new TreeNode(15);
        TreeNode node3=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;

        System.out.println(demo.maxDepth(root));
    }
}
