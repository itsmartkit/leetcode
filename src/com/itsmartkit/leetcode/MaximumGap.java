package com.itsmartkit.leetcode;

/**
 * @author cyj
 * @name MaximumGap
 * @description TODO 无序数组排序后的最大相邻差值/最大间距
 * @date 2020/5/25 13:32
 * Version 1.0
 */
public class MaximumGap {

    /*
        给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
        如果数组元素个数小于 2，则返回 0。
        示例 1:
        输入: [3,6,9,1]
        输出: 3
        解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
        示例 2:
        输入: [10]
        输出: 0
        解释: 数组元素个数小于 2，因此返回 0。
        说明:
        你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
        请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = -1;
        int min = Integer.MAX_VALUE;
        //找到最小值、最大值
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if (min == max) {
            return 0;
        }
        //计算桶大小，桶数量至少一个
        int bucketSize = (max - min) / nums.length + 1;
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        //入桶,每个桶只关心桶内的最大值和最小值
        int idx = -1;
        for (int i : nums) {
            idx = (i - min) / bucketSize;
            if (buckets[idx] == null) {
                buckets[idx] = new Bucket();
            }
            buckets[idx].min = Math.min(buckets[idx].min, i);
            buckets[idx].max = Math.max(buckets[idx].max, i);
        }
        //前一个桶的 max
        int preMax = buckets[0].max;
        ;
        //最大间隔
        int maxGap = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].min - preMax > maxGap) {
                maxGap = buckets[i].min - preMax;
            }
            //记录前一个桶的 max
            preMax = buckets[i].max;
        }
        return maxGap;
    }

    private static class Bucket {
        int min = Integer.MAX_VALUE;
        int max = -1;
    }

}