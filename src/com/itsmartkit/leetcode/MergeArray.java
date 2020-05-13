package com.itsmartkit.leetcode;

/**
 * @author cyj
 * @name MergeArray
 * @description TODO
 * @date 2020/5/13 15:38
 * Version 1.0
 */
public class MergeArray {

    /*
        给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

        初始化 A 和 B 的元素数量分别为 m 和 n。

        示例:

        输入:
        A = [1,2,3,0,0,0], m = 3
        B = [2,5,6],       n = 3

        输出: [1,2,2,3,5,6]
        说明:

        A.length == n + m
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[i + j + 1] = A[i--];
            } else {
                A[i + j + 1] = B[j--];
            }
        }
        while (j >= 0) {
            A[j] = B[j--];
        }
    }

}