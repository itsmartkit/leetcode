package com.itsmartkit.leetcode;

/**
 * @ClassName FirstMissingPositive
 * @Description TODO 缺失的第一个正数
 * @Author changyj
 * @Date 2020-05-14 01:38
 */
public class FirstMissingPositive {

    /*
        给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

        示例 1:

        输入: [1,2,0]
        输出: 3
        示例 2:

        输入: [3,4,-1,1]
        输出: 2
        示例 3:

        输入: [7,8,9,11,12]
        输出: 1
     */
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        byte[] bucket = new byte[size];
        for (int num : nums) {
            if (num <= 0 || num > size) {
                continue;
            }
            bucket[num - 1] = 1;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                return i + 1;
            }
        }
        return size + 1;
    }

}
