package com.itsmartkit.leetcode.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SemaphoreDemo
 * @Description TODO 控制并发线程数量
 * @Author changyj
 * @Date 2020-05-31 17:49
 */


/*
 * 提供一个医院类，这个类有一个核心的方法给外部调用，这个方法实现如下功能：
 *    5 个医生，每个医生可以挂 10 个号，然后医院有 10 个窗口，也就意味着同时只能有 10 个病人挂号，
 *    那第 11 个人要挂号的话就不能立刻拿到号，得前面的用户挂完号才可以挂号，病人挂号的时候，医院给病人返回的结果是：
 *       1. 如果当前有空余号可用，就取最前的号；
 *       2. 如果没有号，就给调用的病人返回没有号的错误。
 *   注意：如果有号的话是不能允许返回给病人说没号，如何设计这个类以及这个类中的方法。
 */

class Hospital {

    // 医生数量
    private int doctor;
    // 每个医生可以挂几个号
    private int threshold;

    private AtomicInteger sequence;

    private Semaphore semaphore;

    public Hospital(int window, int doctor, int threshold) {
        // this.window = window;
        this.doctor = doctor;
        this.threshold = threshold;
        sequence = new AtomicInteger();
        semaphore = new Semaphore(window);
    }

    public int register() {
        if (sequence.get() >= doctor * threshold) {
            return -1;
        }
        try {
            semaphore.acquire();
            int no = sequence.incrementAndGet();
            semaphore.release();
            return no;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }

}


public class SemaphoreDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                30,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(10000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        int count = 100;
        CountDownLatch latch = new CountDownLatch(count);
        Hospital hospital = new Hospital(10,5,10);
        for (int i = 0; i < count; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                    System.out.println(Thread.currentThread().getName()+ "\t" + hospital.register());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            latch.countDown();
        }
    }
}
