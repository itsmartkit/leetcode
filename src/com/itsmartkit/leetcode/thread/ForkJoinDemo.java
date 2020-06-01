package com.itsmartkit.leetcode.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author cyj
 * @name ForkJoinTask
 * @description TODO ForkJoin框架
 * @date 2020/5/29 16:34
 * Version 1.0
 */

/*
    给定n个任务，每次批量处理m个任务，每个任务返回值是int类型，将批量处理的任务结果累加起来，用最短的时间完成这n个任务
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private Integer[] data;
    private int m;

    public ForkJoinDemo(Integer[] data, int m) {
        this.data = data;
        this.m = m;
    }

    @Override
    protected Integer compute() {
        if (data.length <= m) {
            return doSum(data);
        } else {
            int mid = data.length / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(Arrays.copyOfRange(data, 0, mid), m);
            ForkJoinDemo task2 = new ForkJoinDemo(Arrays.copyOfRange(data, mid, data.length), m);
            invokeAll(task1, task2);
            return task1.join() + task2.join();
        }
    }

    private int doSum(Integer[] data) {
        int sum = 0;
        for (int d : data) {
            sum += d;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            list.add(i);
        }
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> result = pool.submit(new ForkJoinDemo(list.toArray(new Integer[list.size()]), 10000));
        try {
            System.out.println((list.get(0) + list.get(list.size() - 1)) * list.size() / 2);
            long s = System.currentTimeMillis();
            System.out.println(result.get());
            System.out.println(System.currentTimeMillis() - s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}