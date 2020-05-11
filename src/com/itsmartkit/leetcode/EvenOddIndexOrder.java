package com.itsmartkit.leetcode;

import java.util.Scanner;

/**
 * @author cyj
 * @name EvenOddIndexOrder
 * @description TODO
 * @date 2020/5/11 15:33
 * Version 1.0
 */
public class EvenOddIndexOrder {

    /*
        给定一个长度不小于2的数组arr，实现一个函数调整arr，要么让所有的偶数下标都是偶数，要么让所有的奇数下标都是奇数
        注意：1、数组下标从0开始！
        输入描述:
            第一行一个整数N。表示数组长度
            接下来一行N个整数表示数组内的数
        输出描述:
            输出N个整数。表示调整后的数组
            示例1
        输入
            5
            1 2 3 4 5
        输出
            2 1 4 3 5
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int even = 0;
        int odd = 1;
        while(true) {
            while(even < n) {
                if (nums[even] % 2 == 0) {
                    even += 2;
                } else {
                    break;
                }
            }
            while(odd < n) {
                if (nums[odd] % 2 == 1) {
                    odd += 2;
                } else {
                    break;
                }
            }
            if (even >= n || odd >=n ) {
                break;
            }
            swap(nums, even , odd);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}