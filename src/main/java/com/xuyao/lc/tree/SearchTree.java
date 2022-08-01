/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc.tree;

import com.xuyao.lc.TreeNode;

/**
 * 搜索二叉树
 * @author yangfei
 * @date 2022/5/10 - 15:16
 */
public class SearchTree {

    public int preValue=Integer.MIN_VALUE;

    /**
     * 检查是否是搜索二叉树
     * @param head
     * @return
     */
    public boolean checkBST(TreeNode head){
        if(head==null){
            return false;
        }
        boolean leftCheck = checkBST(head.left);
        if(!leftCheck){
            return false;
        }
        if(head.val<=preValue){
            return false;
        }else{
            preValue=head.val;
        }
        return checkBST(head.right);
    }

}
