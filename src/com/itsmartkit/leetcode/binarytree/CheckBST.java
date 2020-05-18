package com.itsmartkit.leetcode.binarytree;

import com.itsmartkit.leetcode.binarytree.common.TreeNode;

/**
 * @author cyj
 * @name CheckBST
 * @description TODO 检查是否为BST（二叉查找树）
 * @date 2020/5/18 16:02
 * Version 1.0
 */
public class CheckBST {

    /*
        请实现一个函数，检查一棵二叉树是否为二叉查找树。
        给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
    */
    public boolean checkBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean check(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return check(root.left, min, root.val)
                && check(root.right, root.val, max);
    }

}