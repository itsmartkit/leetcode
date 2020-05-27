package com.itsmartkit.leetcode.binarytree;

import com.itsmartkit.leetcode.binarytree.common.TreeNode;

import java.util.ArrayList;

/**
 * @author cyj
 * @name FindPath
 * @description TODO 二叉树中和为某一值的路径
 * @date 2020/5/27 15:23
 * Version 1.0
 */
public class FindPath {

    /*
        输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        findPath(root, target);
        return res;
    }

    public void findPath(TreeNode root, int target) {
        path.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            res.add(new ArrayList(path));
        }
        // 左子树
        if (root.left != null) {
            findPath(root.left, target - root.val);
        }
        // 右子树
        if (root.right != null) {
            findPath(root.right, target - root.val);
        }
        // 回退
        path.remove(path.size() - 1);
    }

}