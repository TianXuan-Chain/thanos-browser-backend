package com.netease.thanos.common.utils;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * 类ThreadPoolGenerator.java 的实现描述: 线程池工具
 * Created by wangting04 on 2021/01/12
 */
public class ThreadPoolGenerator {

    //db查询线程池
    public final static ThreadPoolExecutor queryDBExecutor = new ThreadPoolExecutor(10, 20, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(200), new AbortPolicyWithoutException());

    private final static ForkJoinPool forkJoinPool = new ForkJoinPool();

    public static ForkJoinPool getForkJoinPool() {
        return forkJoinPool;
    }

    public static ForkJoinPool getForkJoinPool(int parallelism) {
        if (parallelism > 0) {
            return new ForkJoinPool(parallelism);
        }
        return forkJoinPool;
    }

    private static class AbortPolicyWithoutException implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {

        }
    }

    public static class AbortPolicyWithRetry implements RejectedExecutionHandler {

        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            e.execute(r);
        }
    }

    /**
     * 创建一个有buffer的threadpool，调用方做好生命周期管理
     *
     * @param name
     * @param core
     * @param max
     * @param buffSize
     * @return
     */
    public static ThreadPoolExecutor newCallerBuffQueuePool(String name, int core, int max, int buffSize) {
        BasicThreadFactory factory = new BasicThreadFactory.Builder().namingPattern(name + "-%d").daemon(false)
                .priority(Thread.NORM_PRIORITY).build();

        return new ThreadPoolExecutor(core, max, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(buffSize), factory,
                new ThreadPoolExecutor.CallerRunsPolicy());

    }

}
