package com.lxg.problem.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**************************
 * @description: SelfThreadPool
 * @author: xuegangliu
 * @date: 2019/3/19 17:34
 ***************************/
public final class SelfThreadPool {

    private static Integer core = Runtime.getRuntime().availableProcessors();

    public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(core);
    public static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
}
