package com.itsmartkit.leetcode.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName SortedPrint
 * @Description TODO leetcode-1114: 按序打印
 * @Author changyj
 * @Date 2020-05-29 01:58
 */


/*
    我们提供了一个类：

        public class Foo {
          public void one() { print("one"); }
          public void two() { print("two"); }
          public void three() { print("three"); }
        }

    三个不同的线程将会共用一个 Foo 实例。
        线程 A 将会调用 one() 方法
        线程 B 将会调用 two() 方法
        线程 C 将会调用 three() 方法

    请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 */

// CountDownLatch
class SortedPrint1 {

    CountDownLatch c1 = new CountDownLatch(1);
    CountDownLatch c2 = new CountDownLatch(1);

    public SortedPrint1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        c1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        c1.await();
        printSecond.run();
        c2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c2.await();
        printThird.run();
    }
}

// Synchronized锁和控制变量
class SortedPrint2 {

    private int flag = 0;

    private Object lock = new Object();

    public SortedPrint2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (flag != 0) {
                lock.wait();
            }
            printFirst.run();
            flag = 1;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (flag != 1) {
                lock.wait();
            }
            printSecond.run();
            flag = 2;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (flag != 2) {
                lock.wait();
            }
            printThird.run();
            flag = 0;
            lock.notifyAll();
        }
    }
}
