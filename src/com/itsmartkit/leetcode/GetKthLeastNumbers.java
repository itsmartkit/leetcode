package com.itsmartkit.leetcode;

import java.util.*;

/**
 * @author cyj
 * @name GetKthLeastNumbers
 * @description TODO 最小的K个数
 * @date 2020/5/18 15:15
 * Version 1.0
 */
public class GetKthLeastNumbers {

    /*
        输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
        提示：注意 n < k 及 k < 1 视为查不到
    */
    public ArrayList<Integer> getKthLeastNumbers(int[] input, int k) {
        if (input.length < k || k < 1) {
            return new ArrayList();
        }
        Queue<Integer> queue = new PriorityQueue<>(k, (n1, n2) -> Integer.compare(n2, n1));
        for (int i : input) {
            if (queue.size() < k) {
                queue.offer(i);
            } else {
                if (i < queue.peek()) {
                    queue.poll();
                    queue.offer(i);
                }
            }
        }
        return new ArrayList(queue);
    }

}