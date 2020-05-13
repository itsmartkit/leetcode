package com.itsmartkit.leetcode.binarytree;

import com.itsmartkit.leetcode.binarytree.common.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

/**
 * @author cyj
 * @name MaxDepth
 * @description TODO
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
    public int depth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
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