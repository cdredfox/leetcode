/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc.tree;

/**
 * @author yangfei
 * @date 2022/5/10 - 15:17
 */
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
     }
  }
