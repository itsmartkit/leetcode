package com.itsmartkit.leetcode;

/**
 * @ClassName BinarySearch
 * @Description TODO 二分查找
 * @Author changyj
 * @Date 2020-05-15 23:48
 */
public class BinarySearch {


    /*
        给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
        写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return -1;
    }

}
