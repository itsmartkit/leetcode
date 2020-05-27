package com.itsmartkit.leetcode.dp;

import java.util.Arrays;

/**
 * @ClassName CoinChange
 * @Description TODO 零钱兑换
 * @Author changyj
 * @Date 2020-05-27 22:49
 */
public class CoinChange {


    /*
        给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
        如果没有任何一种硬币组合能组成总金额，返回 -1。

        示例 1:
            输入: coins = [1, 2, 5], amount = 11
            输出: 3
            解释: 11 = 5 + 5 + 1
        示例 2:
            输入: coins = [2], amount = 3
            输出: -1

     */

    /**
     * 动态规划算法思想： 将一个大问题分解成多个小问题，分别求解小问题，大问题的解可以由小问题的推出
     */
    public int coinChange(int[] coins, int amount) {

        int[] f = new int[amount + 1];
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int cost = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (f[i - coins[j]] != Integer.MAX_VALUE) {
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                    }
                }
            }
            f[i] = cost;
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }


    /**
     * DFS + 剪枝
     * <p>
     * 1.当 amount==0 时剪枝，因为大面值硬币需要更多小面值硬币替换，
     * 继续减少一枚或几枚大硬币搜索出来的答案【如果有】肯定不会更优。
     * <p>
     * 2.当 amount!=0，但已经使用的硬币数 cnt 满足了 cnt+1>=anscnt 时剪枝，
     * 因 amount 不为 0，至少还要使用 1 枚硬币，则继续搜索得到的答案不会更优。
     */
    int ans = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dfs(int[] coins, int index, int amount, int cnt) {
        if (index < 0) {
            return;
        }
        for (int c = amount / coins[index]; c >= 0; c--) {
            int na = amount - c * coins[index];
            int ncnt = cnt + c;
            //剪枝1
            if (na == 0) {
                ans = Math.min(ans, ncnt);
                break;
            }
            //剪枝2
            if (ncnt + 1 >= ans) {
                break;
            }
            dfs(coins, index - 1, na, ncnt);
        }
    }


}
