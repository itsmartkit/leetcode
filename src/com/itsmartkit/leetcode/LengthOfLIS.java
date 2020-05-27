package com.itsmartkit.leetcode;

/**
 * @author cyj
 * @name LengthOfLIS
 * @description TODO 最长上升子序列
 * @date 2020/5/27 16:47
 * Version 1.0
 */
public class LengthOfLIS {

    /*
        给定一个无序的整数数组，找到其中最长上升子序列的长度。
        思路：动态规划+二分查找
            新建数组 tails，用于保存最长上升子序列。
            对原序列进行遍历，将每位元素二分插入 tails 中。

            如果 tails 中元素都比它小，将它插到最后
            否则，用它覆盖掉比它大的元素中最小的那个。
     */
    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int[] tails = new int[nums.length];
        for (int num : nums) {
            int i = 0, j = maxLen;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (maxLen == j) {
                maxLen++;
            }
        }
        return maxLen;
    }

}