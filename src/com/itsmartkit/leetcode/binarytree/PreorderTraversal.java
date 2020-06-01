package com.itsmartkit.leetcode.binarytree;

import com.itsmartkit.leetcode.binarytree.common.TreeNode;

import java.util.*;

/**
 * @ClassName PreorderTraversal
 * @Description TODO 二叉树的前序遍历
 * @Author changyj
 * @Date 2020-06-01 00:14
 */
public class PreorderTraversal {

    // 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return res;
    }

    // 递归
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal1(TreeNode root) {

        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
        return res;
    }

}
