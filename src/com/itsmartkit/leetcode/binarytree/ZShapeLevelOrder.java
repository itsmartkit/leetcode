package com.itsmartkit.leetcode.binarytree;

import com.itsmartkit.leetcode.binarytree.common.TreeNode;

import java.util.*;

/**
 * @ClassName ZShapeLevelOrder
 * @Description TODO 按之/Z字形顺序打印二叉树
 * @Author changyj
 * @Date 2020-05-15 23:42
 */
public class ZShapeLevelOrder {

    /*

        请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

        例如:
        给定二叉树: [3,9,20,null,null,15,7],

                3
                / \
                9  20
                /  \
                15   7
        返回其层次遍历结果：

                [
                [3],
                [20,9],
                [15,7]
                ]
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int rows = 1;
        List<Integer> list;
        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (rows % 2 == 0) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            rows++;
            res.add(list);
        }
        return res;
    }

}
