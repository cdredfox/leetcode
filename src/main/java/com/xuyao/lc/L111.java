/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;

/**
 * @author yangfei
 * @date 2022/7/21 - 21:15
 */
public class L111 {

    private int minDeep=0;

    /**
     * 111 二叉树的最小深度，思路同最大深度，都是用dfs
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        dfs(root,0);
        return minDeep;
    }
    public void dfs(TreeNode node,int deep){
        //如果结点为空，跳出
        if(node==null){
            return;
        }
        //不为空，代表有值，深度加1
        deep++;

        //如果左右节点为空，代表到了叶子节点，开始更新结果值
        if(node.left==null && node.right==null){
            //如果minDeep为0，代表之前没更新过，直接设值
            if(minDeep==0){
                minDeep=deep;
            }
            //其它情况，直接在结果值和深度之间取最小值
            minDeep=Math.min(minDeep,deep);
            return;
        }
        //开始继续往下递归左右子树
        dfs(node.left,deep);
        dfs(node.right,deep);
    }

    public static void main(String[] args) {
        L111 demo=new L111();
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);

        TreeNode node1=new TreeNode(20);
        root.right=node1;
        TreeNode node2=new TreeNode(15);
        TreeNode node3=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;

        System.out.println(demo.minDepth(root));
    }
}
