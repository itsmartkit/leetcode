package com.itsmartkit.leetcode.binarytree;

import com.itsmartkit.leetcode.binarytree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cyj
 * @name LevelOrder
 * @description TODO 二叉树层序遍历
 * @date 2020/5/13 11:39
 * Version 1.0
 */
public class LevelOrder {

    /*
        给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

        示例：
        二叉树：[3,9,20,null,null,15,7],

                3
                / \
                9  20
                /  \
                15   7
        返回其层次遍历结果：

                [
                [3],
                [9,20],
                [15,7]
                ]
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

}