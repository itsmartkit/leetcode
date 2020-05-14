package com.itsmartkit.leetcode.binarytree;

/**
 * @ClassName BalancedBinaryTree
 * @Description TODO
 * @Author changyj
 * @Date 2020-05-11 01:50
 */
public class BalancedBinaryTree {

    /*
        给定一个二叉树，判断它是否是高度平衡的二叉树。

        本题中，一棵高度平衡二叉树定义为：

        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

        示例 1:

        给定二叉树 [3,9,20,null,null,15,7]

                3
                / \
                9  20
                /  \
                15   7
        返回 true 。
    */

    public boolean isBalanced(TreeNode root) {
        return isAVL(root, new int[] {0});
    }

    public boolean isAVL(TreeNode root, int[] depth) {
        if (root == null) {
            return true;
        }
        int[] left = new int[]{0},right = new int[]{0};
        if (isAVL(root.left, left) && isAVL(root.right, right)) {
            int gap = left[0]-right[0];
            if (gap <= 1 && gap >= -1) {
                depth[0] = left[0] > right[0] ? left[0]+1:right[0]+1;
                return true;
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}

