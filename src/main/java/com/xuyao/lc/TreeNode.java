/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;

/**
 * @author yangfei
 * @date 2022/5/10 - 15:17
 */
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
     }
  }
