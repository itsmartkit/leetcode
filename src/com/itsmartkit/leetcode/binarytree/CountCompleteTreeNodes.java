package com.itsmartkit.leetcode.binarytree;

import com.itsmartkit.leetcode.binarytree.common.TreeNode;

/**
 * @author cyj
 * @name CountCompleteTreeNodes
 * @description TODO 完全二叉树的节点个数
 * @date 2020/6/24 15:17
 * Version 1.0
 */
public class CountCompleteTreeNodes {

    /*
        给出一个完全二叉树，求出该树的节点个数。
        说明：
            完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
            并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
        示例:
        输入:
                1
                / \
                2   3
                / \  /
                4  5 6
        输出: 6
    */

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rootHeight = getHeight(root);
        int rightHeight = getHeight(root.right);
        if (rootHeight == rightHeight + 1) {
            //左子树为满二叉树
            return (int) Math.pow(2, rootHeight - 1) + countNodes(root.right);
        } else {
            //rootHeight == rightHeight + 2 右子树为满二叉树
            return (int) Math.pow(2, rootHeight - 2) + countNodes(root.left);
        }
    }

    public int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

}