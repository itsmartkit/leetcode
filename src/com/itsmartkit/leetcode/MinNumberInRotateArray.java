package com.itsmartkit.leetcode;

/**
 * @author cyj
 * @name MinNumberInRotateArray
 * @description TODO 旋转数组的最小数字
 * @date 2020/5/28 9:01
 * Version 1.0
 */
public class MinNumberInRotateArray {

    /*
        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
        例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
        示例 1：
            输入：[3,4,5,1,2]
            输出：1
        示例 2：
            输入：[2,2,2,0,1]
            输出：0
     */
    public int minNumberInRotateArray(int[] numbers) {
        int len = numbers.length;
        if (len == 0) {
            return len;
        }
        int left = 0, right = len - 1;
        int mid;
        while (left < right) {
            mid = (left + right) >>> 1;
            if (numbers[mid] > numbers[right]) {
                // mid 以及 mid 的左边一定不是最小数字
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                // 只能把 right 排除掉
                right--;
            } else {
                // mid 的右边一定不是最小数字，mid 有可能是
                right = mid;
            }
        }
        return numbers[left];
    }

}