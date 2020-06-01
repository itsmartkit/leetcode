package com.itsmartkit.leetcode.thread;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName RateLimiter
 * @Description TODO 限流: 1 秒内限制 n 个请求
 * @Author changyj
 * @Date 2020-05-29 19:59
 */

/*
    思路：令牌桶限流算法，定时任务 + 阻塞队列
 */
public class RateLimiter {

    private int threshold;

    private ScheduledExecutorService scheduler;

    private Map<String, LinkedBlockingQueue<Boolean>> map = new ConcurrentHashMap();

    private final int time;

    public RateLimiter(int threshold) {

        if (threshold < 1) {
            threshold = 1;
        }
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.threshold = threshold;
        this.time = 1000 * 1000 / threshold;

        scheduler.scheduleAtFixedRate(() -> {
            for (String key : map.keySet()) {
                map.get(key).offer(true);
            }
        }, 0, time, TimeUnit.MICROSECONDS);
    }

    public boolean acquire(String api) throws InterruptedException {
        if (!map.containsKey(api)) {
            synchronized (this) {
                if (!map.containsKey(api)) {
                    map.put(api, new LinkedBlockingQueue<>(threshold));
                }
            }
        }
        return map.get(api).take();
    }

}

/**
 * @ClassName TestRateLimiter
 * @description //TODO 限流工具测试类
 * @author changyj
 * @date 2020-05-30 00:34
 */
class TestRateLimiter {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                1000,
                30,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(1000000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        RateLimiter limiter = new RateLimiter(1000);

        final int count = 10000;
        final long[] time = new long[2];
        CountDownLatch latch = new CountDownLatch(count);
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < count; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                    if (limiter.acquire("main")) {
                        System.out.println(Thread.currentThread().getName());
                        int n = atomicInteger.incrementAndGet();
                        if (n == 1) {
                            time[0] = System.currentTimeMillis();
                        }
                        if (n == count) {
                            time[1] = System.currentTimeMillis();
                            System.out.println("用时：" + (time[1] - time[0]) / 1000.0 + "s");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            latch.countDown();
        }
    }
}
