package com.itheima.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
单线程线程池(newSingleThreadExecutor)
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            es.submit(() -> System.out.println("线程名：" + Thread.currentThread().getName()));
        }
    }
    /*
    输出：
        线程名：pool-1-thread-1
        线程名：pool-1-thread-1
        线程名：pool-1-thread-1
        线程名：pool-1-thread-1
        线程名：pool-1-thread-1
        单线程的线程池又什么意义？
            1. 复用线程。
            2. 单线程的线程池提供了任务队列和拒绝策略（当任务队列满了之后（Integer.MAX_VALUE），新来的任务就会拒绝策略）

     */
}
