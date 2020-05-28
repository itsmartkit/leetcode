package com.itsmartkit.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName EvenOdd
 * @Description TODO 两线程交替打印奇偶数
 * @Author changyj
 * @Date 2020-05-29 02:26
 */

class PrintEvenOdd {

    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void print(int id) {

        lock.lock();
        try{
            while (id % 2 != num % 2) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t  " + num);
            num++;
            condition.signalAll();
        } catch (Exception ex) {

        } finally {
            lock.unlock();
        }
    }

}

public class EvenOdd {
    public static void main(String[] args) {
        PrintEvenOdd printEvenOdd = new PrintEvenOdd();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                printEvenOdd.print(1);
            }
        }, "thread-1").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                printEvenOdd.print(2);
            }
        }, "thread-2").start();
    }
}
