package com.netease.thanos.core.depositChain.util;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by hzxuyankang on 2017/7/25.
 */
public class ExecutorUtil {
    private final static ForkJoinPool forkJoinPool = new ForkJoinPool();

    public static ForkJoinPool getForkJoinPool() {
        return forkJoinPool;
    }

    public final static ThreadPoolTaskExecutor executorService;

    static {
        executorService = new ThreadPoolTaskExecutor();
        executorService.setCorePoolSize(20);
        executorService.setMaxPoolSize(20);
        executorService.initialize();
    }
}
