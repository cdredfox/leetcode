/*
 * Copyright 2021-2022 www.xuyao.info
 */
package com.xuyao.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yangfei
 * @date 2022/7/3 - 17:40
 */
public class L199 {
    /**
     * BFS层次遍历
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        //定义一个队列，用来保存同一层的结点数据
        Queue<TreeNode> queue=new LinkedList<>();
        //先将root节点放到队列中，先进先出
        queue.offer(root);
        //如果队列不为空了，那代表所有的节点都遍历完了
        while(!queue.isEmpty()){
            //取当前队列的长度，即上一层节点的个数
            int size=queue.size();
            //开始循环处理
            for(int i=0;i<size;i++){
                //出队列
                TreeNode node=queue.poll();
                //如果节点的左节点不为空，则将该结点加入到队列中
                if(node.left!=null){
                    queue.offer(node.left);
                }
                //如果节点的右节点不为空，则将该结点加入到队列中
                if(node.right!=null){
                    queue.offer(node.right);
                }
                //以上几行代码，相当于将当前节点的下一层，从左到右放到队列中，全部循环完之后，相当于将下一层所有的结点都放到队列中了，下次循环

                //因为是要取最右边的结点，所以只要比较i的值，是不是最后一个，如果是的，则加到结果中就OK了
                if(i==size-1){
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L199 demo=new L199();
        TreeNode root=new TreeNode(1);
        TreeNode left1=new TreeNode(2);
        TreeNode right1=new TreeNode(3);
        TreeNode right2=new TreeNode(4);
        TreeNode right3=new TreeNode(5);
        //left1.right=right3;
        //right1.right=right2;
        left1.left=right2;
        root.left=left1;
        root.right=right1;
        Print.print(demo.rightSideView(root));
    }
}
