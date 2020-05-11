package com.itsmartkit.leetcode;

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
        for (int i = 0; i < n - 2; i++) {
            if (i >= 1 && (arrs[i] == arrs[i + 1])) {
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

}
