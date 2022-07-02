/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangfei
 * @date 2022/7/2 - 20:34
 */
public class L94 {


    /**
     * 迭代方法
     * 从根结点开始，一路遍历左节点，然后每次将节点入栈，至到为空
     * 为空后，弹出当前顶上的结点，将结点的值放到结果列表中，然后移动到右节点，循环开始
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result=new ArrayList<>();
        TreeNode current=root;
        Stack<TreeNode> stack=new Stack<>();
        while(current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();
            result.add(current.val);
            current=current.right;
        }
        return result;
    }

    /**
     * 中序遍历的顺序是 左中右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        inorder(root,result);
        return result;
    }

    public void inorder(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }

        if(root.left!=null){
            inorder(root.left,result);
        }
        result.add(root.val);
        if(root.right!=null){
            inorder(root.right,result);
        }
    }

    public static void main(String[] args) {
        L94 demo=new L94();
        TreeNode root=new TreeNode(1);
        TreeNode right=new TreeNode(2);
        TreeNode left1=new TreeNode(3);
        right.left=left1;
        root.right=right;
        Print.print(demo.inorderTraversal(root));
        System.out.printf("===========================\n");
        Print.print(demo.inorderTraversal2(root));
    }
}
