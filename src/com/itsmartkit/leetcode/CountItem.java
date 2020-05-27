package com.itsmartkit.leetcode;

import java.util.Arrays;

/**
 * @author cyj
 * @name CountItem
 * @description TODO 统计正整数数组中各个元素出现的次数
 * @date 2020/5/27 17:14
 * Version 1.0
 */
public class CountItem {

    /*
        一个正数数组，长度为N，且数组元素<N，统计每个正数出现的次数，
        要求时间复杂度O(n)，空间复杂度O(1)。
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 4, 5, 5, 5, 4, 5, 7};
        System.out.println(Arrays.toString(countItem(nums)));
    }

    public static int[] countItem(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int temp = nums[i] - 1;
            if (temp < 0) {
                // 已处理
                i++;
                continue;
            }
            if (nums[temp] > 0) {
                // 第一次处理
                nums[i] = nums[temp];
                nums[temp] = -1;
            } else {
                // 已经不是第一次处理
                nums[temp]--;
                nums[i] = 0;
            }
        }
        return nums;
    }

}