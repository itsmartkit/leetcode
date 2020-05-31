package com.itsmartkit.leetcode.binarytree;

import com.itsmartkit.leetcode.binarytree.common.TreeNode;
import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cyj
 * @name MaxDepth
 * @description TODO 二叉树的最大深度/最大路径
 * @date 2020/5/13 13:39
 * Version 1.0
 */
public class MaxDepth {

    /*
        输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

        例如：

        给定二叉树 [3,9,20,null,null,15,7]，

            3
           / \
          9  20
            /  \
           15   7
        返回它的最大深度 3 。
     */
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    /*
     * 递归
     */
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }

    /*
     * 栈
     */
    public int depth1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Deque<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.push(new Pair<>(root, 1));
        int h = 1;
        Pair<TreeNode, Integer>  pair = null;
        while (!stack.isEmpty()) {
            pair = stack.pop();
            h = Math.max(h, pair.getValue());
            if (pair.getKey().left != null) {
                stack.push(new Pair<>(pair.getKey().left, pair.getValue() + 1));
            }
            if (pair.getKey().right != null) {
                stack.push(new Pair<>(pair.getKey().right, pair.getValue() + 1));
            }
        }
        return h;

    }

}