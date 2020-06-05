package com.itsmartkit.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName ThreeSum
 * @Description TODO
 * @Author changyj
 * @Date 2020-05-12 00:34
 */
public class ThreeSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arrs = new int[n];
        for (int i = 0; i < n; i++) {
            arrs[i] = sc.nextInt();
        }
        Arrays.sort(arrs);
        if (n < 3 || arrs[0] > k) {
            return;
        }
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && (arrs[i] == arrs[i - 1])) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arrs[i] + arrs[left] + arrs[right];
                if (sum == k) {
                    System.out.print(arrs[i] + " " + arrs[left] + " " + arrs[right] + "\n");
                    while ((left + 1) < right && arrs[left] == arrs[left + 1]) {
                        left++;
                    }
                    while (left < (right - 1) && arrs[right] == arrs[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > k) {
                    right--;
                } else {
                    left++;
                }
            }
        }
    }


    /*
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    示例：
        给定数组 nums = [-1, 0, 1, 2, -1, -4]，
        满足要求的三元组集合为：
        [
          [-1, 0, 1],
          [-1, -1, 2]
        ]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> allRes = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 3 || nums[0] > 0) {
            return allRes;
        }
        List<Integer> res = null;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    allRes.add(res);
                    while ((left + 1) < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < (right - 1) && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return allRes;
    }


}
