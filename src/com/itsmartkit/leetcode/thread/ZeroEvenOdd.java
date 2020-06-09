package com.itsmartkit.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @ClassName ZeroEvenOdd
 * @Description TODO 打印零与奇偶数
 * @Author changyj
 * @Date 2020-06-06 02:21
 */

/*
    相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：

    线程 A 将调用 zero()，它只输出 0 。
    线程 B 将调用 even()，它只输出偶数。
    线程 C 将调用 odd()，它只输出奇数。
    每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。

    示例 1：
        输入：n = 2
        输出："0102"
        说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
    示例 2：
        输入：n = 5
        输出："0102030405"
 */
public class ZeroEvenOdd {

    private int n;

    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zero.acquire();
            System.out.print(0);
            if (i % 2 == 0) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even() throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            System.out.print(i);
            zero.release();
        }
    }

    public void odd() throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            System.out.print(i);
            zero.release();
        }
    }

}
