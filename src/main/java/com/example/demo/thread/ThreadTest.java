package com.example.demo.thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : coder
 * @create 2021/1/21 14:23
 */
public class ThreadTest {
    private static final int nThreads = Runtime.getRuntime().availableProcessors();
    private static final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("demo-pool-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(nThreads, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(9,8,6,7,0,1, 2, 3, 4, 5);
        pool.submit(() -> {
            for (int i = 0; i < integers.size(); i++) {
                System.out.println(integers.get(i));
            }
        });
    }

}
