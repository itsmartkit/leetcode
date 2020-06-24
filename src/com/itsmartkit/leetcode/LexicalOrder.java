package com.itsmartkit.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyj
 * @name LexicalOrder
 * @description TODO 字典序排数
 * @date 2020/6/24 16:10
 * Version 1.0
 */
public class LexicalOrder {

    /*
        给定一个整数 n, 返回从 1 到 n 的字典顺序。
        例如，给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
        请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
    */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        // 保存现在整数
        int temp = 0;
        dfs(n, 0, res);
        return res;
    }

    public void dfs(int n, int tmp, List<Integer> res) {
        if (tmp > n) return;
        for (int i = 0; i <= 9; i++) {
            int pre = tmp; // 返回时还原tmp值
            tmp = tmp * 10 + i;
            if (tmp == 0) { // 去掉0特殊值
                continue;
            }
            if (tmp > n) {
                return;
            }
            res.add(tmp);
            dfs(n, tmp, res);
            tmp = pre;
        }
    }

}