package com.itsmartkit.leetcode;

import java.util.Arrays;

/**
 * @author cyj
 * @name QuickSort
 * @description TODO 快速排序
 * @date 2020/6/2 16:48
 * Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int m = partition(arr, lo, hi);
        sort(arr, lo, m - 1);
        sort(arr, m + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int temp = arr[lo];
        while (true) {
            while (less(arr[++i], temp)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(temp, arr[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    public static boolean less(int a, int b) {
        return a < b;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}