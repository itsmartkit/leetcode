package com.itsmartkit.leetcode.binarytree;

import com.itsmartkit.leetcode.binarytree.common.TreeNode;

/**
 * @author cyj
 * @name LongestUnivaluePath
 * @description TODO 最长同值路径
 * @date 2020/5/14 16:06
 * Version 1.0
 */
public class LongestUnivaluePath {

    /*
        给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
        注意：两个节点之间的路径长度由它们之间的边数表示。

        示例 1:
        输入:
                      5
                     / \
                    4   5
                   / \   \
                  1   1   5
        输出:
        2
        示例 2:
        输入:
                      1
                     / \
                    4   5
                   / \   \
                  4   4   5
        输出:
        2
     */

    int res;

    public int longestUnivaluePath(TreeNode root) {
        maxLength(root);
        return res;
    }

    public int maxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxLength(root.left);
        int right = maxLength(root.right);

        int leftLength = 0, rightLength = 0;
        if (root.left != null && root.left.val == root.val) {
            leftLength += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightLength += right + 1;
        }
        res = Math.max(res, leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }

}